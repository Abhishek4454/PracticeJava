package com.practice.Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.Comparator;


public class MyCollectorJ8 {

	public static List<Person> createPeople() {
		List<Person> listp = new ArrayList<Person>();
		listp.add(new Person("Abhishek", 32));
		listp.add(new Person("Abhishek", 33));
		listp.add(new Person("Abhishek", 34));

		listp.add(new Person("Neha", 26));
		listp.add(new Person("Neha", 27));
		listp.add(new Person("Neha", 28));

		listp.add(new Person("Ayush", 20));
		listp.add(new Person("Monu", 30));
		listp.add(new Person("Simmi", 20));
		listp.add(new Person("Arya", 18));
		listp.add(new Person("Om", 9));
		listp.add(new Person("Soumya", 11));
		listp.add(new Person("Sippy", 31));

		return listp;
	}

	public static void main(String[] args) {
		// how to filter out the person from the list<Person> where person.getAge()>30

		/*
		 * createPeople().stream() .map(Person::getName) .forEach(System.out::println);
		 */
		/*
		 * createPeople().stream() .map(Person -> Person.getAge())
		 * .forEach(System.out::println);
		 */
		// Sum of age of all the persons
		System.out.println("Summ of ages : " + createPeople().stream().map(Person -> Person.getAge())
				// .reduce(0,(total,age)->total+age)
				// .reduce(0,(total,age)->Integer.sum(total+age))
				.reduce(0, Integer::sum));
		// reduce converts stream to something concrete
		// two types of reduce function a)reduce b)collector

		// get the list of name in uppercase whose age >30
		// createPeople().stream().filter(Person->Person.getAge()>30).map(Person->Person.getName().toUpperCase()).forEach(System.out::println);;

		// Dont do this.It gets mutated
		List<String> namesOlderThan30 = new ArrayList<String>();
		createPeople().stream().filter(Person -> Person.getAge() > 30).map(Person -> Person.getName().toUpperCase())
				.forEach(name -> namesOlderThan30.add(name));
		// System.out.println(namesOlderThan30);

		List<String> namesOlderThan20 = createPeople().stream().filter(Person -> Person.getAge() > 20)
				.map(Person -> Person.getName().toUpperCase()).collect(Collectors.toList());
		// System.out.println(namesOlderThan20);

		// Name as key and Age as value
		Map<String, Integer> nameAndage = new HashMap<String, Integer>();
		for (Person person : createPeople())
			nameAndage.put(person.getName(), person.getAge());
		// System.out.println(nameAndage);

		// System.out.println(createPeople().stream().collect(Collectors.toMap(Person ->
		// Person.getName(), Person -> Person.getAge())));
		// to get all the ages in the list which is immiutable
		// System.out.println(createPeople().stream().map(Person->Person.getAge()).collect(Collectors.collectingAndThen(Collectors.toList(),
		// Collections::unmodifiableList)));

		// To get the Names with comma seperated
		/*
		 * for(Person per:createPeople()) { if(per.getAge()>20)
		 * System.out.print(per.getName() +",");//We have the comma at the end }
		 */
		// To get the Names with comma seperated with streams
		// System.out.println(createPeople().stream().filter(Person->Person.getAge()>20).map(Person::getName).map(String::toUpperCase).collect(Collectors.joining(",")));

		// application of partionBy
		// Lets partion the person based on odd and even ages
		// System.out.println(createPeople().stream().collect(Collectors.partitioningBy(Person->Person.getAge()%2==0)));

		// group the people based on thier names
		/*
		 * Map<String, List<Person>> byname= new HashMap<String, List<Person>>();
		 * for(Person person:createPeople()) { List<Person> list= null; if
		 * (byname.containsKey(person.getName())) { list=byname.get(person.getName());
		 * }else { list=new ArrayList<Person>(); byname.put(person.getName(), list); }
		 * list.add(person); } System.out.println(byname); }
		 */
		// same group by can be done by collectors
		System.out.println("Group by Name :- "
				+ createPeople().stream().collect(Collectors.groupingBy(Person -> Person.getName())));
		// grouping by name and list of age
		System.out.println("Groupping by Name as key and list<age> as value : "
				+ createPeople().stream().collect(Collectors.groupingBy(Person -> Person.getName(),
						Collectors.mapping(Person::getAge, Collectors.toList()))));
		// counting the names and groupping

		// Counting always accepts Map<String, Long> so in this case we aill get error
		// Map<String, Integer> counting=
		// createPeople().stream().collect(Collectors.groupingBy(Person->Person.getName(),Collectors.mapping(Person::getAge,
		// Collectors.counting())));
		Map<String, Integer> counting = createPeople().stream()
				.collect(Collectors.groupingBy(Person -> Person.getName(), Collectors.mapping(Person::getAge,
						Collectors.collectingAndThen(Collectors.counting(), Long::intValue))));
		System.out.println("Groupping by Name and counting them : " + createPeople().stream().collect(Collectors
				.groupingBy(Person -> Person.getName(), Collectors.mapping(Person::getAge, Collectors.counting()))));
		
		
		System.out.println("Max value of the age : " + createPeople().stream().mapToInt(Person::getAge).max());
		System.out.println("Min value of the age : " + createPeople().stream().mapToInt(Person::getAge).min());
		// Now we need to have the person name with the maximum age..Here we can use
		// maxBy
		System.out.println("Max by Age : "
				+ createPeople().stream().collect(Collectors.maxBy(Comparator.comparing(Person::getAge))));// This
																											// returns
																											// entire
																											// person
		/*
		 * String result= createPeople().stream()
		 * .collect(Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(
		 * Person::getAge)), Person->Person.map(Person::getName)));
		 */
		
		//System.out.println("Max by Age : " +result);// This returns name of person

		// Now we need to have the person name with the minimum age..Here we can use
		// maxBy
		System.out.println("Min by Age : "
				+ createPeople().stream().collect(Collectors.minBy(Comparator.comparing(Person::getAge))));

		//Flat Map
		
		Object oa= new Float[20];
		int []ia= new int[15];
		List<Integer> numbers= Arrays.asList(1,2,3,4);
		
		System.out.println("One to one with Map :- "+numbers.stream().map( e -> e*2).collect(Collectors.toList()));
		System.out.println("One to Many with Map with toList :- "+ numbers.stream().map( e -> Arrays.asList(e-1,e+1)).collect(Collectors.toList()));
		System.out.println("One to Many with FlatMap with toList :- "+ numbers.stream().flatMap( e -> Arrays.asList(e-1,e+1).stream()).collect(Collectors.toList()));

		System.out.println("One to Many with Map with toSet :- "+ numbers.stream().map( e -> Arrays.asList(e-1,e+1)).collect(Collectors.toSet()));
		System.out.println("One to Many with FlatMap with toSet :- "+ numbers.stream().flatMap( e -> Arrays.asList(e-1,e+1).stream()).collect(Collectors.toSet()));
            
		
		System.out.println("group by age : "+ createPeople().stream().collect(Collectors.groupingBy(Person::getAge)));
	}
}

class Person {

	private String name;
	private int age;

	public Person() {

	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}
