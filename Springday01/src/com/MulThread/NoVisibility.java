package com.MulThread;

public class NoVisibility {
	private static  boolean ready; 
	private static  int number;
	
	private static  class ReadThread extends Thread{
		public void run(){
			while(true){
				System.out.println(number);
			}
		}
	}
	public static void main(String[] args) throws InterruptedException {
		Thread t=new ReadThread();
		t.setDaemon(true);	
		t.start();
		Thread.sleep(1000);
		number=42;
		ready=true;
		
		
		
	}
	
}
