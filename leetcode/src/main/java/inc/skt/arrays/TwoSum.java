package inc.skt.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		int[] output = twoSum(new int[] { 3, 2, 4 }, 6);
		System.out.println(Arrays.toString(output));

		int[] output1 = twoSumOrdern(new int[] { 3, 2, 4 }, 6);
		System.out.println(Arrays.toString(output1));
	}

	public static int[] twoSum(int nums[], int target) {

		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target)
					return new int[] { i, j };
			}
		}

		return new int[] {};
	}

	public static int[] twoSumOrdern(int nums[], int target) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				return new int[] { map.get(complement), i };
			}
			map.put(nums[i], i);
		}

		return new int[] {};
	}
}
