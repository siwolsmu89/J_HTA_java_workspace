package com.sample.mask.vo;

import java.util.Calendar;

public class User {
	public int birth;
	public String name;
	public int id;
	public boolean isEducated = true;
	
	public User() {}
	
	
	public User(String name, int birth, int id) {
		this.birth =birth;
		this.name = name;
		this.id=id;
		this.isEducated = true;
	}
}
