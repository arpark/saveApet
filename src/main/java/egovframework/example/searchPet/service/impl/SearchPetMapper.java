package egovframework.example.searchPet.service.impl;

import java.util.List;
import java.util.Map;
import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("searchPetMapper")
public interface SearchPetMapper{

	List<Map<String, String>> selectPetList(Map<String, Object> map);
	
	List<Map<String, Object>> selectFirstCodeList(Map<String, Object> map);

	int selectPetListCount(Map<String, Object> map);
}

