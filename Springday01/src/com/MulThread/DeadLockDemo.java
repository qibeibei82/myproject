package com.MulThread;

public class DeadLockDemo {

	public static void main(String[] args) {
		Thread thread =new Thread(){
			public void run(){
				System.out.println("开启新线程");
			}
		};
		thread.start();
	}
	

}
