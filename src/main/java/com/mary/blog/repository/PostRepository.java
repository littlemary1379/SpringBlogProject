package com.mary.blog.repository;

import java.util.List;

import com.mary.blog.controller.dto.PostDetailRespDto;
import com.mary.blog.model.Post;

public interface PostRepository {
	public void save(Post post);
	public List<Post> findAll();
	public PostDetailRespDto findById(int id);
	public void deleteContentById(int id);
	public void update(Post post);
}
