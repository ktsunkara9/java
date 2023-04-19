package inc.skt.modernjava.methodreference;

import java.util.function.Function;

public class MethodReferenceDemo {

    static Function<String,String> toUppercaseLambda = (s) -> s.toUpperCase();

    static Function<String,String> getToUppercaseMethodReference = String::toUpperCase;
    public static void main(String[] args) {
        System.out.println(toUppercaseLambda.apply("skt"));
        System.out.println(getToUppercaseMethodReference.apply("skt"));
    }
}
