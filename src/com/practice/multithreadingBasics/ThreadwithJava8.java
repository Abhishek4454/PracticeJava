package com.practice.multithreadingBasics;

public class ThreadwithJava8 {

	public static void main(String[] args) throws Exception {

		Runnable obj2 = () -> {
			for (int i = 0; i < 5; i++)
				System.out.println("Hello........");
		};
		Runnable obj1 = () -> {
			for (int i = 0; i < 5; i++)
				System.out.println("Hi ........");
		}; /*
			 * obj1.show(); obj2.show();
			 */

		/*
		 * obj1.run(); Thread.sleep(1000); obj2.run();
		 */
		Thread t1 = new Thread(obj1);
		Thread t2 = new Thread(obj2);
		t1.start();
		Thread.sleep(1000);
		t2.start();

	}
}

/*
 * class Hi1 implements Runnable { private void show() throws
 * InterruptedException { System.out.println("Hi ........"); Thread.sleep(10);
 * 
 * }
 * 
 * @Override public void run() { try { for (int i = 0; i < 5; i++) { show(); } }
 * catch (InterruptedException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); }
 * 
 * } }
 */
/*
 * class Hello2 implements Runnable { private void show() throws
 * InterruptedException { System.out.println("Hello........");
 * Thread.sleep(1000);
 * 
 * }
 * 
 * @Override public void run() { try { for (int i = 0; i < 5; i++) show();
 * 
 * } catch (InterruptedException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); }
 * 
 * } }
 */
