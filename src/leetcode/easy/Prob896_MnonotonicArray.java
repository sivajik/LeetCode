package leetcode.easy;

public class Prob896_MnonotonicArray {

	public static void main(String[] args) {
		System.out.println(isMonotonic(new int[] { 1, 2, 2, 3 }) == true);
		System.out.println(isMonotonic(new int[] { 6, 5, 4, 4 }) == true);
		System.out.println(isMonotonic(new int[] { 1, 3, 2 }) == false);
		System.out.println(isMonotonic(new int[] { 1, 2, 4, 5 }) == true);
		System.out.println(isMonotonic(new int[] { 1, 1, 1 }) == true);
	}

	static public boolean isMonotonic(int[] A) {
		boolean inc = true;
		boolean dec = true;

		for (int i = 0; i < A.length - 1; i++) {
			if (A[i] < A[i + 1]) {
				dec = false;
			} else if (A[i] > A[i + 1]) {
				inc = false;
			} else {

			}
		}
		return inc || dec;
	}
}
