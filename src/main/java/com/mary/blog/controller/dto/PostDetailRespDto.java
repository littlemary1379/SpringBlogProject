package com.mary.blog.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//웬만하면 컴포지션 하지 말고

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class PostDetailRespDto {
	private int id;
	private String title;
	private String content;
	private String username;
	
}
