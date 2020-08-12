package leetcode.thirtydays.august;

import java.util.Arrays;

public class Day11_HIndex {

	public static void main(String[] args) {
		System.out.println(hIndex(new int[] { 3, 0, 6, 1, 5 }));
	}

	static public int hIndex(int[] citations) {
		Arrays.sort(citations);
		int l = 0, h = citations.length - 1;
		while (l <= h) { // 0 1 3 5 6
			int mid = l + (h - l) / 2;
			if (citations[mid] < citations.length - mid) {
				l = mid + 1;
			} else {
				h = mid - 1;
			}
		}
		return citations.length - l;
	}
}
