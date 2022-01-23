package com.example.customeLock;

public class ReentrantLockCustomTest {

	public static void main(String[] args) {

  		LockCustom LockCustom=new ReentrantLockCustom();
  		MyRunnable myRunnable=new MyRunnable(LockCustom);
  		new Thread(myRunnable,"Thread-1").start();
  		new Thread(myRunnable,"Thread-2").start();
	}

}
