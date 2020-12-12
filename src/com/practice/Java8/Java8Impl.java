package com.practice.Java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class Java8Impl {
    private int x;
    int i[]= new int[5];
	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(3, 4, 2, 7, 8, 15);
		String strVal= "abd";
		//Double age= Double.parseDouble(strVal);
		String a[]= new String[10];
		System.out.println(a[0] + new Java8Impl().i[2]);

		// list.forEach(System.out::println); Stream API's

		// list.forEach(i -> System.out.println(i)); //lamda expression

		/*
		 * Consumer<Integer> consumer = new Consumer<Integer>() {
		 * 
		 * @Override public void accept(Integer t) { // TODO Auto-generated method stub
		 * System.out.println(t); } }; list.forEach(consumer);
		 */

		/*
		 * Function<Integer, Integer> fc= new Function<Integer, Integer>() {
		 * 
		 * @Override public Integer apply(Integer t) { // TODO Auto-generated method
		 * stub
		 * 
		 * return t*2; } };
		 */
		// list.forEach(i -> System.out.println(doubleIt(i)));
		// list.forEach(Java8Impl::doubleIt);

		Function<Integer, Integer> f = new Function<Integer, Integer>() {

			@Override
			public Integer apply(Integer t) {
				return t * 2;
			}
		};

		BinaryOperator<Integer> b = new BinaryOperator<Integer>() {

			@Override
			public Integer apply(Integer t, Integer u) {
				return t + u;
			}
		};

		Stream<Integer> s = list.stream();
		Stream<Integer> s1 = s.map(f);
		Integer s3 = s1.reduce(0, b);

		System.out.println(s3);

		System.out.println(list.stream().map(f).reduce(0, b));

		System.out.println(list.stream().map(t -> t * 2).reduce(0, (t, u) -> (t + u)));
		System.out.println(list.stream().map(t -> t * 2).reduce(0, Integer::sum));

	}

	public static void doubleIt(Integer i) {
		// TODO Auto-generated method stub
		System.out.println(i * 2);
	}

}
