package com.fortinet.cc.question4;

public class Singleton {
	private static Singleton instance = null;
	
	public Singleton() {
		
	}
	
	public synchronized static Singleton getInstance() {
		if(instance == null) {
			synchronized (Singleton.class) {
				instance = new Singleton();	
			}					
		}
		return instance;
	}
	

}
