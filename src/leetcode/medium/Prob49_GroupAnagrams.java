package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob49_GroupAnagrams {

	public static void main(String[] args) {
		System.out.println(groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));

	}

	public static List<List<String>> groupAnagrams(String[] strs) {

		Map<String, ArrayList<String>> map = new HashMap();

		for (String str : strs) {
			char[] sortedStr = str.toCharArray();
			Arrays.sort(sortedStr);
			String sortedString = new String(sortedStr);

			if (map.containsKey(sortedString)) {
				ArrayList<String> l = map.get(sortedString);
				l.add(str);
				map.put(sortedString, l);
			} else {
				ArrayList<String> l = new ArrayList<String>();
				l.add(str);
				map.put(sortedString, l);
			}
		}
		java.util.Collection<ArrayList<String>> coll = map.values();
		return new ArrayList<>(coll);

	}
}
