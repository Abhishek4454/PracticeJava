package com.practice.Java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class MyFunProgram {
	public static void pass(int x) {
		x=10;
	}
	
	public static void factorIt(int number) throws InterruptedException{
		Thread.sleep(1000);
	}
   public static void main(String[] args) throws InterruptedException {
	List<Integer> numbers= Arrays.asList(1,2,3,4,5,6,7,8,9);
	//numbers.forEach((Integer t)->System.out.println(t));
	//numbers.forEach(( t)->System.out.println(t));//Type Parenthesis
	numbers.forEach(System.out::println);

	//total of double of the even numbers
	int result=0;
	for (int num:numbers) {
		if (num%2==0) {
			result +=num*2;
		}
	}
	System.out.println("total of double of the even numbers : " + result);
	
	//Functional frogramming
	System.out.println(
	numbers.stream()
	       .filter(num->num%2==0)
	       .mapToInt(num->num*2)
	       .sum());
	
	int p=4;
	pass(p);
	System.out.println(p);
	
}

  
}

