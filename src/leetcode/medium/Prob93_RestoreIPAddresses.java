package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Prob93_RestoreIPAddresses {

	public static void main(String[] args) {
		System.out.println(restoreIpAddresses("25525511135"));

	}

	static public List<String> restoreIpAddresses(String s) {
		List<String> list = new ArrayList<>();
		helper(list, new StringBuilder(), s, 0, 0);
		return list;
	}

	private static void helper(List<String> list, StringBuilder temp, String s, int start, int count) {
		if (start == s.length() && count == 4) {
			// we are at the end + added all 4 components of ip address
			list.add(temp.toString());
		} else if (count == 4) {
			// we are not at end but done 4 elements..
			return;
		}

		for (int i = start; i < s.length(); i++) {
			String curr = s.substring(start, i + 1);
			int value = Integer.parseInt(curr);

			if (curr.length() > 1 && curr.charAt(0) == '0') {
				return;
			}

			if (value > 255) {
				return;
			}
			if (value >= 0 && value <= 255) {
				StringBuilder rollback = new StringBuilder(temp);
				temp.append(curr);
				if (count < 3) {
					temp.append(".");
				}
				helper(list, temp, s, i + 1, count + 1);
				temp = rollback;
			}
		}
	}
}
