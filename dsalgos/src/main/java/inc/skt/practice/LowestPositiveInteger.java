package inc.skt.practice;

import java.util.Arrays;
import java.util.List;

public class LowestPositiveInteger {

	// [1,3,6,4,1,2] =5
	// [1,2,3]== 4
	// [-1,-2] => 1
	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(1, 3, 6, 4, 1, 2);
		System.out.println(getLowestPositiveInteger(nums, nums.size()));
		System.out.println(nums);
	}

	public static int getLowestPositiveInteger(List<Integer> nums, int size) {
//		Collections.sort(nums);
		nums.sort((n1, n2) -> n1 > n2 ? 1 : n1 < n2 ? -1 : 0);
		int ans = 1;
		for (int i = 0; i < size; i++) {
			if (nums.get(i) == ans)
				ans++;
			else
				return ans;
		}
		return ans;
	}

}
