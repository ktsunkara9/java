package inc.skt.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*Given two integer arrays nums1 and nums2, return an array of their intersection. 
 * Each element in the result must be unique and you may return the result in any order.
 */

public class IntersectionOfArrays {

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 2, 1 };
		int[] nums2 = { 2, 2 };
		int[] result = intersectionByBruteforce(nums1, nums2);
		System.out.println(Arrays.toString(result));

		int[] result2 = intersectionUsingSets(nums1, nums2);
		System.out.println(Arrays.toString(result2));

		int[] result3 = intersectionUsingHashMap(nums1, nums2);
		System.out.println(Arrays.toString(result3));

		int[] result4 = intersectionUsingTwoPointers(nums1, nums2);
		System.out.println(Arrays.toString(result4));

		int[] nums3 = { 4, 9, 5 };
		int[] nums4 = { 9, 4, 9, 8, 4 };
		int[] result5 = intersectionUsingBinarySearch(nums3, nums4);
		System.out.println(Arrays.toString(result5));
	}

	public static int[] intersectionByBruteforce(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet();
		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				if (nums1[i] == nums2[j]) {
					set.add(nums1[i]);
				}
			}
		}
		int[] arr = new int[set.size()];
		int index = 0;
		if (set.size() > 0) {
			for (Integer i : set) {
				arr[index] = i;
				index++;
			}
		}
		return arr;
	}

	public static int[] intersectionUsingSets(int[] nums1, int[] nums2) {
		Set<Integer> set1 = new HashSet();
		for (int i = 0; i < nums1.length; i++) {
			set1.add(nums1[i]);
		}

		Set<Integer> resultSet = new HashSet();
		for (int i = 0; i < nums2.length; i++) {
			if (set1.contains(nums2[i])) {
				resultSet.add(nums2[i]);
			}
		}

		int[] result = new int[resultSet.size()];
		int k = 0;
		for (Integer i : resultSet) {
			result[k] = i;
			k++;
		}

		return result;
	}

	public static int[] intersectionUsingHashMap(int[] nums1, int[] nums2) {
		Map<Integer, Boolean> map = new HashMap();
		for (int i = 0; i < nums1.length; i++) {
			map.put(nums1[i], true);
		}

		List<Integer> resultList = new ArrayList();
		for (int i = 0; i < nums2.length; i++) {
			if (map.containsKey(nums2[i]) && map.get(nums2[i])) {
				resultList.add(nums2[i]);
				map.put(nums2[i], false);
			}
		}

		int[] arr = new int[resultList.size()];
		for (int i = 0; i < resultList.size(); i++) {
			arr[i] = resultList.get(i);
		}
		return arr;
	}

	public static int[] intersectionUsingTwoPointers(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);

		int i = 0;
		int j = 0;
		Set<Integer> set = new HashSet();

		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] == nums2[j]) {
				set.add(nums1[i]);
				i++;
				j++;
			} else if (nums1[i] < nums2[j]) {
				i++;
			} else {
				j++;
			}
		}
		int[] result = new int[set.size()];
		int index = 0;
		for (Integer k : set) {
			result[index] = k;
			index++;
		}
		return result;
	}

	public static int[] intersectionUsingBinarySearch(int[] nums1, int[] nums2) {
		Arrays.sort(nums2);

		Set<Integer> resultSet = new HashSet();
		for (int i = 0; i < nums1.length; i++) {
			if (binarySearch(nums1[i], nums2)) {
				resultSet.add(nums1[i]);
			}
		}

		int[] result = new int[resultSet.size()];
		int i = 0;
		for (Integer integer : resultSet) {
			result[i] = integer;
			i++;
		}

		return result;
	}

	public static boolean binarySearch(int target, int[] arr) {
		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;
			if (arr[mid] == target)
				return true;
			else if (target > arr[mid])
				left = mid + 1;
			else
				right = mid - 1;
		}
		return false;
	}

}
