package com.mary.blog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mary.blog.controller.dto.CommonRespDto;
import com.mary.blog.model.User;
import com.mary.blog.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("auth/joinProc")
	public @ResponseBody CommonRespDto<?> joinProc(@RequestBody User user) { //key-value 데이터가 아님
		userService.회원가입(user);
		return new CommonRespDto<String>(1,"회원 가입 성공");
	}
	
	@PostMapping("auth/loginProc")
	public @ResponseBody CommonRespDto<?> loginProc(@RequestBody User user, HttpSession session){
		User persistUser=userService.로그인(user);
		if(ObjectUtils.isEmpty(persistUser)) {
			return new CommonRespDto<String>(-1,"로그인 실패");
		}else {
			//세션 등록
			session.setAttribute("principal", persistUser);
			return new CommonRespDto<String>(1,"로그인 성공");
		}
	}
}