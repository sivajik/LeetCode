package leetcode.g5.easy;

import java.util.HashSet;
import java.util.Set;

public class Prob929_UniqueEmailAddresses {

	public static void main(String[] args) {
		System.out.println(numUniqueEmails(new String[] { "test.email+alex@leetcode.com",
				"test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com" }));
		System.out.println(numUniqueEmails(new String[] { "a@leetcode.com", "b@leetcode.com", "c@leetcode.com" }));

	}

	static public int numUniqueEmails(String[] emails) {
		Set<String> set = new HashSet<>();
		for (String email : emails) {
			int index = email.indexOf('@');
			char[] local = email.toCharArray();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < index; i++) {
				if (local[i] == '.') {
					continue;
				} else if (local[i] == '+') {
					break;
				} else {
					sb.append(local[i]);
				}
			}
			String finalEmail = sb.toString() + '@' + email.substring(index) + 1;
			System.out.println(email + " => " + finalEmail);
			set.add(finalEmail);
		}
		return set.size();
	}
}
