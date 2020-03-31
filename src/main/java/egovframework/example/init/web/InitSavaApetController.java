package egovframework.example.init.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import egovframework.example.init.service.InitSavaApetService;

@Controller
public class InitSavaApetController {
	
	@Resource
	private InitSavaApetService initService;

	/**
	 * 프로젝트 시작 실행 전 기본 디비 구성
	 * @param 
	 * @param model
	 * @return
	 * @exception Exception
	 */
	@RequestMapping(value = "/initSavaApet.do", method = RequestMethod.GET)
	public String main(Model model) throws Exception {

		try {
			
			initService.initsaveApetService();
			
			return "searchPet/searchPetMain";
		} catch (Exception e) {

			return "cmmn/egovError";
		}
		
	}
	
}
