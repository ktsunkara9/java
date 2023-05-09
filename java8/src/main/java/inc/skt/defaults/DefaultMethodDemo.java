package inc.skt.defaults;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DefaultMethodDemo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Krishna", "Teja", "Sunkara", "Vamsi", "Kavya", "Nagarjuna", "Sharmila", "Sireesha");
        System.out.println("names before sorting "+names);
        Collections.sort(names);
        System.out.println("names after sorting "+names);

        List<String> namesList = Arrays.asList("Krishna", "Teja", "Sunkara", "Vamsi", "Kavya", "Nagarjuna", "Sharmila", "Sireesha");
        namesList.sort(Comparator.naturalOrder());
        System.out.println("namesList after sorting " +namesList);

        namesList.sort(Comparator.reverseOrder());
        System.out.println("namesList after sorting in reverse order "+ namesList);
    }
}
