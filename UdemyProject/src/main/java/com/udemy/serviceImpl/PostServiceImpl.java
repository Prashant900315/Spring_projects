package com.udemy.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.udemy.entity.Post;
import com.udemy.exception.ResourceNotFoundException;
import com.udemy.payload.PostDto;
import com.udemy.repository.PostRepository;
import com.udemy.service.PostService;


@Service
public class PostServiceImpl implements PostService{

	@Autowired
	PostRepository postrepository;
	
	@Override
	public PostDto createPost(PostDto dto) {
		/*
		 * Post newpost = new Post(); newpost.setTitle(dto.getTitle());
		 * newpost.setDescription(dto.getDescription());
		 * newpost.setContent(dto.getContent());
		 */
		Post newpost = maptoEntity(dto);
		Post post= this.postrepository.save(newpost);
		//convert entity to dto
		
		PostDto postresponse = maptoDto(post);
		/*
		 * postresponse.setId(post.getId()); postresponse.setTitle(post.getTitle());
		 * postresponse.setDescription(post.getDescription());
		 * postresponse.setContent(post.getContent());
		 */
		return postresponse;
	}

	@Override
	public List<PostDto> getAllPost(int pageNO,int pageSize) {
		//create pagaeble instance
		Pageable pageble= PageRequest.of(pageNO, pageSize);
		Page<Post> postlist= postrepository.findAll(pageble);
		//get content for object
		List<Post> listofpost =postlist.getContent();
		return listofpost.stream().map(post->maptoDto(post)).collect(Collectors.toList());	 
	}
	
	//convert entity to dto
	private PostDto maptoDto(Post post) {
		PostDto dto = new PostDto();
		dto.setId(post.getId());
		dto.setTitle(post.getTitle());
		dto.setDescription(post.getDescription());
		dto.setContent(post.getContent());
		 return dto;	
	}
	//convert dto to entity
		private Post maptoEntity(PostDto dto) {
			Post post = new Post();
			post.setId(dto.getId());
			post.setTitle(dto.getTitle());
			post.setDescription(dto.getDescription());
			post.setContent(dto.getContent());
			 return post;
			
		}

		@Override
		public PostDto getPostById(long Id) {
			Post post =postrepository.findById(Id).orElseThrow(()->new ResourceNotFoundException("Post", "Id", Id));
			return maptoDto(post);
		}

		@Override
		public PostDto updatePost(PostDto dto, long Id) {
			Post post =postrepository.findById(Id).orElseThrow(()->new ResourceNotFoundException("Post", "Id", Id));
			post.setTitle(dto.getTitle());
			post.setDescription(dto.getDescription());
			post.setContent(dto.getContent());
			Post updatePost = postrepository.save(post);
			return maptoDto(updatePost);
		}

		@Override
		public String deletPost(long Id) {
			String result;
			Post post =postrepository.findById(Id).orElseThrow(()->new ResourceNotFoundException("Post", "Id", Id));
			if(post.getId()!=null) {
			 postrepository.deleteById(Id);
			 result="1";
			}
			else {
				result= "2";
			}
			System.out.println("result id="+result);
			return result;
		}

}
