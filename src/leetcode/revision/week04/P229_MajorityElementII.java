package leetcode.revision.week04;

import java.util.ArrayList;
import java.util.List;

public class P229_MajorityElementII {

	public static void main(String[] args) {
		System.out.println(majorityElement(new int[] { 3, 2, 3 }));

	}

	static public List<Integer> majorityElement(int[] nums) {
		int e1 = -1;
		int e2 = -1;
		int c1 = 0;
		int c2 = 0;
		for (int n : nums) {
			if (n == e1) {
				c1++;
			} else if (n == e2) {
				c2++;
			} else if (c1 == 0) {
				e1 = n;
				c1++;
			} else if (c2 == 0) {
				e2 = n;
				c2++;
			} else {
				c1--;
				c2--;
			}
		}
		int e1C = 0;
		int e2C = 0;

		for (int n : nums) {
			if (n == e1) {
				e1C++;
			} else if (n == e2) {
				e2C++;
			}
		}

		List<Integer> ans = new ArrayList<>();
		if (e1C > nums.length / 3) {
			ans.add(e1);
		}
		if (e2C > nums.length / 3) {
			ans.add(e2);
		}
		return ans;
	}
}
