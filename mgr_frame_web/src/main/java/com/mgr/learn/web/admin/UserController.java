package com.mgr.learn.web.admin;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public @ResponseBody JSONObject listJson(Integer pageNum,Integer pageSize,String userName) {
		log.info(String.format("==listJson pageNum:%s pageSize:%s userName:%s", pageNum,pageSize,userName));
		List<User> userList=userServiceImpl.find(pageNum, pageSize);
		int totalNum=userServiceImpl.count();
		JSONObject returnObject = new JSONObject();
		returnObject.put("userList", JSONArray.fromObject(userList));
		returnObject.put("totalNum", totalNum);
		returnObject.put("pageNum", pageNum);
		returnObject.put("pageSize", pageSize);
		return returnObject;
	}
	@RequestMapping(value = "/save",method = RequestMethod.POST, produces="application/json")
	public @ResponseBody JSONObject save(@RequestBody User user) {
		log.info(user);
		int flag=0;
		if(user.getId()==0){
			flag=userServiceImpl.insert(user);
		}else{
			flag=userServiceImpl.update(user);
		}
		JSONObject returnObject = new JSONObject();
		if(flag==1){
			returnObject.put("isSuccess", true);
		}else{
			returnObject.put("isSuccess", false);
		}
		return returnObject;
	}
	@RequestMapping(value = "/del",method = RequestMethod.POST, produces="application/json")
	public @ResponseBody JSONObject del(Integer id) {
		int flag=userServiceImpl.del(id);
		JSONObject returnObject = new JSONObject();
		if(flag==1){
			returnObject.put("isSuccess", true);
		}else{
			returnObject.put("isSuccess", false);
		}
		return returnObject;
	}
	
}
