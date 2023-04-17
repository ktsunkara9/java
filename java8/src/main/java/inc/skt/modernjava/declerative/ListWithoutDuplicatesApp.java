package inc.skt.modernjava.declerative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListWithoutDuplicatesApp {

    public static void main(String[] args) {
        List<Integer> listWithDuplicates = Arrays.asList(1,2,3,3,3,4,5,6,6,6,7,8,8,9,9,10);

        // Imperative Style of Programming
        List<Integer> listWithoutDuplicates1 = new ArrayList<>();
        for(int i=0; i<listWithDuplicates.size(); i++) {
            if(!listWithoutDuplicates1.contains(listWithDuplicates.get(i))) {
                listWithoutDuplicates1.add(listWithDuplicates.get(i));
            }
        }
        System.out.println(listWithoutDuplicates1);

        // Declarative Style of Programming
        List<Integer> listWithoutDuplicates2 = listWithDuplicates.stream()
                                                                .distinct()
                                                                .collect(Collectors.toList());
        System.out.println(listWithoutDuplicates2);
    }
}
