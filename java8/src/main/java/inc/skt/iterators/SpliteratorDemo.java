package inc.skt.iterators;

import java.util.List;
import java.util.Spliterator;

import inc.skt.practice.Employee;

public class SpliteratorDemo {

	public static void main(String[] args) {
		List<Employee> employees = Employee.getEmployees();
		System.out.println(employees.size());
		
		Spliterator<Employee> spliterator1 = employees.spliterator();
		Spliterator<Employee> spliterator2 = spliterator1.trySplit();
		
		spliterator1.forEachRemaining(System.out::println);
		System.out.println("============================");
		spliterator2.forEachRemaining(System.out::println);
	}

}
