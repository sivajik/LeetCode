package leetcode.easy;

import java.util.Arrays;

public class Prob349_TwoArrayIntersection {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(intersection(new int[] { 4, 9, 5 }, new int[] { 9, 4, 9, 8, 4, 5 })));
		System.out.println(Arrays.toString(intersection(new int[] { 4 }, new int[] { 9 })));
		System.out.println(Arrays.toString(intersection(new int[] { 4, 9, 5 }, new int[] { 4, 9, 5 })));
	}

	public static int[] intersection(int[] nums1, int[] nums2) {
		int[] result = null;

		java.util.Set<Integer> set1 = new java.util.HashSet<Integer>();
		java.util.Set<Integer> set2 = new java.util.HashSet<Integer>();

		for (int num : nums1) {
			set1.add(num);
		}

		for (int num : nums2) {
			set2.add(num);
		}

		if (set1.size() <= set2.size()) {
			// 4 9 5
			// 4 9 8 7 6
			set2.retainAll(set1);
			result = new int[set2.size()];
			int c = 0;
			for (int i : set2) {
				result[c++] = i;
			}
			return result;
		} else {
			set1.retainAll(set2);
			result = new int[set1.size()];
			int c = 0;
			for (int i : set1) {
				result[c++] = i;
			}
			return result;
		}
	}
}
