package leetcode.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob791_CustomSortString {

	public static void main(String[] args) {
		System.out.println(customSortString("cba", "abcd"));
		System.out.println(customSortString("exv", "xwvee"));
	}

	static public String customSortString(String order, String str) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < order.length(); i++) {
			map.put(order.charAt(i), i);
		}
		Comparator<Character> cmp = new Comparator<Character>() {

			@Override
			public int compare(Character o1, Character o2) {
				if (map.get(o1) != null && map.get(o2) != null) {
					return map.get(o1) - map.get(o2);
				} else { // if (map.get(o1) != null && map.get(o2) == null) {
					return 999;
				}
			}
		};

		List<Character> list = new ArrayList<Character>();
		List<Character> otherList = new ArrayList<Character>();
		for (char c : str.toCharArray()) {
			if (map.containsKey(c)) {
				list.add(c);
			} else {
				otherList.add(c);
			}
		}

		list.sort(cmp);
		list.addAll(otherList);

		StringBuffer sbf = new StringBuffer();
		for (char c : list) {
			sbf.append(c);
		}
		return sbf.toString();
	}
}
