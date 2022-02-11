package inc.skt.hashtable;

public class HashTableWithArrayDemo {

	public static void main(String[] args) {
		Employee krishna = new Employee(1, "Krishna", "Sunkara");
		Employee teja = new Employee(1, "Teja", "Krishna");
		Employee sitaram = new Employee(1, "Sita Ram", "Kelam");
		Employee diwakar = new Employee(1, "Diwakar", "Tandra");
		Employee suresh = new Employee(1, "Suresh", "Yadali");
		Employee nagarjuna = new Employee(1, "Nagarjuna", "Sunkara");

		SimpleHashTable hashTable = new SimpleHashTable();
		hashTable.put("Sunkara", krishna);
		hashTable.put("Krishna", teja);
		hashTable.put("Kelam", sitaram);
		hashTable.put("Tandra", diwakar);
		hashTable.put("Yadali", suresh);
		hashTable.put("Sunkara", nagarjuna);

		hashTable.print();
	}

}

class SimpleHashTable {
	Employee[] employees = null;

	public SimpleHashTable() {
		employees = new Employee[10];
	}

	public void put(String key, Employee emp) {
		int hashedKey = hashKey(key);
		if (employees[hashedKey] != null) {
			System.out.println("Employee is already present : " + key);
		} else {
			employees[hashedKey] = emp;
		}
	}

	private int hashKey(String key) {
		return key.length() % 10;
	}

	public void print() {
		for (int i = 0; i < employees.length; i++) {
			System.out.print(employees[i]+", ");
		}
	}
}

class Employee {
	private int id;
	private String firstname;
	private String lastname;

	public Employee() {
	}

	public Employee(int id, String firstname, String lastname) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}
}
