package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Prob496_NextGreaterElement1 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(nextGreaterElement(new int[] { 4, 1, 2 }, new int[] { 1, 3, 4, 2 })));
		System.out.println(Arrays.toString(nextGreaterElement(new int[] { 2, 4 }, new int[] { 1, 2, 3, 4 })));
	}

	static public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int[] nh = nextHigher(nums2);

		Map<Integer, Integer> m = new HashMap<>();
		for (int i = 0; i < nums2.length; i++) {
			m.put(nums2[i], nh[i]);
		}

		int[] res = new int[nums1.length];
		for (int i = 0; i < nums1.length; i++) {
			res[i] = m.get(nums1[i]);
		}

		return res;
	}

	private static int[] nextHigher(int[] nums2) {
		Stack<Integer> s = new Stack<>();

		int[] res = new int[nums2.length];

		for (int i = nums2.length - 1; i >= 0; i--) {
			if (i == nums2.length - 1) {
				// last element, so it should be -1.
				res[i] = -1;
				s.push(nums2[i]);
			} else {
				if (!s.isEmpty() && s.peek() > nums2[i]) {
					res[i] = s.peek();
				} else if (!s.isEmpty() && s.peek() < nums2[i]) {
					while (!s.isEmpty() && s.peek() < nums2[i]) {
						s.pop();
					}

					if (!s.isEmpty()) {
						res[i] = s.peek();
					} else {
						res[i] = -1;
					}
				}
				s.push(nums2[i]);
			}
		}
		return res;
	}
}
