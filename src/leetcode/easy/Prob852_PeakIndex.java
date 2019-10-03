package leetcode.easy;

public class Prob852_PeakIndex {

	public static void main(String[] args) {
		System.out.println(peakIndexInMountainArray(new int[] { 0, 1, 0 }));
		System.out.println(peakIndexInMountainArray(new int[] { 0, 2, 1, 0 }));
	}

	public static int peakIndexInMountainArray(int[] A) {
		int max = Integer.MIN_VALUE;
		int index = -1;
		for (int i = 0; i < A.length; i++) {
			if (A[i] > max) {
				max = A[i];
				index = i;
			}
		}
		return index;
	}
}
