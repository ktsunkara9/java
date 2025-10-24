package inc.skt.arrays;

import java.util.Arrays;

/* Given an integer array nums, 
 * return true if any value appears at least twice in the array, 
 * and return false if every element is distinct.
 * */
public class ContainsDuplicate {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		Arrays.sort(nums);
		System.out.println("Contains Duplicate: " + extracted(nums));
	}

	private static boolean extracted(int[] nums) {
		int left = 0, right = 1;
		while (right < nums.length) {
			if (nums[left] == nums[right])
				return true;
			left++;
			right++;
		}
		return false;
	}

}
