package egovframework.example.common.mapApi.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.common.Appserver;
import egovframework.example.common.mapApi.service.MapService;

@Service
public class MapServiceImpl implements MapService {

	@Resource(name = "appserver")
	protected Appserver appserver;
	
	@Resource
	protected MapMapper mapMapper;
	
	
}
