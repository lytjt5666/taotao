package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 返回界面的controller
 * */
@Controller
public class PageController {
	
	@RequestMapping(value = "/")
	public String showIndex(){
		return "index";
	}
	
	@RequestMapping(value ="/{page}")
	public String showPage(@PathVariable String page){
		return page;
	}
}
