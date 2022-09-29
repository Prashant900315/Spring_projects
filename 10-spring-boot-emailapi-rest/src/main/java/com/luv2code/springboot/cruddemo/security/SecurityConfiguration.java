package com.luv2code.springboot.cruddemo.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;



@Configuration
@EnableWebMvc
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	/*	 http.antMatcher("/match1/**")
        .authorizeRequests()
        .antMatchers("/match1/user").hasRole("USER")
        .antMatchers("/match1/spam").hasRole("SPAM")
        .anyRequest().isAuthenticated();*/
		
		 http.httpBasic().and().authorizeRequests()
		.antMatchers("/api/employees").hasRole("USER")
	//	.permitAll()
	//	.antMatchers("/api/employees/delete/**").hasRole("ADMIN")
		.antMatchers("/api/employees/save").hasRole("ADMIN")
		.and().csrf()
		.disable()
		.headers()
		.frameOptions()
		.disable()
		;
		
	}
	
	
	/*@SuppressWarnings("deprecation")
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().passwordEncoder(org.springframework.security.crypto.password
				.NoOpPasswordEncoder.getInstance()).withUser("user").password("secret")
				.roles("USER").and().withUser("admin1").password("secret1")
				.roles("USER", "ADMIN");
	}*/
	
/*	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) 
	  throws Exception {
		
		
	
	    auth.jdbcAuthentication()
	      .dataSource(dataSource)
	      .usersByUsernameQuery("select email,password,enabled "
	        + "from bael_users "
	        + "where email = ?")
	      .authoritiesByUsernameQuery("select email,authority "
	        + "from authorities "
	        + "where email = ?").passwordEncoder(new BCryptPasswordEncoder());
	}*/
	
}
