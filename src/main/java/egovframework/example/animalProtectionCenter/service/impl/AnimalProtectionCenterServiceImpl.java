package egovframework.example.animalProtectionCenter.service.impl;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import egovframework.example.animalProtectionCenter.service.AnimalProtectionCenterService;
import egovframework.example.common.Appserver;
import egovframework.example.common.util.JsonUtil;
import egovframework.example.common.util.commonUtil;

@Service
public class AnimalProtectionCenterServiceImpl implements AnimalProtectionCenterService{

	@Resource(name = "appserver")
	protected Appserver appserver;
	
	@SuppressWarnings("unchecked")
	@Override
	public String selectAnimalProList(Map<String, Object> param) throws Exception {
			
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("baseURL", "animalShelterSrvc/");
		paramMap.put("gubun", "shelterInfo");
		paramMap.put("pageNo", param.get("page"));
		paramMap.put("numOfRows", param.get("rows"));

		if (param.containsKey("param")) {
			
			ObjectMapper mapper = new ObjectMapper(); 
			
			 //JSON string to Map 
			Map<String, String> map = mapper.readValue(param.get("param").toString(), Map.class);
			
			if (map.containsKey("care_nm")) {
				paramMap.put("care_nm", map.get("care_nm"));
			}
			
			if (map.containsKey("care_reg_no")) {
				paramMap.put("care_reg_no", map.get("care_reg_no"));
			}
		}
		
		System.out.println(paramMap);
		
		Map<String, Object> petReApiList  = appserver.getOpenApi(paramMap);
		Map<String, Object> petReList = commonUtil.getApiDataGridForm(petReApiList, "recordAgency");
		
		
		return JsonUtil.MapToJson(petReList);
	}

}
