package leetcode.thirtydays.sep;

import java.util.ArrayList;
import java.util.List;

public class Day22_MajorityElement2 {

	public static void main(String[] args) {
		System.out.println(majorityElement(new int[] { 3, 2, 3 }));
		System.out.println(majorityElement(new int[] { 1, 1, 1, 3, 3, 2, 2, 2 }));
	}

	static public List<Integer> majorityElement(int[] nums) {
		int count1 = 0;
		int count2 = 0;
		int elem1 = -1;
		int elem2 = -1;

		for (int num : nums) {
			if (elem1 == num) {
				count1++;
			} else if (elem2 == num) {
				count2++;
			} else if (count1 == 0) {
				elem1 = num;
				count1++;
			} else if (count2 == 0) {
				elem2 = num;
				count2++;
			} else {
				count1--;
				count2--;
			}
		}

		int elem1Cnt = 0;
		int elem2Cnt = 0;
		for (int num : nums) {
			if (num == elem1) {
				elem1Cnt++;
			} else if (num == elem2) {
				elem2Cnt++;
			}
		}

		List<Integer> ans = new ArrayList<>();
		if (elem1Cnt > nums.length / 3) {
			ans.add(elem1);
		}
		if (elem2Cnt > nums.length / 3) {
			ans.add(elem2);
		}
		return ans;

	}
}
