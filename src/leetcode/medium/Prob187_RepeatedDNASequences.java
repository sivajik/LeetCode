package leetcode.medium;

import java.util.*;

public class Prob187_RepeatedDNASequences {

	public static void main(String[] args) {
		System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
		System.out.println(findRepeatedDnaSequences("AAAAAAAAAAAAA"));
	}

	static public List<String> findRepeatedDnaSequences(String s) {
		Map<String, Integer> map = new HashMap<String, Integer>();

		char[] c = s.toCharArray();
		for (int i = 0; i < c.length; i++) {
			StringBuilder sbr = new StringBuilder();
			for (int j = i; j <= i + 9 && j < c.length; j++) {
				sbr.append(c[j]);
			}
			String ss = sbr.toString();
			if (map.containsKey(ss) && ss.length() == 10) {
				map.put(ss, 1 + map.get(ss));
			} else {
				map.put(ss, 1);
			}
		}

		List<String> l = new ArrayList<>();
		for (Map.Entry<String, Integer> pair : map.entrySet()) {
			if (pair.getValue() > 1) {
				l.add(pair.getKey());
			}
		}
		return l;
	}
}
