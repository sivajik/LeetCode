package leetcode.easy;

public class Prob389_FindTheDifference {

	public static void main(String[] args) {
		System.out.println(findTheDifference("abcd", "abcde"));
		System.out.println(findTheDifference("a", "aa"));
	}

	static public char findTheDifference(String s, String t) {
		java.util.Map<Character, Integer> map = new java.util.HashMap<>();
		for (char c : t.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, 1 + map.get(c));
			} else {
				map.put(c, 1);
			}
		}
		for (char c : s.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) - 1);
			}
		}
		for (java.util.Map.Entry<Character, Integer> entries : map.entrySet()) {
			if (entries.getValue() == 1) {
				return entries.getKey();
			}
		}
		return ' ';
	}
}
