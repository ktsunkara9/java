package inc.skt.practice;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Practice1 {

	public static void main(String[] args) {

		List<Employee> employees = Employee.getEmployees();

		System.out.println("===================Employees in each department==========================================");
		Map<String, List<Employee>> empGroupByDepartment = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toList()));

		for (Entry<String, List<Employee>> empListEntry : empGroupByDepartment.entrySet()) {
			System.out.println(empListEntry.getKey() + " - " + empListEntry.getValue());
		}

		empGroupByDepartment.entrySet().forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));

		System.out.println("===================Employees count in each department===================================");
		Map<String, Long> empCountGroupByDepartment = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

		empCountGroupByDepartment.entrySet()
				.forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));

		System.out.println("===================Active & Inactive Employees===================================");

		Map<Boolean, List<Employee>> activeEmployees = employees.stream()
				.collect(Collectors.groupingBy(Employee::isActive, Collectors.toList()));

		activeEmployees.entrySet().forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));

		System.out.println("===================Active & Inactive Employees Count===================================");
		System.out.println("Active Employees : " + employees.stream().filter(emp -> emp.isActive()).count());
		System.out.println("InActive Employees : " + employees.stream().filter(emp -> !emp.isActive()).count());

		System.out.println("===================Max & Min Employee salary===================================");

		Optional<Employee> maxSal = employees.stream().max((e1, e2) -> {
			if (e1.getSal() > e2.getSal())
				return 1;
			else if (e1.getSal() < e2.getSal())
				return -1;
			else
				return 0;
		});
		System.out.println(maxSal.get());

		Comparator<Employee> salComparator = new SalaryComparator();
		Optional<Employee> maxSalEmployee = employees.stream().max(salComparator);
		System.out.println(maxSalEmployee.get().getSal());

		Optional<Employee> minEmployee = employees.stream().min((e1, e2) -> {
			if (e1.getSal() > e2.getSal())
				return 1;
			else if (e1.getSal() < e2.getSal())
				return -1;
			else
				return 0;
		});
		System.out.println("minEmployee:  "+minEmployee.get() + " - " + minEmployee.get().getSal());

		System.out.println("===================Max Employee Salary from Each Department=============================");
		Map<String, Optional<Employee>> maxSalEmpGroupByDepartment = employees.stream().collect(Collectors
				.groupingBy(Employee::getDepartment, Collectors.reducing(BinaryOperator.maxBy(salComparator))));

		maxSalEmpGroupByDepartment.entrySet()
				.forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue().get()));
	}

}

class SalaryComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee e1, Employee e2) {
		if (e1.getSal() > e2.getSal())
			return 1;
		else if (e1.getSal() < e2.getSal())
			return -1;
		else
			return 0;
	}

}
