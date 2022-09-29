package com.register.controller;

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

import com.register.entity.MyUser;
import com.register.service.UserService;
import com.register.service.Impl.UserServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserResource {
	
	@Autowired
	private UserService userservice;
	
	@PostMapping("/saveuser")
    public ResponseEntity<MyUser> saveUser(@RequestBody MyUser user){
		MyUser newuser= userservice.saveUser(user);
		log.info("user  name="+newuser.getUserName());
		userservice.sendMail(newuser.getUserName());
		
		return new ResponseEntity<MyUser>(newuser,HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<MyUser>> getAllUser(){
		return new ResponseEntity<List<MyUser>>(userservice.getAllUser(),HttpStatus.OK);
	}
	
	
	 @GetMapping("/{Id}")
	 public ResponseEntity<MyUser> getUserById(@PathVariable(name = "Id") int Id)
	 { 
		 return new ResponseEntity<MyUser>(userservice.getUserById(Id),HttpStatus.OK); 
	 }
	 
	  @PutMapping("/update/{Id}") 
	  public ResponseEntity<MyUser> updateUser(@RequestBody MyUser dto,@PathVariable int Id) 
	  { 
		  return new ResponseEntity<MyUser>(userservice.updateUser(dto, Id),HttpStatus.CREATED); 
      }
      @DeleteMapping("/{Id}") 
      public String deletePost(@PathVariable int Id){
      String result; 
      String str = userservice.deletUser(Id);
      System.out.println("str result="+str); if(str.equals("1")) {
      result="Data Deleted Sucessfully."; 
      }else 
      { 
    	  result="Data not found"; 
      }
       return result;
      }
}
