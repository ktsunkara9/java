package inc.skt.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FrequencyOfArrayElements {
	// Given an array which may contain duplicates, print all elements and their
	// frequencies.
	//
	// Examples:
	//
	// Input : arr[] = {10, 20, 20, 10, 10, 20, 5, 20}
	// Output : 10 3
//	         20 4
//	         5  1
	//
	// Input : arr[] = {10, 20, 20}
	// Output : 10 1
//	         20 2 
	public static void main(String[] args) {
		int[] arr = { 10, 20, 20, 10, 10, 20, 5, 20 };
		System.out.println("countFrequencyBruteForce");
		int size = arr.length;
		countFrequencyBruteForce(arr, size);
		System.out.println("countFreqUsingHashMap");
		System.out.println("=====================================");
		countFreqUsingHashMap(arr, size);
		System.out.println("Print Elements in the same Order Using HashMap");
		System.out.println("==============================================");
		countFreqUsingHashMapPrinter(arr, size);
	}

	private static void countFreqUsingHashMapPrinter(int[] arr, int size) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < size; i++) {

			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}

		for (int i = 0; i < size; i++) {
			if (map.get(arr[i]) != -1) {
				System.out.println(arr[i] + " - " + map.get(arr[i]));
				map.put(arr[i], -1);
			}

		}
	}

	public static void countFreqUsingHashMap(int[] arr, int size) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
	}

	public static void countFrequencyBruteForce(int[] arr, int size) {
		boolean[] visited = new boolean[size];
		Arrays.fill(visited, false);

		for (int i = 0; i < size; i++) {

			int count = 1;

			if (visited[i] == true)
				continue;

			for (int j = i + 1; j < size; j++) {
				if (arr[i] == arr[j]) {
					visited[j] = true;
					count++;
				}
			}

			System.out.println(arr[i] + " - " + count);

		}

	}

}
