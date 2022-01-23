package com.example.customeLock;

public interface LockCustom {
	void lock();
   	void unlock();
   	boolean tryLock();  
}
