package inc.skt.sorting;

import java.util.Arrays;

public class SelectionSort1 {

	public static void main(String[] args) {
		int arr[] = { 20, 35, -15, 7, 55, 1, -22 };
		System.out.println("Before Sorting : " + Arrays.toString(arr));
		selectionSort(arr);
		System.out.println("After Sorting : " + Arrays.toString(arr));
	}

	static void selectionSort(int[] arr) {

		for (int lastUnsortedIndex = arr.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {

			int maxValIndex = 0;

			for (int i = 1; i <= lastUnsortedIndex; i++) {
				if (arr[i] > arr[maxValIndex]) {
					maxValIndex = i;
				}
			}

			swap(arr, lastUnsortedIndex, maxValIndex);
		}
	}

	private static void swap(int[] arr, int lastUnsortedIndex, int maxValIndex) {
		int temp = arr[maxValIndex];
		arr[maxValIndex] = arr[lastUnsortedIndex];
		arr[lastUnsortedIndex] = temp;
	}

}
