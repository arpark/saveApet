package egovframework.example.main.web;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import egovframework.example.common.Appserver;
import egovframework.example.searchPet.service.SearchPetService;

@Controller
public class MainController {
	
	protected Logger logger = Logger.getLogger(MainController.class);
	
	@Resource
	private SearchPetService searchPetService;

	/**
	 * 메인 화면을 조회한다.
	 * @param 
	 * @param model
	 * @return
	 * @exception Exception
	 */
	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
	public String main(Model model) throws Exception {

		try {
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("firstIndex", "0");
			map.put("lastIndex", "10");
			
			model.addAttribute("petList", searchPetService.selectPetList(map));
			
			
			return "main/main";
		} catch (Exception e) {

			logger.info(e.toString());
			return "cmmn/egovError";
		}
		
	}
	
	/**
	 * saveapet 소개 화면을 조회한다.
	 * @param 
	 * @param model
	 * @return
	 * @exception Exception
	 */
	@RequestMapping(value = "/saveapetInfo.do", method = RequestMethod.GET)
	public String saveapetInfo(Model model) throws Exception {

		try {
			model.addAttribute("naviId", "saveapetInfo");
			return "info/saveapetInfo";
		} catch (Exception e) {

			return "cmmn/egovError";
		}
		
	}
	
}
