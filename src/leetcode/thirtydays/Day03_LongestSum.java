package leetcode.thirtydays;

public class Day03_LongestSum {

	public static void main(String[] args) {
		System.out.println(maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));

	}

	public static int maxSubArray(int[] a) {
		int size = a.length;
		int max_so_far = Integer.MIN_VALUE, tempSum = 0;

		for (int i = 0; i < size; i++) {
			tempSum = tempSum + a[i];
			if (max_so_far < tempSum)
				max_so_far = tempSum;
			if (tempSum < 0)
				tempSum = 0;
		}
		return max_so_far;
	}
}
