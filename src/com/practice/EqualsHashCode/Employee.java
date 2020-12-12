package com.practice.EqualsHashCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

 class HashEqualsTest {
	public static void main(String[] args) {
		Map<Employee, String> hmap = loadEmployeeCache();
		System.out.println("Employee Size :- " + loadEmployeeCache().size() + "\n" + loadEmployeeCache());
		System.out.println(hmap.get(new Employee(103, "MOnu")));
		Employee ek1 = new Employee(101, "Abhishek");
		Employee ek2 = new Employee(102, "Neha");
		Employee ek3 = new Employee(103, "MOnu");
		Employee ek4 = new Employee(104, "Alka");
		Employee ek5 = new Employee(104, "Alka");
		Employee ek6 = new Employee(104, "Alka");
		Set<Employee> empSet = new HashSet<Employee>();
		empSet.add(ek1);
		empSet.add(ek2);
		empSet.add(ek3);
		empSet.add(ek4);
		empSet.add(ek5);
		empSet.add(ek6);
		System.out.println("Employee Set Size :- " + empSet.size() + "\n" + "Employee Set :- " + empSet.toString());
	}

	static Map<Employee, String> loadEmployeeCache() {
		Employee ek1 = new Employee(101, "Abhishek");
		Employee ek2 = new Employee(102, "Neha");
		Employee ek3 = new Employee(103, "MOnu");
		Employee ek4 = new Employee(104, "Alka");
		Employee ek5 = new Employee(104, "Alka");

		Map<Employee, String> hmap = new HashMap<Employee, String>();
		hmap.put(ek1, "abc");
		hmap.put(ek2, "abcd");
		hmap.put(ek3, "abcde");
		hmap.put(ek4, "abcfg");
		hmap.put(ek5, "abcfg");

		return hmap;
	}
}

 class Employee {
	private int employeeId;
	private String employeeName;

	public Employee(int employeeId, String employeeName) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
	}

	@Override
	public int hashCode() {// when we dont define hashcode method and define only one equals than set wont
							// be able to contain unique values. final
		int prime = 31;
		int result = 1;
		result = prime * result + employeeId;
		result = prime * result + ((employeeName == null) ? 0 : employeeName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (employeeId != other.employeeId)
			return false;
		if (employeeName == null) {
			if (other.employeeName != null)
				return false;
		} else if (!employeeName.equals(other.employeeName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + "]";
	}

}
