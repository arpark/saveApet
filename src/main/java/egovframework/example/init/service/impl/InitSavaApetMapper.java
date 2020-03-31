package egovframework.example.init.service.impl;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("initMapper")
public interface InitSavaApetMapper {

	void insertSidoCode(Map<String, Object> map);

	void insertSigunguCode(Map<String, Object> map);

	void insertShelterCode(Map<String, Object> shelter);

	List<Map<String, Object>> selectCodeTbl(String code);

	void insertAnimalknList(Map<String, Object> animal);

	void deleteCodeTbl();

	void deleteAnimalknTbl();
	
}

