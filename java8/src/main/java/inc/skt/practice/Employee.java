package inc.skt.practice;

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

}
