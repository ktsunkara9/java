package inc.skt.practice;

import java.util.Arrays;
import java.util.List;

public class Employee {

	private int id;
	private String name;
	private String department;
	private boolean isActive;
	private double sal;

	public Employee() {
	}

	public Employee(int id, String name, String department, boolean isActive, double sal) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.isActive = isActive;
		this.sal = sal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", department=" + department + ", isActive=" + isActive
				+ ", sal=" + sal + "]";
	}

	public static List<Employee> getEmployees() {
		return Arrays.asList(new Employee(1, "Krishna", "IT", false, 23000), new Employee(2, "Teja", "IT", true, 17000),
				new Employee(3, "Sunkara", "Software", false, 10000),
				new Employee(4, "Nagarjuna", "Postal", true, 3000), new Employee(5, "Divakar", "Banking", true, 6000),
				new Employee(6, "Ram", "Banking", false, 2000), new Employee(7, "Suresh", "Software", true, 16000),
				new Employee(8, "Sai", "IT", true, 12000), new Employee(9, "Murali", "Banking", true, 3500),
				new Employee(10, "Naveen", "Software", true, 11000), new Employee(11, "Venu", "Postal", false, 2300));
	}

}
