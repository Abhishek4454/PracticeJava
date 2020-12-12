package com.practice.MySingleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//TestCases with Reflection,Serailization
public class SingletonTest {
	public static void useSingleton() {
		Singleton s3 = Singleton.myinstance();
		System.out.println("Inside useSingleton : " + s3.hashCode());
	}

	public static void main(String[] args) throws Exception {
		Singleton s1 = Singleton.myinstance();
		Singleton s2 = Singleton.myinstance();
		//

		ExecutorService exService = Executors.newFixedThreadPool(2);
		exService.submit(SingletonTest::useSingleton);
		exService.submit(SingletonTest::useSingleton);
		exService.shutdown();

		// Reflection
		// System.out.println("Reflection API's");
		Class clazz = Class.forName("com.practice.MySingleton.Singleton");
		Constructor<Singleton> cons = clazz.getDeclaredConstructor();
		cons.setAccessible(true);
		// Singleton s3 = cons.newInstance();

		// Serialization
		// System.out.println("Serialization and desirialization");
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\EclipseProject\\IO/s2.ser"));
		oos.writeObject(s2);
		oos.close();
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\EclipseProject\\IO/s2.ser"));
		// Singleton s3 = (Singleton) ois.readObject();
		ois.close();

		// clonning
		// System.out.println("Clonning Implemenation : ");
		// Singleton s3= (Singleton) s1.clone();
		// System.out.println(s1.hashCode() + "\n " + s2.hashCode());
		// System.out.println(s3.hashCode());

	}
}

class Singleton implements Cloneable, Serializable {

	// private static Singleton soulInstance = new Singleton();//eager
	private static Singleton soulInstance = null;

	private Singleton() {
		/*
		 * if (soulInstance != null) { throw new
		 * RuntimeException("Cannot create the object of singleton"); }
		 */
		System.out.println("Creating.........");
	}

	public static Singleton myinstance() {
		if (soulInstance==null) {
			soulInstance = new Singleton();
		}
		//soulInstance = new Singleton();
		return soulInstance;
	}
	/*
	 * this is the default method which gets executed whenever there is a call for
	 * deserialization and through that we can alter the object behaviour.
	 */

	private Object readResolve() throws ObjectStreamException {
		System.out.println("Creating readResolve........ ");
		return soulInstance;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return soulInstance;
	}

}
