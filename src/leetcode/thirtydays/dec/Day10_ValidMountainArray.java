package leetcode.thirtydays.dec;

public class Day10_ValidMountainArray {

	public static void main(String[] args) {
		System.out.println(validMountainArray(new int[] { 2, 1 }));
		System.out.println(validMountainArray(new int[] { 3, 5, 5 }));
		System.out.println(validMountainArray(new int[] { 0, 3, 2, 1 }));
		System.out.println(validMountainArray(new int[] { 1,3,2 }));
	}

	static public boolean validMountainArray(int[] arr) {
		if (arr == null || arr.length == 0 || arr.length < 3) {
			return false;
		}

		int low = 0;
		int high = arr.length - 1;

		while (low < arr.length - 1 && arr[low] < arr[low + 1]) {
			low = low + 1;
		}

		while (high > 0 && arr[high] < arr[high - 1]) {
			high = high - 1;
		}

		return low == high && low != 0 && high != arr.length - 1;
	}
}
