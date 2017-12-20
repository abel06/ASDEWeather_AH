package it.unical.asde.weather.user;

import java.util.ArrayList;

public class User {
	private String name;
	private String email;
	private String password;
	private String Home_City;
	//private ArrayList<String,String> preffered_city_list;
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
