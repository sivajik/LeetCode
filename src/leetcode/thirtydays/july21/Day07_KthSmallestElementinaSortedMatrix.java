package leetcode.thirtydays.july21;

import java.util.PriorityQueue;

public class Day07_KthSmallestElementinaSortedMatrix {

	public static void main(String[] args) {
		for (int i = 1; i <= 9; i++) {
			System.out.println(kthSmallest(new int[][] { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } }, i));
		}
	}

	static public int kthSmallest(int[][] matrix, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				pq.add(matrix[i][j]);
			}
		}

		int val = -999;
		while (k > 0) {
			val = pq.poll();
			k--;
		}
		return val;

	}
}
