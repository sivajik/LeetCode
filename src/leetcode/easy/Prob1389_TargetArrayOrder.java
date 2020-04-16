package leetcode.easy;

import java.util.Arrays;

public class Prob1389_TargetArrayOrder {

	public static void main(String[] args) {
		System.out
				.println(Arrays.toString(createTargetArray(new int[] { 0, 1, 2, 3, 4 }, new int[] { 0, 1, 2, 2, 1 })));

		System.out
		.println(Arrays.toString(createTargetArray(new int[] { 1 }, new int[] { 0})));

	}

	/*
	 * cant deal with array shift. so picked linkedlist
	 */
	public static int[] createTargetArray(int[] nums, int[] index) {
		java.util.List<Integer> list = new java.util.LinkedList<>();

		for (int i = 0; i < index.length; i++) {
			int currIndex = index[i];
			int elementToSave = nums[i];

			if (list.size() == 0) {
				list.add(elementToSave);
			} else {
				if (currIndex == list.size()) {
					list.add(elementToSave);
				} else {
					list.add(currIndex, elementToSave);
				}
			}

		}

		int[] arr = new int[list.size()];
		int c = 0;
		for (Integer i : list) {
			arr[c++] = i;
		}
		return arr;

	}
}