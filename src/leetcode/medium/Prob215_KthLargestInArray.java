package leetcode.medium;

import java.util.Collections;
import java.util.PriorityQueue;

public class Prob215_KthLargestInArray {

	public static void main(String[] args) {
		System.out.println(findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2));
		System.out.println(findKthLargest(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4));
	}

	public static int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		for (int num : nums) {
			q.add(num);
		}

		int result = -1;
		while (k > 0) {
			result = q.remove();
			k--;
		}
		return result;
	}
}
