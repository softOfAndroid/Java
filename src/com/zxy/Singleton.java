package com.zxy;

/**
 * 单例模式
 * @author zxy
 * 2017年6月29日
 */
public class Singleton {
	
	/**
	 * 懒汉式单例模式
	 * synchronized修饰符的同步准备上比较耗时，性能较低
	 */
	public static Singleton instance = null;
	
	public synchronized static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
	
	//优化
	public static Singleton getInstance1(){
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
	
	/**
	 * 饿汉式单例模式
	 */
	public static Singleton singleton = new Singleton();
	
	public static Singleton getInstance2(){
		return instance;
	}

	//优化
	private static class SingletonHolder{
		final static Singleton singleton = new Singleton();
	}
	
	public static Singleton getInstance3() {
		return SingletonHolder.singleton;
	}
}
