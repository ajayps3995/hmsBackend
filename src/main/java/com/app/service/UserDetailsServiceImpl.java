package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.dao.UserDao;
import com.app.pojos.User;

@Service // or @Component also works!
@Transactional
public class UserDetailsServiceImpl //implements UserDetailsService
{

	@Autowired
	private UserDao userDao;
	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User user = userDao.findUserByUsername(username).orElseThrow(()->new UsernameNotFoundException(username + " not found"));
//		return new CustomUserDetails(user);
//	}

}
