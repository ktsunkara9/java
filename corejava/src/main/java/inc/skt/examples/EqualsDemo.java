package inc.skt.examples;

public class EqualsDemo {

	public static void main(String[] args) {
		
		double d1 = 10000.0;
		double d2 = 10000.0;
		System.out.println(d1 == d2);
		
		Employee e1 = new Employee("Siva", 10000.0);
		Employee e2 = new Employee("Raja", 10000.0);
		System.out.println(e1.equals(e2));
	}

}

class Employee {
	private String name;
	private double sal;
	
	public Employee(String name, Double sal) {
		super();
		this.name = name;
		this.sal = sal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSal() {
		return sal;
	}

	public void setSal(Double sal) {
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", sal=" + sal + "]";
	}
	
	@Override
	public boolean equals(Object x) {
		return this.sal == ((Employee)x).sal;
	}
	
}