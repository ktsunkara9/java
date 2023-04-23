package inc.skt.search;

public class BinarySearchIterative {
    public static void main(String[] args) {
        int[] arr = { -22, -15, 1, 7, 20, 35, 55 };

        System.out.println(iterativeBinarySearch(arr, 1));
        System.out.println(iterativeBinarySearch(arr, 7));
        System.out.println(iterativeBinarySearch(arr, -22));
        System.out.println(iterativeBinarySearch(arr, 55));
        System.out.println(iterativeBinarySearch(arr, 123));

        System.out.println("********** Using Recursion **********");

        System.out.println(recursiveBinarySearch(arr, 1));
        System.out.println(recursiveBinarySearch(arr, 7));
        System.out.println(recursiveBinarySearch(arr, -22));
        System.out.println(recursiveBinarySearch(arr, 55));
        System.out.println(recursiveBinarySearch(arr, 123));
    }

    public static int iterativeBinarySearch(int[] arr, int val) {
        int start = 0;
        int end = arr.length;

        while(start < end) {
            int mid = (start + end) / 2;

            if(val == arr[mid]) {
                return mid;
            } else if(val < arr[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static int recursiveBinarySearch(int[] arr, int val) {
        int start = 0;
        int end = arr.length;
        return recursiveBinarySearch(arr, start, end, val);
    }

    public static int recursiveBinarySearch(int[] arr, int start, int end, int val) {
        if(start >= end ) {
            return -1;
        }

        int mid = (start + end) / 2;

        if( val == arr[mid] ) {
            return mid;
        } else if( val < arr [mid] ) {
           return recursiveBinarySearch(arr, start, mid, val);
        } else {
           return recursiveBinarySearch(arr, mid+1, end, val);
        }

    }
}
