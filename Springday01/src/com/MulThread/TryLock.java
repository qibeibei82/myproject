package com.MulThread;

import java.util.concurrent.locks.ReentrantLock;

public class TryLock implements Runnable {
	public static ReentrantLock lock1 = new ReentrantLock();
	public static ReentrantLock lock2 = new ReentrantLock();
	int locknum;

	public TryLock(int locknum) {
		this.locknum = locknum;
	}

	@Override
	public void run() {
		if (locknum == 0) {
			while (true) {
				if (lock1.tryLock()) {
					try {
						Thread.sleep(100);
						if (lock2.tryLock()) {
							System.out.println("1111111111111");
							lock2.unlock();
							return;
						}
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						lock1.unlock();
					}
				}

			}
		} else {
			while (true) {
				if (lock2.tryLock()) {
					try {
						Thread.sleep(100);
						if (lock1.tryLock()) {
							System.out.println("2222222222222");
							lock1.unlock();
							return;
						}
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						lock2.unlock();
					}
				}
			}

		}

	}

	public static void main(String[] args) {
		TryLock tryLock1 = new TryLock(0);
		TryLock tryLock2 = new TryLock(1);
		Thread t1 = new Thread(tryLock1);
		Thread t2 = new Thread(tryLock2);
		t1.start();
		t2.start();
	}
}
