package inc.skt.arrays;

import java.util.Arrays;

/*Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.*/
public class MoveZeros {

	public static void main(String[] args) {
		int[] nums = { 0, 1, 0, 3, 12 };
		System.out.println(Arrays.toString(nums));
		int[] output1 = moveZerosToEnd(nums);
		System.out.println(Arrays.toString(output1));
		int[] output2 = moveZerosToEndInPlace(nums);
		System.out.println(Arrays.toString(output2));
	}

	private static int[] moveZerosToEndInPlace(int[] nums) {
		int nonZeroStorageIndex = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				int temp = nums[i];
				nums[i] = nums[nonZeroStorageIndex];
				nums[nonZeroStorageIndex] = temp;
				nonZeroStorageIndex++;
			}
		}
		return nums;
	}

	private static int[] moveZerosToEnd(int[] nums) {

		int length = nums.length;
		int arr[] = new int[length];
		int numberOfZeros = 0;
		int j = 0;

		for (int i = 0; i < length; i++) {
			if (nums[i] == 0) {
				numberOfZeros++;
			} else {
				arr[j] = nums[i];
				j++;
			}
		}
		for (int i = 0; i < numberOfZeros; i++) {
			arr[length - i - 1] = 0;
		}

		return arr;
	}

}
