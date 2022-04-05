package inc.skt.sorting;

import java.util.Arrays;

public class BubbleSort2 {

	public static void main(String[] args) {
		int arr[] = { 20, 35, -15, 7, 55, 1, -22 };
		System.out.println("Before Sorting : " + Arrays.toString(arr));
		bubbleSort(arr);
		System.out.println("After Sorting : " + Arrays.toString(arr));
	}

	static void bubbleSort(int[] arr) {
		for (int maxUnsortedIndex = arr.length - 1; maxUnsortedIndex > 0; maxUnsortedIndex--) {
			for (int i = 0; i < maxUnsortedIndex; i++) {
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
		}
	}

}
