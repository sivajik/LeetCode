package leetcode.revision.week02;

import java.util.PriorityQueue;

public class P215_KthLargestElementInArray {

	public static void main(String[] args) {
		System.out.println(findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2));
		System.out.println(findKthLargest(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4));
	}

	static public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> p = new PriorityQueue<>();
		for (int num : nums) {
			p.add(num);
			if (p.size() > k) {
				p.poll();
			}
		}
		return p.poll();
	}
}
