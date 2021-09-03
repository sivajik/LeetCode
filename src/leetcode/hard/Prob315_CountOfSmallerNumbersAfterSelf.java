package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class Prob315_CountOfSmallerNumbersAfterSelf {

	public static void main(String[] args) {
		System.out.println(countSmaller(new int[] { 5, 2, 6, 1 }));

	}

	static public List<Integer> countSmaller(int[] nums) {
		int n = nums.length;
		List<Integer> count = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			count.add(0);
		}
		sort(count, nums, 0, n - 1);
		return count;
	}

	static int[] merge(List<Integer> count, int[] nums, int[] left, int[] right) {
		int m = left.length;
		int n = right.length;
		int i = 0, j = 0, k = 0;
		int[] arr = new int[m + n];
		int[] temp = new int[m];

		while (i < m && j < n) {
			if (nums[left[i]] < nums[right[j]]) {
				arr[k++] = left[i++];
			} else {
				temp[i] += 1; // denotes inversion count for every index starting from i to m
				arr[k++] = right[j++];
			}
		}
		while (i < m)
			arr[k++] = left[i++];
		while (j < n)
			arr[k++] = right[j++];

		// update the count for every indices
		int curr = 0;
		for (int d = 0; d < m; d++) {
			curr += temp[d];
			count.set(left[d], count.get(left[d]) + curr);
		}

		return arr;
	}

	static int[] sort(List<Integer> count, int[] nums, int start, int end) {
		if (start > end) {
			return new int[] {};
		}
		if (start == end) {
			return new int[] { start };
		}
		int mid = start + (end - start) / 2;
		int[] left = sort(count, nums, start, mid);
		int[] right = sort(count, nums, mid + 1, end);
		return merge(count, nums, left, right);
	}

}
