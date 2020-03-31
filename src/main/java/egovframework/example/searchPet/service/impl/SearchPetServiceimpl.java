package egovframework.example.searchPet.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import egovframework.example.common.Appserver;
import egovframework.example.common.util.JsonUtil;
import egovframework.example.searchPet.service.SearchPetService;
import egovframework.example.searchPet.service.SearchPetVO;

@Service
public class SearchPetServiceimpl implements SearchPetService{
	
	@Resource
	private Appserver appserver;

	@Resource
	private SearchPetMapper searchPetMapper;

	@Override
	public List<Map<String, String>> selectPetList(Map<String, Object> map) throws Exception {
		
		return searchPetMapper.selectPetList(map);
	
	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONObject selectFirstCodeList(Map<String, Object> map) throws Exception{
		JSONObject jsonObj = new JSONObject();
		
		try {
			
			jsonObj.put("codeList", searchPetMapper.selectFirstCodeList(map));
			jsonObj.put("status", "SUCCESS");
		} catch (Exception e) {
			
			jsonObj.put("status", "ERROR");
			System.out.println(e.toString());
		}
		
		return jsonObj;
	}

	@Override
	public int selectPetListCount(Map<String, Object> map) throws Exception {
		return searchPetMapper.selectPetListCount(map);
	}

}
