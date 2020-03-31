package egovframework.example.searchPet.service;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;

public interface SearchPetService {
	
	List<Map<String, String>> selectPetList(Map<String, Object> map) throws Exception;
	
	int selectPetListCount(Map<String, Object> map) throws Exception;

	JSONObject selectFirstCodeList(Map<String, Object> map) throws Exception;
	
	
}