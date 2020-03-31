package egovframework.example.petRegistrationSystem.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import egovframework.example.common.Appserver;
import egovframework.example.common.util.JsonUtil;
import egovframework.example.common.util.commonUtil;
import egovframework.example.petRegistrationSystem.service.PetRegistrationSystemService;

@Service
public class PetRegistrationSystemServiceImpl implements PetRegistrationSystemService{

	@Resource(name = "appserver")
	protected Appserver appserver;
	
	@SuppressWarnings("unchecked")
	@Override
	public String selectPetReSystemList(Map<String, Object> param) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("baseURL", "recordAgencySrvc/");
		paramMap.put("gubun", "recordAgency");
		paramMap.put("pageNo", param.get("page"));
		paramMap.put("numOfRows", param.get("rows"));
		

		if (param.containsKey("param")) {
			
			ObjectMapper mapper = new ObjectMapper(); 
			 //JSON string to Map 
			Map<String, String> map = mapper.readValue(param.get("param").toString(), Map.class);
			
			if (map.containsKey("addr")) {
				paramMap.put("addr", map.get("addr"));
			}
			if (map.containsKey("orgNm")) {
				paramMap.put("orgNm", map.get("orgNm"));
			}
		}
		
		System.out.println(paramMap);
		
		Map<String, Object> petReApiList  = appserver.getOpenApi(paramMap);
		Map<String, Object> petReList = commonUtil.getApiDataGridForm(petReApiList, "recordAgency");
		
		
		return JsonUtil.MapToJson(petReList);
	}

}
