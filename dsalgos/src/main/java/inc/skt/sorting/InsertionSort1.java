package inc.skt.sorting;

import java.util.Arrays;

public class InsertionSort1 {

	public static void main(String[] args) {
		int arr[] = { 20, 35, -15, 7, 55, 1, -22 };
		System.out.println(Arrays.toString(arr));

		for (int unsortedIndex = 1; unsortedIndex <= arr.length - 1; unsortedIndex++) {
			int element = arr[unsortedIndex];
			int i;
			for (i = unsortedIndex; i > 0 && arr[i - 1] > element; i--) {
				arr[i] = arr[i - 1];
			}
			arr[i] = element;
		}
		System.out.println(Arrays.toString(arr));
	}
}
