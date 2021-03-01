package leetcode.easy;

import java.util.PriorityQueue;

public class Prob703_KthLargestElementinaStream {

	public static void main(String[] args) {
		KthLargest kthLargest = new KthLargest(3, new int[] { 4, 5, 8, 2 });
		System.out.println(kthLargest.add(3)); // return 4
		System.out.println(kthLargest.add(5)); // return 5
		System.out.println(kthLargest.add(10)); // return 5
		System.out.println(kthLargest.add(9)); // return 8
		System.out.println(kthLargest.add(4)); // return 8
	}

	static class KthLargest {
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		int k;

		public KthLargest(int k, int[] nums) {
			this.k = k;
			for (int n : nums) {
				add(n);
			}
		}

		public int add(int val) {
			pq.add(val);
			if (pq.size() > k) {
				pq.poll();
			}
			return pq.peek();
		}
	}
}
