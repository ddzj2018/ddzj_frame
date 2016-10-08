package com.mgr.learn.web.admin;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mgr.learn.api.IUserService;
import com.mgr.learn.domain.User;
/**
 * user控制器
 * @author zhouchangwei
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	private static Logger log = Logger.getLogger(UserController.class);
	@Autowired(required = false)
	private IUserService userServiceImpl;

	@RequestMapping(value = "list")
	public String list(Model model) {
		log.info("==user list page");
		return "/user/list";
	}
	@RequestMapping(value = "/listJson")
	public @ResponseBody JSONObject listJson(Integer pageNum,Integer pageSize) {
		log.info(String.format("==listJson pageNum:%s pageSize:%s", pageNum,pageSize));
		List<User> userList=userServiceImpl.find(pageNum, pageSize);
		int total=userServiceImpl.count();
		JSONObject returnObject = new JSONObject();
		returnObject.put("userList", JSONArray.fromObject(userList));
		returnObject.put("total", total);
		returnObject.put("pageNum", pageNum);
		returnObject.put("pageSize", pageSize);
		return returnObject;
	}
	@RequestMapping(value = "/save")
	public @ResponseBody JSONObject save(Model model) {
		JSONObject returnObject = new JSONObject();
		return returnObject;
	}
	@RequestMapping(value = "/del")
	public @ResponseBody JSONObject del(Model model) {
		JSONObject returnObject = new JSONObject();
		return returnObject;
	}
	
	
	
}
