package com.itcast;

public class Factory {
	public static User create(){
		System.out.println("静态工厂");
		return new User();
	}

}
