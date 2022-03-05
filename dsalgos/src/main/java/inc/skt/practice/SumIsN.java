package inc.skt.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SumIsN {

	// [1,2,3,9] => 8 // false
	// [1,2,4,4] => 8 // true
	public static void main(String[] args) {

		int[] arr1 = { 3, 9, 3, 1 };
		System.out.println(isPairSumEight(arr1));

		int[] arr2 = { 1, 3, 2, 5, 1, 1, 4, 6, 7 };
		System.out.println(isPairSumEight(arr2));

		int[] emptyArr = {};
		System.out.println("emptyArr : " + isPairSumEight(emptyArr));

		System.out.println(isPairSumEightOrderOfN(arr1, arr1.length));
		System.out.println(isPairSumEightOrderOfN(arr2, arr2.length));
		System.out.println("emptyArr : " + isPairSumEightOrderOfN(emptyArr, emptyArr.length));

		System.out.println(isPairSumEightWithSortAndBinarySearch(arr2, 8));
		System.out.println("emptyArr : " + isPairSumEightWithSortAndBinarySearch(emptyArr, 8));

		System.out.println(isPairSumEightWithComplements(arr2, 8));
	}

	private static boolean isPairSumEightWithComplements(int[] arr, int searchValue) {

		Set<Integer> compSet = new HashSet<>();

		for (int i = 0; i < arr.length; i++) {
			
			if (compSet.contains(arr[i])) {
				return true;
			} else {
				compSet.add(searchValue - arr[i]);
			}

			System.out.println(compSet);
		}

		return false;
	}

	// O(n^2)
	public static boolean isPairSumEight(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == 8) {
					System.out.println(arr[i] + " + " + arr[j]);
					return true;
				}
			}

		}

		return false;
	}

	// O(n)
	public static boolean isPairSumEightOrderOfN(int[] arr, int length) {

		int i = 0;
		int j = length - 1;

		while (i < j && i != j) {

			if (arr[i] + arr[j] == 8)
				return true;

			if (arr[i] + arr[j] < 8) {
				System.out.println(arr[i] + arr[j] + " increment i " + "i=" + i + " j=" + j);
				i++;
			} else if (arr[i] + arr[j] > 8) {
				System.out.println(arr[i] + arr[j] + " decrement j " + "i=" + i + " j=" + j);
				j--;
			}
		}

		return false;
	}

	// O(nlogn)
	public static boolean isPairSumEightWithSortAndBinarySearch(int[] arr, int sum) {
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		for (int i = 0; i < arr.length - 1; i++) {
			System.out.println();
			int searchValue = sum - arr[i];
			System.out.println("currentValue : " + arr[i] + " searchValue : " + searchValue);

			int foundAtIndex = iterativeBinarySearch(arr, i, searchValue);
			System.out.println("foundAtIndex : " + foundAtIndex);
			if (foundAtIndex != -1)
				return true;
		}
		return false;
	}

	public static int iterativeBinarySearch(int arr[], int start, int searchValue) {
		int end = arr.length;

		while (start < end) {

			int mid = (start + end) / 2;

			if (arr[mid] == searchValue)
				return mid;

			if (searchValue < arr[mid]) {
				end = mid;
			} else if (searchValue > arr[mid]) {
				start = mid + 1;
			}

		}
		return -1;
	}

}
