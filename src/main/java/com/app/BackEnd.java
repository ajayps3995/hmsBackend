package com.app;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.app.pojos.Role;
import com.app.pojos.User;
//import com.app.service.CustomUserDetails;

@SpringBootApplication
public class BackEnd {

	public static void main(String[] args) {
		SpringApplication.run(BackEnd.class, args);
	}

	@Bean
	public ModelMapper mapper()
	{
		 ModelMapper modelMapper = new ModelMapper();
		 modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		 return modelMapper;
	}
	
//	@Bean
//    public UserDetailsService userDetailsService() {
//    	User user1 = new User();
//    	user1.setUsername("ADMIN");
//    	user1.setPassword("ADMIN");
//    	user1.setUserRole(Role.ADMIN);
//        UserDetails admin = new CustomUserDetails(user1);
//
//        User user2 = new User();
//    	user2.setUsername("RECEPTION");
//    	user2.setPassword("RECEPTION");
//    	user2.setUserRole(Role.RECEPTIONIST);
//        UserDetails receptionist = new CustomUserDetails(user2);
//        return new InMemoryUserDetailsManager(admin,receptionist);
//    }
}
