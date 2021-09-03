package leetcode.easy;

public class Prob53_MaximumSubarray {

	public static void main(String[] args) {
		System.out.println(maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));

	}

	static public int maxSubArray(int[] a) {
		int size = a.length;
		int maxSoFar = Integer.MIN_VALUE, tempSum = 0;

		for (int i = 0; i < size; i++) {
			tempSum = tempSum + a[i];
			if (tempSum > maxSoFar)
				maxSoFar = tempSum;
			if (tempSum < 0)
				tempSum = 0;
		}
		return maxSoFar;
	}
}
