package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prob1313_DecompressList {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(decompressRLElist(new int[] { 1, 2 })));
		System.out.println(Arrays.toString(decompressRLElist(new int[] { 1, 2, 3, 4 })));
		System.out.println(Arrays.toString(decompressRLElist(new int[] { 1, 2, 8, 9 })));
	}

	public static int[] decompressRLElist(int[] nums) {
		List<int[]> list = new ArrayList<int[]>();
		for (int i = 0; i < nums.length; i = i + 2) {
			int times = nums[i];
			int number = nums[i + 1];

			int[] temp = new int[times];
			Arrays.fill(temp, number);
			list.add(temp);
		}

		return list.stream().flatMapToInt(x -> Arrays.stream(x)).toArray();
	}
}
