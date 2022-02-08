package inc.skt.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapDemo {

	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(
				new Person("Krishna", "Sunkara", 29, Arrays.asList("88888888888", "999999999")),
				new Person("Krishna", "Sunkara", 29, Arrays.asList("7777777", "666666")),
				new Person("Krishna", "Sunkara", 29, Arrays.asList("5555555", "4444444")),
				new Person("Krishna", "Sunkara", 29, Arrays.asList("33333333", "2222222")),
				new Person("Krishna", "Sunkara", 29, Arrays.asList("111111", "999999999")));
		List<List<String>> mobileNumbersUsingMap = persons.stream().map(person -> person.getMobileNumbers())
				.collect(Collectors.toList());
		System.out.println("mobileNumbersUsingMap " + mobileNumbersUsingMap);

		System.out.println();
		List<String> mobileNumbersUsingFlatMap = persons.stream().flatMap(person -> person.getMobileNumbers().stream())
				.collect(Collectors.toList());
		System.out.println("mobileNumbersUsingFlatMap " + mobileNumbersUsingFlatMap);
	}

}

class Person {
	private String firstname;
	private String lastname;
	private int age;
	private List<String> mobileNumbers;

	public Person() {
	}

	public Person(String firstname, String lastname, int age, List<String> mobileNumbers) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.mobileNumbers = mobileNumbers;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public List<String> getMobileNumbers() {
		return mobileNumbers;
	}

	public void setMobileNumbers(List<String> mobileNumbers) {
		this.mobileNumbers = mobileNumbers;
	}

	@Override
	public String toString() {
		return "Person [firstname=" + firstname + ", lastname=" + lastname + ", age=" + age + ", mobileNumbers="
				+ mobileNumbers + "]";
	}

}