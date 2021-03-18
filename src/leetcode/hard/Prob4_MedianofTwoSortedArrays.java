package leetcode.hard;

import java.util.LinkedList;
import java.util.List;

public class Prob4_MedianofTwoSortedArrays {

	public static void main(String[] args) {
		System.out.println(findMedianSortedArrays(new int[] { 1, 3 }, new int[] { 2 }));
		System.out.println(findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 3, 4 }));
		System.out.println(findMedianSortedArrays(new int[] { 0, 0 }, new int[] { 0, 0 }));
		System.out.println(findMedianSortedArrays(new int[] {}, new int[] { 1 }));
	}

	static public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		List<Integer> list = new LinkedList<>();

		int i = 0;
		int j = 0;

		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				list.add(nums1[i++]);
			} else if (nums1[i] > nums2[j]) {
				list.add(nums2[j++]);
			} else {
				list.add(nums1[i++]);
				list.add(nums2[j++]);
			}
		}

		while (i < nums1.length) {
			list.add(nums1[i++]);
		}

		while (j < nums2.length) {
			list.add(nums2[j++]);
		}

		System.out.println(list);
		int size = list.size();
		if (list.size() % 2 == 0) {
			// 0 1 2 3 4
			return (list.get(size / 2) + list.get((size / 2) - 1)) / 2.0;
		} else {
			return list.get(size / 2);
		}
	}
}
