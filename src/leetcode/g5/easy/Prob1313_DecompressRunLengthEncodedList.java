package leetcode.g5.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prob1313_DecompressRunLengthEncodedList {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(decompressRLElist(new int[] { 1, 2, 3, 4 })));
		System.out.println(Arrays.toString(decompressRLElist(new int[] { 1, 1, 2, 3 })));
	}

	static public int[] decompressRLElist(int[] nums) {
		List<Integer> l = new ArrayList<>();
		for (int i = 0; i < nums.length; i += 2) {
			int freq = nums[i];
			int val = nums[i + 1];

			for (int j = 0; j < freq; j++) {
				l.add(val);
			}
		}

		int[] op = new int[l.size()];
		int c = 0;
		for (int i : l) {
			op[c++] = i;
		}
		return op;
	}
}
