package leetcode.easy;

import java.util.Arrays;

public class Prob1356_SortByBits {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(sortByBits(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8 })));
		System.out.println(Arrays.toString(sortByBits(new int[] { 1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1 })));
		System.out.println(Arrays.toString(sortByBits(new int[] { 10000, 10000 })));
		System.out.println(Arrays.toString(sortByBits(new int[] { 2, 3, 5, 7, 11, 13, 17, 19 })));
		System.out.println(Arrays.toString(sortByBits(new int[] { 10, 100, 1000, 10000 })));
	}

	public static int[] sortByBits(int[] arr) {
		int[] res = java.util.Arrays.stream(arr).boxed().sorted(new java.util.Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (Integer.bitCount(o1) == Integer.bitCount(o2)) {
					return o1 - o2;
				} else {
					return Integer.bitCount(o1) - Integer.bitCount(o2);
				}
			}
		}).mapToInt(x -> x.intValue()).toArray();
		return res;
	}
}
