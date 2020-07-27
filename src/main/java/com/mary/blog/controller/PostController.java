package com.mary.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mary.blog.controller.dto.CommonRespDto;
import com.mary.blog.model.Post;
import com.mary.blog.service.PostService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PostController {
	
	
	private final PostService postService;
	
	@GetMapping("/post/saveForm")
	public String postForm() {
		return "post/saveForm";
	}
	
	@PostMapping("/post")
	public @ResponseBody CommonRespDto<?> postProc(@RequestBody Post post) {
		postService.글쓰기(post);
		return new CommonRespDto<String>(1,"글쓰기 성공");
	}
	
	//post관련된 것은 전부다 인증 필요하게!!
		@GetMapping("/posts")
		public String getPosts(Model model){ //model 데이터 담고 이동할때 사용 (Requestdispatcher)
			model.addAttribute("posts", postService.목록보기());
			return "index";
		}
		
		@GetMapping("/post/{id}")
		//?주소 -> 쿼리스트링 받는 것
		// /post/{id} -> 파라메터를 받는 것
		public String getPost(@PathVariable int id, Model model) {
			model.addAttribute("postDetailRespDto", postService.상세보기(id));
			return "post/detail";
		}
		
		@DeleteMapping("/post/{id}")
		public @ResponseBody CommonRespDto<?> deletePost(@PathVariable int id){
			System.out.println("삭제하기");
			postService.삭제하기(id);
			return new CommonRespDto<String>(1,"삭제 성공");
			
		}
		
		@PutMapping("/post/{id}")
		public @ResponseBody CommonRespDto<?> update(@RequestBody Post post){
			System.out.println("수정하기");
			postService.수정하기(post);
			return new CommonRespDto<String>(1,"수정 성공");
			
		}


}


