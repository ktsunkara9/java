package inc.skt.optionals;

import java.util.Arrays;
import java.util.List;

public class Person {

	private int id;
	private String name;
	private String email;
	private List<String> phoneNumbers;

	public Person() {
	}

	public Person(int id, String name, String email, List<String> phoneNumbers) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNumbers = phoneNumbers;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", email=" + email + ", phoneNumbers=" + phoneNumbers + "]";
	}
	
	public static List<Person> getPersons() {
		return Arrays.asList(new Person(1, "Krishna", null, Arrays.asList("8888888", "9999999")),
				new Person(1, "Krishna", null, Arrays.asList("7777777", "6666666")),
				new Person(1, "Krishna", null, Arrays.asList("5555555", "4444444")),
				new Person(1, "Krishna", null, Arrays.asList("3333333", "2222222")));
	}

}
