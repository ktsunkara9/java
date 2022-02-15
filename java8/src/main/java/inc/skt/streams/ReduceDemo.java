package inc.skt.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceDemo {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(3, 6, 1, 2, 1, 4);
		List<String> frameworks = Arrays.asList("Angular", "Spring", "Akka");

		List<Employee> employees = Arrays.asList(new Employee("Krishna", 3100), new Employee("Teja", 5100),
				new Employee("Sunkara", 6000), new Employee("Krishna Teja", 13000),
				new Employee("Sunkara Krishna Teja", 18000), new Employee("SKT", 9000));

		int sumWithReduce = list.stream().reduce(0, (a, b) -> a + b);
		System.out.println("sum : " + sumWithReduce);

		Optional<Integer> sumWithMethodReference = list.stream().reduce(Integer::sum);
		System.out.println(sumWithMethodReference);

		int product = list.stream().reduce(1, (a, b) -> a * b);
		System.out.println(product);

		Optional<Integer> minWithMethodReference = list.stream().reduce(Integer::min);
		System.out.println("minWithMethodReference : " + minWithMethodReference.get());

		int max = list.stream().reduce(0, (a, b) -> a > b ? a : b);
		System.out.println("max : " + max);

		String longestString = frameworks.stream().reduce((s1, s2) -> s1.length() > s2.length() ? s1 : s2).get();
		System.out.println("longestString : " + longestString);

		double avgSalary = employees.stream().filter(e -> e.getSalary() > 6000).map(e -> e.getSalary())
				.mapToDouble(i -> i).average().getAsDouble();
		System.out.println("avgSalary : " + avgSalary);

		long sumofSalaries = employees.stream().map(e -> e.getSalary()).mapToLong(i -> i).reduce(0,
				(sal1, sal2) -> sal1 + sal2);
		System.out.println("sumofSalaries : " + sumofSalaries);
	}

}

class Employee {
	private String name;
	private long salary;

	public Employee() {
	}

	public Employee(String name, long salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + "]";
	}

}
