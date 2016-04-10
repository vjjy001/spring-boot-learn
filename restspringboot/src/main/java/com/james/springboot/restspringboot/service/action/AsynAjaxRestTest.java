package com.james.springboot.restspringboot.service.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AsynAjaxRestTest {

	@RequestMapping(value = "/ajaxpage", method = RequestMethod.GET)
	public String toAjaxPage(Model model) {

		//model.addAttribute("name","james");
		return "/handson/jqAjax";
	}

	@RequestMapping(value = "/ajaxlocalpage", method = RequestMethod.GET)
	public String toAjaxLocalPage(Model model) {

		//model.addAttribute("name","james");
		return "/handson/jqAjaxlocal";
	}

	
}
