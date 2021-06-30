package leetcode.g5.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Prob349_IntersectionOfTwoArrays {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(intersection(new int[] { 1, 2, 2, 1 }, new int[] { 2, 2 })));
		System.out.println(Arrays.toString(intersection(new int[] { 4, 9, 5 }, new int[] { 9, 4, 9, 8, 4 })));
	}

	static public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set1 = new HashSet<Integer>();
		Set<Integer> set3 = new HashSet<Integer>();

		for (int i : nums1) {
			set1.add(i);
		}
		for (int i : nums2) {
			if (set1.contains(i) && !set3.contains(i)) {
				set3.add(i);
			}
		}

		int[] op = new int[set3.size()];
		int c = 0;
		for (int i : set3) {
			op[c++] = i;
		}
		return op;
	}
}
