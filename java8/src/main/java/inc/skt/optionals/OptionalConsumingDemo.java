package inc.skt.optionals;

import java.util.Arrays;
import java.util.Optional;

public class OptionalConsumingDemo {

	public static void main(String[] args) throws Exception {
		Person person = new Person(1, "Krishna", null, Arrays.asList("8888888", "9999999"));

		try {
			System.out.println(Optional.ofNullable(person.getEmail()).get());
		} catch (Exception e) {
			System.out.println("Email is null use orElse() or orElseGet() or orElseThrow()");
		}

		if (Optional.ofNullable(person.getEmail()).isPresent()) {
			System.out.println(person.getEmail());
		}

		String emailWithOrElse = Optional.ofNullable(person.getEmail()).orElse(getEmail());
		System.out.println("When Email is Null emailWithOrElse : " + emailWithOrElse);

		String emailWithOrElseGet = Optional.ofNullable(person.getEmail()).orElseGet(() -> getEmail());
		System.out.println("When Email is Null emailWithOrElseGet : " + emailWithOrElseGet);

		Person person1 = new Person(2, "Krishna Teja", "kts@gmail.com", Arrays.asList("8888888", "9999999"));
		System.out.println("map to upperCase : "
				+ Optional.ofNullable(person1.getEmail()).map(String::toUpperCase).orElseGet(() -> getEmail()));

		Optional<String> optionalEmail = Optional.ofNullable(person1.getEmail());
		Optional<Optional<String>> optionalOfOptionalEmail= Optional.of(optionalEmail);
		String upperCaseEmail = optionalOfOptionalEmail.flatMap(value -> value.map(String::toUpperCase)).get();
		System.out.println("upperCaseEmailUsingFlatMap : "+upperCaseEmail);
		
		
		System.out.println("When Email is Null Throw Exception using orElseThrow : "
				+ Optional.ofNullable(person.getEmail()).orElseThrow(() -> new Exception("Email not present")));

	}

	public static String getEmail() {
		System.out.println("random in getEmail()");
		return "random";
	}

	public static String getOptionalEmail(String email) {
		System.out.println("random in getEmail()");
		return email;
	}
}
