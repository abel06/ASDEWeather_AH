package it.unical.asde.weather.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class User {
	private String name;
	private String email;
	private String password;
	private String Home_City;
	
    private List<String> preferred_cities ;
	 public User() {
		 
	 }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
