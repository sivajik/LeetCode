package leetcode.easy;

import java.util.List;

public class Prob1200_MinAbsoluteDiff {

	public static void main(String[] args) {
		for (List<Integer> l : minimumAbsDifference(new int[] { 4, 2, 1, 3 })) {
			System.out.println(l);
		}
		System.out.println();

		for (List<Integer> l : minimumAbsDifference(new int[] { 1, 3, 6, 10, 15 })) {
			System.out.println(l);
		}
		System.out.println();

		for (List<Integer> l : minimumAbsDifference(new int[] { 3, 8, -10, 23, 19, -4, -14, 27 })) {
			System.out.println(l);
		}
		System.out.println();

	}

	public static List<List<Integer>> minimumAbsDifference(int[] arr) {
		java.util.Arrays.sort(arr);

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length - 1; i++) {
			int diff = Math.abs((arr[i]) - (arr[i + 1]));
			if (diff < min) {
				min = diff;
			}
		}

		System.out.println("Minimum abs diff: " + min);
		List<List<Integer>> list = new java.util.ArrayList<List<Integer>>();
		for (int i = 0; i < arr.length; i++) {
			int d = arr[i];
			if (java.util.Arrays.binarySearch(arr, d + min) > i) {
				List<Integer> temp = new java.util.ArrayList<>();
				temp.add(d);
				temp.add(d + min);
				list.add(temp);
			}
		}
		return list;
	}
}
