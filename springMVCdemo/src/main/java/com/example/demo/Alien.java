package com.example.demo;

public class Alien {
	private String aname;
	private int aid;
	private int age;
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Alien [aname=" + aname + ", aid=" + aid + ", age=" + age + "]";
	}

	
}
