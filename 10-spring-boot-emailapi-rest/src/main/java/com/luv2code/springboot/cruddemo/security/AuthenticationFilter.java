package com.luv2code.springboot.cruddemo.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luv2code.springboot.cruddemo.entity.UserCredentials;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	
private final AuthenticationManager authenticationManager;
	
	public AuthenticationFilter(AuthenticationManager authenticationManager)
	{
		this.authenticationManager=authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req,
											   HttpServletResponse res) throws AuthenticationException
	{
		
		try{
			UserCredentials creds = new ObjectMapper()
			                              .readValue(req.getInputStream(), UserCredentials.class);
			
			return authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							creds.getUsername(),
							creds.getPassword(),
							new ArrayList<>()
							)
					
					);
			
		}
		catch(IOException e)
		{
			throw new RuntimeException(e);
		}
		
	}
	
	
	
}
