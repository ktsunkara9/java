package inc.skt.terminaloperations;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import inc.skt.practice.Employee;

public class DemoApp1 {

	public static void main(String[] args) {

		List<Employee> employees = Employee.getEmployees();

		Double average = employees.stream().map(Employee::getSal).mapToDouble(sal -> sal).average().getAsDouble();
		System.out.println("Employee Avg Sal : " + average);

		new Employee() {

			public int getId() {
				return new Random().nextInt(1000);
			}

			@Override
			public boolean isActive() {
				return false;
			};
		};

		double a = 10;

		employees.stream().map(Employee::getDepartment).collect(Collectors.toList());
		employees.stream().map(emp -> {
			//return emp.getSal() + a; // local variable defined in an enclosing scope must be final or effectively
										// final
			return null;
		});

		a = 10.8;
	}

}
