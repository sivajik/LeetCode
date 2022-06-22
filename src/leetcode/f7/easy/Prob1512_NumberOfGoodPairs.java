package leetcode.f7.easy;

import java.util.HashMap;
import java.util.Map;

public class Prob1512_NumberOfGoodPairs {

	public static void main(String[] args) {
		System.out.println(numIdenticalPairs(new int[] { 1, 2, 3, 1, 1, 3 }) == 4);
		System.out.println(numIdenticalPairs(new int[] { 1, 1, 1, 1 }) == 6);
		System.out.println(numIdenticalPairs(new int[] { 1, 2, 3 }) == 0);
	}

	static public int numIdenticalPairs(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				map.put(nums[i], 1 + map.get(nums[i]));
			} else {
				map.put(nums[i], 1);
			}
		}

		int sum = 0;
		for (int eachKey : map.keySet()) {
			int val = map.get(eachKey);
			if (val > 1) {
				sum += (val * (val - 1)) / 2;
			}
		}
		return sum;
	}
}
