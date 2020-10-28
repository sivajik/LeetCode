package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class Prob228_SummaryRanges {

	public static void main(String[] args) {
		for (String s : summaryRanges(new int[] { 0, 1, 2, 4, 5, 7 })) {
			System.out.println(s);
		}
	}

	static public List<String> summaryRanges(int[] nums) {

		List<String> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}

		for (int i = 0; i < nums.length; i++) {
			boolean found = false;
			int start = nums[i];
			int end = nums[i];
			while (i + 1 < nums.length && nums[i + 1] - nums[i] == 1) {
				end = nums[i + 1];
				i++;
				found = true;
			}
			String str = "";
			if (found) {
				str = start + "->" + end;
			} else {
				str = start + "";
			}
			res.add(str);
		}
		return res;

	}
}
