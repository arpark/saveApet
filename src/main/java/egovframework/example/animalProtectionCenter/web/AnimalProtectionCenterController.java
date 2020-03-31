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
package egovframework.example.animalProtectionCenter.web;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.example.animalProtectionCenter.service.AnimalProtectionCenterService;
import egovframework.example.common.util.JsonUtil;

@Controller
public class AnimalProtectionCenterController {

	@Resource
	private AnimalProtectionCenterService animalProService;
	
	
	@ModelAttribute("naviId")
	private String naviId()  throws Exception{
		return "animalPro";
	}
	
	/**
	 * 동물보호센터 메인화면 호출.
	 * @param 
	 * @param model
	 * @return
	 * @exception Exception
	 */
	@RequestMapping(value = "/animalProMain.do", method = RequestMethod.GET)
	public String searchPetMain( Model model) throws Exception {
		
		return "animalProtectionCenter/animalProMain";
	}

	/**
	 * 동물보호센터리스트를 조회한다.
	 * @param 
	 * @param model
	 * @return
	 * @exception Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/getAnimalProList.do", produces = "application/json; charset=utf8")
	public String getPetReSystemList(@RequestParam Map<String,Object> paramMap) throws Exception {
		System.out.println(paramMap);
		return animalProService.selectAnimalProList(paramMap);
	}
}
