package leetcode.thirtydays.nov;

public class Day16_LongestMountainInArray {

	public static void main(String[] args) {
		System.out.println(longestMountain(new int[] { 2, 2, 2 }));
		System.out.println(longestMountain(new int[] { 2, 1, 4, 7, 3, 2, 5 }));

	}

	static public int longestMountain(int[] A) {

		int max = Integer.MIN_VALUE;

		for (int i = 1; i < A.length - 1; i++) {
			if (A[i] > A[i - 1] && A[i] > A[i + 1]) { // this is peak. then expand
				int left = i;
				int right = i;

				int leftCount = 0, rightCount = 0;

				while (left > 0 && A[left] > A[left - 1]) {
					leftCount++;
					left--;
				}
				while (right < A.length - 1 && A[right] > A[right + 1]) {
					rightCount++;
					right++;
				}
				max = Math.max(max, leftCount + rightCount + 1);
			}
		}
		return max == Integer.MIN_VALUE ? 0 : max;

	}
}
