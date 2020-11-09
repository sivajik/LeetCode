package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prob1630_ArithmeticSubarrays {

	public static void main(String[] args) {
		System.out.println(
				checkArithmeticSubarrays(new int[] { 4, 6, 5, 9, 3, 7 }, new int[] { 0, 0, 2 }, new int[] { 2, 3, 5 }));
		System.out.println();
		System.out.println(checkArithmeticSubarrays(new int[] { -12, -9, -3, -12, -6, 15, 20, -25, -20, -15, -10 },
				new int[] { 0, 1, 6, 4, 8, 7 }, new int[] { 4, 4, 9, 7, 9, 10 }));

	}

	static public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
		List<Boolean> res = new ArrayList<>();
		for (int i = 0; i < l.length; i++) {
			int left = l[i];
			int right = r[i];

			if (right - left >= 1) {
				List<Integer> tmp = new ArrayList<>();
				for (int j = left; j <= right; j++) {
					tmp.add(nums[j]);
				}
				res.add(helper(tmp));
			}
		}

		return res;
	}

	static public boolean helper(List<Integer> tmp) {
		System.out.println(tmp);
		Collections.sort(tmp);
		int diff = tmp.get(1) - tmp.get(0);
		for (int k = 1; k < tmp.size(); k++) {
			if (tmp.get(k) - tmp.get(k - 1) != diff) {
				return false;
			}
		}
		return true;
	}
}
