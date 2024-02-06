package com.app.service;

import java.util.ArrayList;
import java.util.Collection;

import java.util.stream.Collectors;

//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
import com.app.pojos.User;


//public class CustomUserDetails implements UserDetails {
//	private User user;
//
//	public CustomUserDetails(User user) {
//		super();
//		this.user = user;
//	}
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		// Meaning : This method should ret Collection(List) of granted authorities ,
//		// for a specific user --which will be later stored in Auth obj
//		//SimpleGrantedAuthority(String roleName)  imple  GrantedAuthority
//		//UserEntity ---> Role
//		Collection<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
//		auth.add(new SimpleGrantedAuthority(user.getUserRole().toString()));
//		return auth;
//	}
//
//	@Override
//	public String getPassword() {
//		// TODO Auto-generated method stub
//		return user.getPassword();
//	}
//
//	@Override
//	public String getUsername() {
//		// TODO Auto-generated method stub
//		return user.getUsername();
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//}
