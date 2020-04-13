package leetcode.thirtydays;

import java.util.HashMap;

public class Day13_ContiguousArray {

	public static void main(String[] args) {
//		System.out.println(findMaxLength(new int[] { 1, 1, 1, 1, 0, 0, 0, 0, 0, 1 }));
//		System.out.println(findMaxLength(new int[] { 0, 1 }));
//		System.out.println(findMaxLength(new int[] { 0, 1, 0 }));
		System.out.println(findMaxLength(new int[] { 0, 1, 1, 0, 1, 1, 1, 0 }));
	}

	public static int findMaxLength(int[] nums) {
		int max = Integer.MIN_VALUE;
		HashMap<Integer, Integer> m = new HashMap<>();
		
		m.put(0, -1);
		
		int s = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				nums[i] = -1;
			}
			
			s += nums[i];
			if (m.containsKey(s)) {
				max = Math.max(max, i - m.get(s));
			} else {
				m.put(s, i);
			}
		}
		if (max == Integer.MIN_VALUE)
			return 0;
		return max;
	}
}
