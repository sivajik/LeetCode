package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob1048_LongestStringChain {

	public static void main(String[] args) {
		System.out.println(longestStrChain(new String[] { "a", "b", "ba", "bca", "bda", "bdca" }));
		System.out.println(longestStrChain(new String[] { "xbc", "pcxbcf", "xb", "cxbc", "pcxbc" }));
		System.out.println(longestStrChain(new String[] { "a", "b", "ab", "bac" }));
	}

	static public int longestStrChain(String[] words) {
		if (words == null || words.length == 0) {
			return 0;
		}

		Map<Integer, List<String>> map = new HashMap<>();
		Map<String, Integer> records = new HashMap<>();

		for (String word : words) {
			if (map.get(word.length()) == null) {
				map.put(word.length(), new ArrayList<>());
			}
			map.get(word.length()).add(word);
			records.put(word, 1);
		}
		int max = 1;
		for (int key : map.keySet()) {
			if (!map.containsKey(key - 1)) {
				continue;
			}
			List<String> currList = map.get(key);
			List<String> preList = map.get(key - 1);

			for (String word : currList) {
				for (String preWord : preList) {
					if (oneDiff(word, preWord)) {
						records.put(word, Math.max(records.get(word), records.get(preWord) + 1));
						max = Math.max(max, records.get(word));
					}
				}
			}
		}

		return max;
	}

	private static boolean oneDiff(String w1, String w2) {
		int index1 = 0, index2 = 0;
		boolean flag = false;
		while (index1 < w1.length() && index2 < w2.length()) {
			if (w1.charAt(index1) == w2.charAt(index2)) {
				index1++;
				index2++;
			} else if (flag) {
				return false;
			} else {
				index1++;
				flag = true;
			}
		}
		return true;
	}
}
