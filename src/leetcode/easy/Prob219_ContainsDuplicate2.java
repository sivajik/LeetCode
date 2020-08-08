package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class Prob219_ContainsDuplicate2 {

	public static void main(String[] args) {
		System.out.println(containsNearbyDuplicate(new int[] { 1, 2, 3, 1 }, 3));
		System.out.println(containsNearbyDuplicate(new int[] { 1, 0, 1, 1 }, 1));
		System.out.println(containsNearbyDuplicate(new int[] { 1, 2, 3, 1, 2, 3 }, 2));
		System.out.println(containsNearbyDuplicate(new int[] { 2147483647, -2147483648, 2147483647, -2147483648 }, 2));

	}

	static public boolean containsNearbyDuplicate(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i]) && map.get(nums[i]) != i) {
				int prevIndex = map.get(nums[i]);
				if (Math.abs(i - prevIndex) <= k) {
					return true;
				}
			}
			map.put(nums[i], i);

		}
		return false;
	}
}
