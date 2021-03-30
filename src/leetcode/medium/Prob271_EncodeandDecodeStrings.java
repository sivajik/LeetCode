package leetcode.medium;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Prob271_EncodeandDecodeStrings {

	public static void main(String[] args) {
		List<String> s = new ArrayList<>();
		s.add("one");
		s.add("two");
		s.add("three");
		s.add("four");

		Codec c = new Codec();
		// System.out.println(c.decode(c.encode(s)));
		// System.out.println(Character.toString((char) 258));
		for(String s1 : "abcd:foo:bar:jock:jockey".split(":", -1)) {
			System.out.println(s1);
		}

	}

	static class Codec {
		public String encode(List<String> strs) {
			if (strs.size() == 0) {
				return Character.toString((char) 258);
			}

			String delim = Character.toString((char) 257);
			StringBuilder sb = new StringBuilder();
			for (String s : strs) {
				sb.append(s);
				sb.append(delim);
			}
			sb.deleteCharAt(sb.length() - 1);
			return sb.toString();
		}

		// Decodes a single string to a list of strings.
		public List<String> decode(String s) {
			String d = Character.toString((char) 258);
			if (s.equals(d)) {
				return new ArrayList();
			}

			d = Character.toString((char) 257);
			return Arrays.asList(s.split(d, -1));
		}
	}
}
