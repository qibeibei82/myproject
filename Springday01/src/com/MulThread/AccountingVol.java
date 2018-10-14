package com.MulThread;

public class AccountingVol implements Runnable{

	public static int j=0;
	@Override
	public void run() {
		synchronized (AccountingVol.class) {
			for (int i = 0; i < 10000; i++) {
				j++;
			}
		
		}
		
		System.out.println(j);
	}
	
	public static void main(String[] args) throws Exception {
		Thread t1=new Thread(new AccountingVol());
		Thread t2=new Thread(new AccountingVol());
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(j);
		
	}
}
