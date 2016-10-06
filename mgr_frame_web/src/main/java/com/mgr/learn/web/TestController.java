package com.mgr.learn.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mgr.learn.api.IUsersService;



@Controller
@RequestMapping("/test")
public class TestController {
	private static Logger log = Logger.getLogger(TestController.class);
	@Autowired(required = false)
	private IUsersService usersServiceImpl;
	@RequestMapping(value = "/index")
	public String index(Model model) {
		log.info("pppppppppp");
		String createTimeString=usersServiceImpl.getPinCreateTime("zwy440");
		model.addAttribute("info", createTimeString);
		return "/test/test";
	}
	@RequestMapping(value = "/getResult")
	public @ResponseBody String getResult(Model model) {
		return "result";
	}
}
