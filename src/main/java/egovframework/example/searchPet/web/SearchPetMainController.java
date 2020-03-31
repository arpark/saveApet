/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package egovframework.example.searchPet.web;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import egovframework.example.common.paging.PagingService;
import egovframework.example.common.util.PagingUtil;
import egovframework.example.searchPet.service.SearchPetService;

@Controller
@RequestMapping(value="/searchPet")
public class SearchPetMainController {

	@Resource
	private SearchPetService searchPetService;
	
	@Resource
	private PagingService pagingService;
	
	@ModelAttribute("naviId")
	private String naviId()  throws Exception{
		return "searchPet";
	}
	
	/**
	 * 메인 화면을 조회한다.
	 * @param 
	 * @param model
	 * @return
	 * @exception Exception
	 */
	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
	public String searchPetMain( Model model) throws Exception {
		return "searchPet/searchPetMain";
	}

	
	/**
	 * 유기동물 리스트를  조회한다.
	 * @param 
	 * @param model
	 * @return
	 * @exception Exception
	 */
	@RequestMapping(value = "/getPetList.do", method = RequestMethod.POST)
	public ModelAndView getPetList(@RequestParam Map<String,Object> params, HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView("jsonView");
		
		System.out.println(params);
		
		try {
			
			PagingUtil.setStartEndDisplay(params);
			int count = searchPetService.selectPetListCount(params);
			
			mav.addObject("petList" ,searchPetService.selectPetList(params));
			mav.addObject("count", count);
			mav.addObject("page" ,
					pagingService.setPaging(
							params.get("pageno").toString(),
							String.valueOf(count),
							"searchPetList",
							Integer.parseInt(params.get("display").toString()),
							10,
							request
					)
			);
			
			mav.addObject("status", "SUCCESS");
		} catch (Exception e) {
			
			mav.addObject("status", "ERROR");
			System.out.println(e.getStackTrace());
		}
		
		return mav;
	}
	

	/**
	 * 상세페이지불러오기 
	 * @param 
	 * @param model
	 * @return
	 * @exception Exception
	 */
	@RequestMapping(value = "/detail.do", method = RequestMethod.GET)
	public String searchPetDetail( Model model) throws Exception {
		
		return "searchPet/searchPetDetail";
	}


	/**
	 * 검색 select 박스 코드 조회
	 * @param 
	 * @param model
	 * @return
	 * @exception Exception
	 */
	@RequestMapping(value = "/getCode.do", method = RequestMethod.POST)
	public ModelAndView getCode( Model model, @RequestParam Map<String, Object> map) throws Exception {
		
		ModelAndView mav = new ModelAndView("jsonView");
		mav.addObject("data", searchPetService.selectFirstCodeList(map));

		return mav;
	}
}
