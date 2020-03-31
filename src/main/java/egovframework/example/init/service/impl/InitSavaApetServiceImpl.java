package egovframework.example.init.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import egovframework.example.common.Appserver;
import egovframework.example.common.util.commonUtil;
import egovframework.example.init.service.InitSavaApetService;

@Service
public class InitSavaApetServiceImpl implements InitSavaApetService {
	
	@Resource(name = "appserver")
	protected Appserver appserver;

	@Resource(name="initMapper")
	private InitSavaApetMapper initMapper;
	
	@Override
	@Transactional(rollbackOn =Exception.class) 
	public void initsaveApetService() throws Exception {
		
		/*-----------------initsaveApetService Start------------------------*/
		// 디비 초기화
		deleteSaveApetDB();
		
		// 시도, 시군구, 보호소 코드값 api -> db
		insertCodeTbl();
		
		// 유기동물 디비 밀어넣기
		insertAnimalKnInfoParamSet();

	}
	
	@Transactional
	private Map<String, Object> insertCodeTbl() throws Exception {
		
//		1. 시도 sido
		Map<String, Object> sidoMap = new HashMap<String, Object>();
		sidoMap.put("baseURL", "abandonmentPublicSrvc/");
		sidoMap.put("gubun", "sido");
		
		Map<String, Object> sidoApiList  = appserver.getOpenApi(sidoMap);
		List<Map<String, Object>> sidoList = commonUtil.getApiData(sidoApiList);
		 
		for (Map<String, Object> sido : sidoList) {
			initMapper.insertSidoCode(sido);
		}
		
//		2. 시군구 sigungu
		Map<String, Object> sigunguMap = new HashMap<String, Object>();
		sigunguMap.put("baseURL", "abandonmentPublicSrvc/");
		sigunguMap.put("gubun", "sigungu");
		
		for (Map<String, Object> sido : sidoList) {
			 
			sigunguMap.put("upr_cd", sido.get("orgCd"));
			Map<String, Object> sigunguData  = appserver.getOpenApi(sigunguMap);
			List<Map<String, Object>> sigunguList = commonUtil.getApiData(sigunguData);
			
			for (Map<String, Object> sigungu : sigunguList) {
				 
				initMapper.insertSigunguCode(sigungu);
				
//				3. 보호소 shelter
				HashMap<String, Object> shelterMap = new HashMap<String, Object>();
				shelterMap.put("baseURL", "abandonmentPublicSrvc/");
				shelterMap.put("gubun", "shelter");
				shelterMap.put("upr_cd", sigungu.get("uprCd")); // 시도코드
				shelterMap.put("org_cd", sigungu.get("orgCd")); // 시군구코드
				
				Map<String, Object> shelterData  = appserver.getOpenApi(shelterMap);
				List<Map<String, Object>> shelterList = commonUtil.getApiData(shelterData);

				for (Map<String, Object> shelter : shelterList) {
					
					shelter.put("uprCd", sigungu.get("uprCd"));
					shelter.put("orgCd", sigungu.get("orgCd"));
					initMapper.insertShelterCode(shelter);
				}
			}
		}
	
		return null;
	}
	
	// 유기동물데이터 set
	private void insertAnimalKnInfoParamSet() throws Exception {
		List<Map<String, Object>> insertList = new ArrayList<Map<String, Object>>();
		
		// 축종코드
		String[] upkindList = {"417000","422400","429900"};

		// 시도, 시군구, 보호소번호
		List<Map<String, Object>> codeList = initMapper.selectCodeTbl("2");
		
		for (String upkind : upkindList) {
			
			for (Map<String, Object> code : codeList) {
				HashMap<String, Object> paramMap = new HashMap<String, Object>();
				paramMap.put("upkind", upkind);
				paramMap.put("upr_cd", code.get("first_code"));
				paramMap.put("org_cd", code.get("second_code"));
				paramMap.put("care_reg_no", code.get("code"));
				paramMap.put("gubun", "abandonmentPublic");
				paramMap.put("bgnde", "20160101");
				paramMap.put("endde", "20200630");
				
				// 유기동물 api 검색
				Map<String, Object> abandonmentPublic  = appserver.getOpenApi(paramMap);
				List<Map<String, Object>> animalList = commonUtil.getApiData(abandonmentPublic);
				
				// 유기동물 api -> db
				for (Map<String, Object> animal : animalList) {
					animal.put("upkindCd", upkind);
					animal.put("uprCd", paramMap.get("first_code"));
					animal.put("orgCd", paramMap.get("second_code"));
					animal.put("careRegNo", paramMap.get("code"));
					animal.put("processStateCd", animal.get("processState").equals("보호중") ? '1' : '0');
					
					// 보호소 위도 , 경도 구하기
					HashMap<String, Object> param = new HashMap<String, Object>();
					param.put("address", animal.get("careAddr"));
					JSONObject addrApi = appserver.getApi(param);
					JSONArray jsonArray = (JSONArray) addrApi.get("documents");

					if (jsonArray.size() != 0) {
						
						JSONObject documents = (JSONObject) jsonArray.get(0);
						JSONObject address = (JSONObject) documents.get("address");
						
						animal.put("latitude", address.get("x"));	 // 위도
						animal.put("longitude", address.get("y")); // 경도
					}
					
					insertList.add(animal);
				}
			}
		}
		
		insertAnimalKnInfo(insertList);
		/*-----------------initsaveApetService End------------------------*/
	}
	
	// 유기동물데이터insert
	private void insertAnimalKnInfo(List<Map<String, Object>> animalList) throws Exception {
		
		for (Map<String, Object> animal : animalList) {
			initMapper.insertAnimalknList(animal);
		}
	}
	
	private void deleteSaveApetDB() {
		initMapper.deleteCodeTbl();
		initMapper.deleteAnimalknTbl();
	}

}
