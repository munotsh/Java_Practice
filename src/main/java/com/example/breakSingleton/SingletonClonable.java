package com.example.breakSingleton;

public class SingletonClonable implements Cloneable{
	
	public static SingletonClonable singletonClonable = null;
	private SingletonClonable() {
		
	}
	
	public static SingletonClonable getInstence() {
		if(singletonClonable ==null) {
			singletonClonable = new SingletonClonable();
		}
		return singletonClonable;
	}
	@Override
	  protected Object clone() throws CloneNotSupportedException 
	  {
	    throw new CloneNotSupportedException();
	  }
}
