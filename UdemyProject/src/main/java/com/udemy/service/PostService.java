package com.udemy.service;

import java.util.List;

import com.udemy.payload.PostDto;

public interface PostService {
	
	PostDto createPost(PostDto dto);

	List<PostDto> getAllPost(int pageNO,int pageSize);
	
	PostDto getPostById(long Id);
	
	PostDto updatePost(PostDto dto,long Id);
	
	String deletPost(long Id);
	
}
