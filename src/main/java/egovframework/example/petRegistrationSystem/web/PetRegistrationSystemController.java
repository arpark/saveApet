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
package egovframework.example.petRegistrationSystem.web;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.example.common.util.JsonUtil;
import egovframework.example.petRegistrationSystem.service.PetRegistrationSystemService;

@Controller
public class PetRegistrationSystemController {

	@Resource
	private PetRegistrationSystemService petReService;
	
	@ModelAttribute("naviId")
	private String naviId()  throws Exception{
		return "petReSystem";
	}
	
	
	/**
	 * 반려동물등록대행  소개 화면을 조회한다.
	 * @param 
	 * @param model
	 * @return
	 * @exception Exception
	 */
	@RequestMapping(value = "/petReSystemMain.do", method = RequestMethod.GET)
	public String searchPetDetail( Model model) throws Exception {
		
		return "petRegistrationSystem/petReSystemMain";
	}

	/**
	 * 반려동물등록대행 업체리스트 화면을 조회한다.
	 * @param 
	 * @param model
	 * @return
	 * @exception Exception
	 */
	@RequestMapping(value = "/petReSystemListPage.do", method = RequestMethod.GET)
	public String petReSystemListPage( Model model) throws Exception {
		
		return "petRegistrationSystem/petReSystemList";
	}

	/**
	 * 반려동물등록대행 업체리스트를 조회한다.
	 * @param 
	 * @param model
	 * @return
	 * @exception Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/getPetReSystemList.do", produces = "application/json; charset=utf8")
	public String getPetReSystemList(@RequestParam Map<String,Object> paramMap) throws Exception {
		return petReService.selectPetReSystemList(paramMap);
	}

}
