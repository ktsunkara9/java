package inc.skt.optionals;

import java.util.Arrays;
import java.util.Optional;

public class OptionalCreationDemo {

	public static void main(String[] args) {
		Person person = new Person(1, "Krishna", null, Arrays.asList("8888888", "9999999"));

		// Optional Creation

		Optional<Object> emptyOptional = Optional.empty();
		System.out.println("Optional using empty() method : " + emptyOptional);

		Optional<String> optionalWithEmailNull = Optional.ofNullable(person.getEmail());
		System.out.println("Optional using ofNullable() method : " + optionalWithEmailNull);

		try {
			Optional<String> optionalWithEmailNullUsingOf = Optional.of(person.getEmail());
			System.out.println("Optional using of() method :  " + optionalWithEmailNullUsingOf);
		} catch (Exception e) {
			System.out.println("Value can't be null while creating optional using of() method");
		}

		Person person1 = new Person(1, "Krishna", "kstsdkf", Arrays.asList("8888888", "9999999"));
		Optional<String> optionalWithEmailUsingOf = Optional.of(person1.getEmail());
		System.out.println("Optional using of() method : " + optionalWithEmailUsingOf);

		Optional<String> optionalWithEmailNullUsingOfNullable = Optional.ofNullable(person1.getEmail());
		System.out.println("Optional using ofNullable() method : " + optionalWithEmailNullUsingOfNullable);
	}

}
