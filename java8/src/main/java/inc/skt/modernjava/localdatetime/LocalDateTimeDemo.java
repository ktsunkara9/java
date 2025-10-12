package inc.skt.modernjava.localdatetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeDemo {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println("localDate " + localDate);

        LocalTime localTime = LocalTime.now();
        System.out.println("localTIme " + localTime);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime " + localDateTime);
    }
}
