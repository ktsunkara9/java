package inc.skt.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class CommonElementsInArrays {

	// ['a','b','c','x'], ['z','y','i'] => false
	// ['a','b','c','x'], ['z','y','x'] => true
	public static void main(String[] args) {

		char[] arr1 = { 'a', 'b', 'c', 'x' };
		char[] arr2 = { 'z', 'y', 'x' };
		System.out.println(IsThereACommonElementInArrays(arr1, arr2));

		System.out.println(IsThereACommonElementInArraysUsingHashMap(arr1, arr2));

		// java 8
		BiFunction<char[], char[], Boolean> commanElement = (a1, a2) -> {
			Map<Character, Boolean> charMap = new HashMap<>();
			for (int i = 0; i < arr1.length; i++) {
				if (!charMap.containsKey(arr1[i]))
					charMap.put(arr1[i], true);
			}

			for (int i = 0; i < arr2.length; i++) {

				if (charMap.containsKey(arr2[i]))
					return true;
			}
			return false;
		};

		System.out.println(commanElement.apply(arr1, arr2));

	}

	// O(a*b)
	private static boolean IsThereACommonElementInArrays(char[] arr1, char[] arr2) {
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				if (arr1[i] == arr2[j])
					return true;
			}
		}
		return false;
	}

	// O(a+b)
	private static boolean IsThereACommonElementInArraysUsingHashMap(char[] arr1, char[] arr2) {
		Map<Character, Boolean> charMap = new HashMap<>();
		for (int i = 0; i < arr1.length; i++) {
			if (!charMap.containsKey(arr1[i]))
				charMap.put(arr1[i], true);
		}

		for (int i = 0; i < arr2.length; i++) {

			if (charMap.containsKey(arr2[i]))
				return true;
		}

		return false;
	}

}
