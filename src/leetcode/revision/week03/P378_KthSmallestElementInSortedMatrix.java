package leetcode.revision.week03;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P378_KthSmallestElementInSortedMatrix {

	public static void main(String[] args) {
		System.out.println(kthSmallest(new int[][] { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } }, 8));
	}

	static public int kthSmallest(int[][] matrix, int k) {
		PriorityQueue<Integer> p = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return -o1 + o2;
			}
		});
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				p.add(matrix[i][j]);

				if (p.size() > k) {
					p.poll();
				}
			}
		}
		return p.poll();
	}
}