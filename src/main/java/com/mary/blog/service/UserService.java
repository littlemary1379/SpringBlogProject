package com.mary.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mary.blog.model.User;
import com.mary.blog.repository.UserRepository;


//Controller, Repository(MyBatis를 쓰는 경우 MapperScan하기 때문에 선택),Configuration,Service(트랜젝션 호출),Component
//RestController,Bean

@Service // IOC
public class UserService { 
	
	@Autowired
	private UserRepository userRepository; // DI
	
	@Transactional
	public void 회원가입(User user) {
		// try catch로 처리 할필요없이 오류시에 fail 로 보내도됨
			user.setRole("ROLE_USER");
			userRepository.save(user);	
	}
	
	@Transactional(readOnly = true) //정합성 데이터변경을 허용하지않음 처음 트랙젝션이 시작됬을때 데이터를 유지 //select 할때 사용
	public User 로그인(User user) {
		// try catch로 처리 할필요없이 오류시에 fail 로 보내도됨
		
		return userRepository.login(user);
			
	}
	
}

