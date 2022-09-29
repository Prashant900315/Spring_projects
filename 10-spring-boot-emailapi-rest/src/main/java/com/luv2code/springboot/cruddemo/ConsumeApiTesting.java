package com.luv2code.springboot.cruddemo;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.luv2code.springboot.cruddemo.Utils.GeneratePdfReport;
import com.luv2code.springboot.cruddemo.entity.Employee;

public class ConsumeApiTesting {
	static RestTemplate template = new RestTemplate();
	public static void main(String[] args)
	{
		GeneratePdfReport report = new GeneratePdfReport();
		
	//	report.pdfReport();
	//	getEmployee();
	//	saveEmployee();
		
	}
	
	public static final String GETURL = "http://localhost:8080/api/employees";
	public static final String SAVEURL = "http://localhost:8080/api/employees/save";
	
	private static void getEmployee()
	{
	
	     HttpHeaders headers = new HttpHeaders();
	//	 headers.setContentType(MediaType.APPLICATION_JSON);
		 HttpEntity<String> entity = new HttpEntity<>(headers);
		 ResponseEntity<String> res= template.exchange(GETURL, HttpMethod.GET, entity, String.class);
		 System.out.println(res);
	}
	
	private static void saveEmployee()
	{
	
		 HttpHeaders headers = new HttpHeaders();
		 headers.setContentType(MediaType.APPLICATION_JSON);
		 HttpEntity<String> entity = new HttpEntity<>("body", headers);
		 Employee emp = new Employee("Pawan","kumar","pawan@gmail.com","123");
		// ResponseEntity<String> res= 
		 ResponseEntity<Employee> res = template.postForEntity(SAVEURL, emp, Employee.class);
		 System.out.println(res.getBody());
	}
	
	
	
}
