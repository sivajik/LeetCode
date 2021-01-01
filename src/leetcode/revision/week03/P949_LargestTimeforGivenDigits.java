package leetcode.revision.week03;

public class P949_LargestTimeforGivenDigits {

	public static void main(String[] args) {
		System.out.println(largestTimeFromDigits(new int[] { 1, 2, 3, 4 }));
		System.out.println(largestTimeFromDigits(new int[] { 5, 5, 5, 5 }));
		System.out.println(largestTimeFromDigits(new int[] { 0, 0, 0, 0 }));
		System.out.println(largestTimeFromDigits(new int[] { 0, 0, 1, 0 }));
	}

	static int maxTime = Integer.MIN_VALUE;
	static String hm = "";

	static public String largestTimeFromDigits(int[] arr) {
		maxTime = Integer.MIN_VALUE;
		hm = "";
		helper(arr, 0);
		return hm;
	}

	private static void helper(int[] arr, int currIndex) {
		if (currIndex == arr.length) {
			if (calcTime(arr) > maxTime) {
				maxTime = Math.max(maxTime, calcTime(arr));
				hm = getTime(arr);
				return;
			}
		}

		for (int i = currIndex; i < arr.length; i++) {
			swap(arr, i, currIndex);
			helper(arr, currIndex + 1);
			swap(arr, i, currIndex);
		}

	}

	private static void swap(int[] arr, int i, int currIndex) {
		int temp = arr[i];
		arr[i] = arr[currIndex];
		arr[currIndex] = temp;
	}

	private static String getTime(int[] arr) {
		return "" + arr[0] + arr[1] + ":" + arr[2] + arr[3];
	}

	private static int calcTime(int[] arr) {
		int hrs = arr[0] * 10 + arr[1];
		int mns = arr[2] * 10 + arr[3];
		if (hrs >= 0 && hrs <= 23 && mns >= 0 && mns <= 59) {
			return hrs * 60 + mns;
		} else {
			return Integer.MIN_VALUE;
		}
	}
}
