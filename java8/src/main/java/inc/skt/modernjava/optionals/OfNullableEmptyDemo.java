package inc.skt.modernjava.optionals;

import java.util.Optional;

public class OfNullableEmptyDemo {

    private static Optional<String> ofNullable() {
        return Optional.ofNullable(null);
    }

    private static Optional<String> of() {
        return Optional.of("Hello");
    }

    private static Optional<String> empty() {
        return Optional.empty();
    }

    public static void main(String[] args) {
        System.out.println(ofNullable());
        if(ofNullable().isPresent()) {
            System.out.println(ofNullable().get());
        } else {
            System.out.println("Empty");
        }
        System.out.println("empty: " + empty());
        if(of().isPresent()) {
            System.out.println("of: " + of().isPresent());
        }

    }
}
