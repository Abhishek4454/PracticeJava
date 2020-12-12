package com.practice.multithreadingBasics;


public class MyThreadClass {

	public static void main(String[] args) {
		Hi obj1 = new Hi();
		Hello obj2 = new Hello();
		/*
		 * obj1.show(); obj2.show();
		 */

		obj1.start();
		obj2.start();
		
	}

}

class Hi extends Thread {
	private void show() throws InterruptedException {
		System.out.println("Hi ........");
		Thread.sleep(1000);

	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 5; i++) {
				show();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
	class Hello extends Thread {
		private void show() throws InterruptedException {
			System.out.println("Hello........");
			Thread.sleep(1000);

		}

		@Override
		public void run() {
			try {
				for (int i = 0; i < 5; i++)
					show();

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

