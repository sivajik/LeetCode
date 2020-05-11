package leetcode.easy;

import java.util.Arrays;

public class Prob349_IntersectionTwoSets {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(intersection(new int[] { 1, 2, 2, 1 }, new int[] { 2, 3 })));
		System.out.println(Arrays.toString(intersection(new int[] { 4, 9, 5 }, new int[] { 9, 4, 9, 8, 4 })));
	}

	public static int[] intersection(int[] nums1, int[] nums2) {
		java.util.Arrays.sort(nums1);
		java.util.Arrays.sort(nums2);

		int i = 0;
		int j = 0;

		java.util.Set<Integer> l = new java.util.HashSet<>();
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] == nums2[j]) {
				l.add(nums1[i]);
				i++;
				j++;
			} else if (nums1[i] < nums2[j]) {
				i++;
			} else {
				j++;
			}
		}

		int[] res = new int[l.size()];
		int c = 0;
		for (int k : l) {
			res[c++] = k;
		}
		return res;
	}
}
