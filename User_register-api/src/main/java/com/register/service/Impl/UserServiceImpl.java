package com.register.service.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.register.entity.EmailUser;
import com.register.entity.MyUser;
import com.register.handler.ResourceNotFoundException;
import com.register.repository.UserRepository;
import com.register.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userrepository;
	
	@Autowired
	public RestTemplate restTemplate;
	
	@Value("${email.service.url}")
	private String mailServiceUrl;
	

	@Override
	public MyUser saveUser(MyUser user) {
		MyUser newuser = userrepository.save(user);
		return newuser;
	}

	@Override
	public MyUser updateUser(MyUser user, int Id) {
		MyUser users =userrepository.findById(Id).orElseThrow(()->new ResourceNotFoundException("User", "Id", Id));
		users.setUserName(user.getUserName());
		users.setEmail(user.getEmail());
		users.setDoB(user.getDoB());
		users.setMakerId(user.getMakerId());
		users.setMobileNo(user.getMobileNo());
		users.setPassword(user.getPassword());
		users.setStatus(user.getStatus());
		users.setAccountStatus(user.getAccountStatus());
		user.setValidityDate(user.getValidityDate());
		MyUser updateUser = userrepository.save(users);
		return updateUser;
	}

	@Override
	public List<MyUser> getAllUser() {
		List<MyUser> userlist = userrepository.findAll();
		return userlist;
	}

	@Override
	public MyUser getUserById(int Id) {
		MyUser user =userrepository.findById(Id).orElseThrow(()->new ResourceNotFoundException("User", "Id", Id));
		return user;
	}
     
	@Override
	public String deletUser(int Id) {
		String result;
		MyUser user =userrepository.findById(Id).orElseThrow(()->new ResourceNotFoundException("User", "Id", Id));
		if(user.getId()!=null) {
			userrepository.deleteById(Id);
		 result="1";
		}
		else {
			result= "2";
		}
		System.out.println("result id="+result);
		return result;
	}

		@Override
		public void sendMail(String username) {
		log.info("mail service url="+mailServiceUrl);
		EmailUser user = restTemplate.getForObject(mailServiceUrl+"employees/email/"+username,EmailUser.class);
		MyUser user1 = restTemplate.getForObject(mailServiceUrl+"/email/"+user.getUsername(),MyUser.class);
	   }
}
