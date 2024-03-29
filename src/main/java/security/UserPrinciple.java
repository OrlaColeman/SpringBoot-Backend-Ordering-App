package com.project.rest.webservice.Project.security;

import java.util.Collection;
//import java.util.List;
import java.util.Objects;
//import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.rest.webservice.Project.model.User;

public class UserPrinciple implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String username;
	private String email;
	
	@JsonIgnore
	private String password;
	
//	private Collection<? extends GrantedAuthority> authorities;
	
	public UserPrinciple(Long id, String name,
						String username, String email, String password) {
						//Collection<? extends GrantedAuthority>authorities) {
		
		this.id=id;
		this.name=name;
		this.email=email;
		this.username=username;
		this.password=password;
//		this.authorities=authorities;
		
	}
	
	public static UserPrinciple build(User user) {
//		List<GrantedAuthority> authorities = user.getRoles().stream().map(role -> 
//			new SimpleGrantedAuthority(role.getName().name())
//		).collect(Collectors.toList());	
		
		return new UserPrinciple(
				user.getId(),
				user.getName(),
				user.getUsername(),
				user.getEmail(),
				user.getPassword());
//				authorities
//				);
	}
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getUsername() {
		return username;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities(){
//		return authorities;
//	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		
		UserPrinciple user = (UserPrinciple) o;
		return Objects.equals(id, user.id);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
