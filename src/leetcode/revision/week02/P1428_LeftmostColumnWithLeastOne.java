package leetcode.revision.week02;

import java.util.ArrayList;
import java.util.List;

public class P1428_LeftmostColumnWithLeastOne {

	public static void main(String[] args) {
		BinaryMatrix b1 = new MyBinaryMatrix(new int[][] { { 0, 0 }, { 1, 1 } });
		System.out.println(leftMostColumnWithOne(b1));

		BinaryMatrix b2 = new MyBinaryMatrix(new int[][] { { 0, 0 }, { 0, 1 } });
		System.out.println(leftMostColumnWithOne(b2));

		BinaryMatrix b3 = new MyBinaryMatrix(new int[][] { { 0, 0 }, { 0, 0 } });
		System.out.println(leftMostColumnWithOne(b3));

		BinaryMatrix b = new MyBinaryMatrix(new int[][] { { 0, 0, 0, 1 }, { 0, 0, 1, 1 }, { 0, 1, 1, 1 } });
		System.out.println(leftMostColumnWithOne(b));
	}

	static public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
		int leftMostPost = Integer.MAX_VALUE;

		List<Integer> l = binaryMatrix.dimensions();
		int rows = l.get(0);
		int cols = l.get(1);

		for (int i = 0; i < rows; i++) {
			int left = 0;
			int right = cols - 1;

			int bestKnownLocation = -1;
			boolean oneFound = false;

			while (left <= right) {
				int mid = left + (right - left) / 2;
				if (binaryMatrix.get(i, mid) == 0) {
					// still zero, we can move forward
					left = mid + 1;
				} else {
					// this is 1 so lets move left as much as we can
					right = mid - 1;
					bestKnownLocation = mid;
					oneFound = true;
				}
			}

			if (oneFound) {
				leftMostPost = Math.min(leftMostPost, bestKnownLocation);
			}
		}

		return leftMostPost == Integer.MAX_VALUE ? -1 : leftMostPost;
	}
}

interface BinaryMatrix {
	public int get(int row, int col);

	public List<Integer> dimensions();
}

class MyBinaryMatrix implements BinaryMatrix {
	int[][] m;

	MyBinaryMatrix(int[][] m) {
		this.m = m;
	}

	@Override
	public int get(int row, int col) {
		return this.m[row][col];
	}

	@Override
	public List<Integer> dimensions() {
		List<Integer> l = new ArrayList<>();
		l.add(m.length);
		l.add(m[0].length);
		return l;
	}

}