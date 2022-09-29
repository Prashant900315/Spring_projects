package com.users.service;

import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.users.entity.User;
import com.users.repository.UserRepository;
import com.users.vo.*;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	
	@Autowired
	private UserRepository userepository;
	
	@Autowired
	public RestTemplate restTemplate;
	
	public User saveUser(User user) {
		return userepository.save(user);
	}

	@Value("${department.service.url}")
	private String deptServiceUrl;
	
	
	public ResponseTemplate getUserWithDepartment(Long userId) {
		ResponseTemplate vo = new ResponseTemplate();
		User user = userepository.findById(userId).orElse(null);
		log.info("user id="+user.getDepartmentId());
		log.info(deptServiceUrl+"/"+user.getDepartmentId());
		Department deprtemnt=restTemplate.getForObject(deptServiceUrl+"/"+user.getDepartmentId(),Department.class);
		vo.setDept(deprtemnt);
		vo.setUser(user);
		return vo;
	}

}
