package com.itcast;

public class User {
	private String name;
	
	private int age;
	private Person person;
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	public User(){
		System.out.println("无参构造被调用");
	}
	public void init(){
		System.out.println("初始化");
	}
	public void destory(){
		System.out.println("销毁");
	}
}
