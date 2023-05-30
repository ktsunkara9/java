package inc.skt.sorting;

import java.util.Arrays;

public class QuickSortDay18 {

    private static int[] arr = { 20, 35, -15, 7, 55, 1, -22 };
    public static void main(String[] args) {
        int start = 0;
        int end = arr.length - 1;
        quickSort(arr, start, end);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int start, int end) {
        if(start < end) {
            int pivotIndex = partition(arr, start, end);
            quickSort(arr, start, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start;
        for(int j = start + 1; j <= end; j++) {
            if(arr[j] < pivot) {
                i++;
                // swap elements
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // swap pivot
        int temp = arr[start];
        arr[start] = arr[i];
        arr[i] = temp;
        return i;
    }
}
