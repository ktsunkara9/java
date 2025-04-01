package inc.skt.arrays;

import java.util.Arrays;

public class EmployeeSalarySorter {

	public static void main(String[] args) {

		Employee[] empArr = new Employee[4];
		empArr[0] = new Employee(121000);
		empArr[1] = new Employee(111000);
		empArr[2] = new Employee(81000);
		empArr[3] = new Employee(221000);
		System.out.println(Arrays.toString(empArr));

		Arrays.sort(empArr);
		System.out.println(Arrays.toString(empArr));
	}

}

class Employee implements Comparable<Employee> {
	double salary;

	Employee(double salary) {
		this.salary = salary;
	}

	public String toString() {
		return this.salary + "";
	}

	public int compareTo(Employee emp) {
		if (this.salary > emp.salary) {
			return 1;
		}
		if (this.salary < emp.salary) {
			return -1;
		}
		return 0;
	}

}