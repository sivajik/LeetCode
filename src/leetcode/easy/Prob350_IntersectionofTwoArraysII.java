package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prob350_IntersectionofTwoArraysII {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(intersect(new int[] { 1, 2, 2, 1 }, new int[] { 2, 2 })));
		System.out.println(Arrays.toString(intersect(new int[] { 4, 9, 5 }, new int[] { 9, 4, 9, 8, 4 })));

	}

	static public int[] intersect(int[] nums1, int[] nums2) {
		int i = 0;
		int j = 0;

		Arrays.sort(nums1);
		Arrays.sort(nums2);

		List<Integer> list = new ArrayList<>();

		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] == nums2[j]) {
				list.add(nums1[i]);
				i++;
				j++;
			} else if (nums1[i] < nums2[j]) {
				i++;
			} else {
				j++;
			}
		}

		int[] op = new int[list.size()];
		for (i = 0; i < list.size(); i++) {
			op[i] = list.get(i);
		}
		return op;
	}
}
