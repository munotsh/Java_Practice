package com.example.allPracticeProgram.customeLock;

public class ReentrantLockCustom implements LockCustom {
	int lockHoldCount;

	ReentrantLockCustom() {
		lockHoldCount = 0;
	}

	@Override
	public synchronized void lock() {
		if (lockHoldCount == 0) {
			lockHoldCount++;
		} 
		else {
			try {
				wait();
				lockHoldCount++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public synchronized void unlock() {
		if (lockHoldCount == 0)
			throw new IllegalMonitorStateException();

		lockHoldCount--;

		if (lockHoldCount == 0)
			notify();
	}

	@Override
	public synchronized boolean tryLock() {
		if (lockHoldCount == 0) {
			lock();
			return true;
		} else
			return false;
	}
}
