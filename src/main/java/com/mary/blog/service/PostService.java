package com.mary.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mary.blog.controller.dto.PostDetailRespDto;
import com.mary.blog.model.Post;
import com.mary.blog.repository.PostRepository;

@Service // IOC
public class PostService { 
	
	@Autowired
	private PostRepository postRepository; // DI
	
	@Transactional 
	public void 글쓰기(Post post) {
		 postRepository.save(post);
			
	}
	
	@Transactional(readOnly = true)
	public List<Post> 목록보기() {
		 return postRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public PostDetailRespDto 상세보기(int id) {
		 return postRepository.findById(id);
	}
	
	@Transactional
	public void 삭제하기(int id) {
		System.out.println("삭제하기 : "+id);
		 postRepository.deleteContentById(id);
	}
	
	@Transactional
	public void 수정하기(Post post) {
		 postRepository.update(post);
	}
	
}


