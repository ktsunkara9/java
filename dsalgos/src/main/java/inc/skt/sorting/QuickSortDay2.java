package inc.skt.sorting;

import java.util.Arrays;

public class QuickSortDay2 {
    static int[] arr = {20, 35, -15, 7, 55, 1, -22};
    public static void main(String[] args) {
        System.out.println("Before Sorting "+ Arrays.toString(arr));
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
        System.out.println("pivot "+pivot);
        for(int j = start; j <= end; j++) {
            if(arr[j] < pivot) {
                //  swap elements
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            System.out.println(Arrays.toString(arr));
        }
        // swap pivot
        int temp = arr[start];
        arr[start] = arr[i];
        arr[i] = temp;
        System.out.println(Arrays.toString(arr));
        return i;
    }
}
