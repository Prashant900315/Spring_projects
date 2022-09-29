package com.udemy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.payload.PostDto;
import com.udemy.service.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {
	
	@Autowired
	PostService postservice;
	
	
	@PostMapping("/")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto dto) {
		
		return new ResponseEntity<>(postservice.createPost(dto),HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<PostDto>> getAllPost(@RequestParam(value = "pageNo",
	defaultValue="0", required = false) int pageNO,
	@RequestParam(value = "pageSize",defaultValue="5", required = false) int pageSize){
		return new ResponseEntity<List<PostDto>>(postservice.getAllPost(pageNO,pageSize),HttpStatus.OK);
	}
	
	@GetMapping("/{Id}")
	public ResponseEntity<PostDto> getPostById(@PathVariable(name = "Id") long Id){
		return new ResponseEntity<PostDto>(postservice.getPostById(Id),HttpStatus.OK);
	}
	
	@PutMapping("/update/{Id}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto dto,@PathVariable long Id) {
		return new ResponseEntity<PostDto>(postservice.updatePost(dto, Id),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{Id}")
	public String deletePost(@PathVariable long Id){
		String result;
		String str = postservice.deletPost(Id);
		System.out.println("str result="+str);
		if(str.equals("1")) {
			result="Data Deleted Sucessfully.";
		}else {
			result="Data not found";
		}
		return result;
	}
	
	
    
}
