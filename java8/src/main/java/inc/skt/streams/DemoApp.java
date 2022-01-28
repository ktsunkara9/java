package inc.skt.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DemoApp {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();
		list.add(50);
		list.add(36);
		list.add(26);
		list.add(65);
		list.add(81);
		list.add(25);
		list.add(93);
		
		Integer[] i = list.stream().toArray(Integer[]::new);

		long numFailed = list.stream().filter(m -> m < 35).count();
		System.out.println(numFailed);

		List<Integer> failedList = list.stream().filter(m -> m < 35).collect(Collectors.toList());
		System.out.println(failedList);

		List<Integer> listAfterAddingFive = list.stream().map(m -> m + 5).collect(Collectors.toList());
		System.out.println(listAfterAddingFive);

		List<Integer> sortedList = list.stream().sorted().collect(Collectors.toList());
		System.out.println("sortedList " + sortedList);

		int minElementInNaturalOrderSortedList = list.stream().min((i1, i2) -> i1.compareTo(i2)).get();
		System.out.println("minElementInNaturalOrderSortedList : " + minElementInNaturalOrderSortedList);

		int maxElementInNaturalOrderSortedList = list.stream().max((i1, i2) -> i1.compareTo(i2)).get();
		System.out.println("maxElementInNaturalOrderSortedList : " + maxElementInNaturalOrderSortedList);

		int minElementInReverseOrderSortedList = list.stream().min((i1, i2) -> -i1.compareTo(i2)).get();
		System.out.println("minElementInReverseOrderSortedList : " + minElementInReverseOrderSortedList);

		int maxElementInReverseOrderSortedList = list.stream().max((i1, i2) -> -i1.compareTo(i2)).get();
		System.out.println("maxElementInReverseOrderSortedList : " + maxElementInReverseOrderSortedList);

		List<Integer> reverseSortedList = list.stream().sorted((m1, m2) -> (m1 > m2) ? -1 : (m1 < m2) ? 1 : 0)
				.collect(Collectors.toList());
		System.out.println("reverseSortedList " + reverseSortedList);

		List<Integer> sortedListUsingCompareTo = list.stream().sorted((m1, m2) -> m1.compareTo(m2))
				.collect(Collectors.toList());

		System.out.println("sortedListUsingCompareTo " + sortedListUsingCompareTo);

		List<Integer> reverseSortedListUsingCompareTo = list.stream().sorted((m1, m2) -> -m1.compareTo(m2))
				.collect(Collectors.toList());

		System.out.println("reverseSortedListUsingCompareTo " + reverseSortedListUsingCompareTo);
		list.forEach(System.out::println);
		
		Integer[] toIntegerArray = list.stream().toArray(Integer[]::new);
		Arrays.asList(toIntegerArray).forEach(System.out::print);
		
		Stream.of(toIntegerArray).forEach(System.out::println);
		System.out.println("Stream of List");
		Stream.of(list).forEach( System.out::println);
		
		Stream.of(9,99,999,9999).map(num -> num/9).forEach(System.out::println);

		
		List<String> names = new ArrayList<>();
		names.add("Krishna");
		names.add("Teja");
		names.add("Sunkara");
		names.add("Pandu");
		names.add("Karishma");
		names.add("Kavya");
		names.add("Sharmila");
		names.add("Sirisha");
		names.add("Nagarjuna");
		names.add("Krishna Teja");
		names.add("Nagarjuna Rao");
		names.add("Sharmila Sunkara");
		names.add("AA");
		names.add("AAA");
		names.add("AAAA");
		names.add("AAAAAA");
		names.add("AAA");
		names.add("AAAA");

		System.out.println("names " + names);

		// names sorted alphabetically
		List<String> namesSorted = names.stream().sorted().collect(Collectors.toList());
		System.out.println("namesSorted " + namesSorted);

		// names sorted using size ascending
		List<String> namesWithSizeAscending = names.stream().sorted((n1, n2) -> {
			if (n1.length() > n2.length())
				return 1;
			else if (n1.length() < n2.length())
				return -1;
			else
				return 0;
		}).collect(Collectors.toList());

		System.out.println("namesAscending ");
		System.out.println(namesWithSizeAscending);

		// names sorted using size ascending If same Size use alphabetical order
		List<String> namesWithSizeAscendingAndSortedAlphabeticallyForSameSize = names.stream()
				.sorted((n1, n2) -> n1.length() > n2.length() ? 1 : n1.length() < n2.length() ? -1 : n1.compareTo(n2))
				.collect(Collectors.toList());

		System.out.println("namesWithSizeAscendingAndSortedAlphabeticallyForSameSize");
		System.out.println(namesWithSizeAscendingAndSortedAlphabeticallyForSameSize);

		// names Sorted Alphabetically when same then size descending
		List<String> namesSortedAlphabetically = names.stream().sorted((n1, n2) -> {
			if (n1.startsWith(n2) && n1.length() > n2.length())
				return -1;
			else if (n1.startsWith(n2) && n1.length() < n2.length())
				return 1;
			else
				return n1.compareTo(n2);

		}).collect(Collectors.toList());
		System.out.println("namesSortedAlphabetically");
		System.out.println(namesSortedAlphabetically);
		names.stream().forEach(System.out::println);
		
		
	}

}
