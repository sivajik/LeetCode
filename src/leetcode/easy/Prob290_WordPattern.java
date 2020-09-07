package leetcode.easy;

public class Prob290_WordPattern {

	public static void main(String[] args) {
		System.out.println(wordPattern("abba", "dog cat cat dog"));
	}
	static public boolean wordPattern(String pattern, String str) {
       	String[] words = str.split(" ");

		if (pattern.length() != words.length) {
			return false;
		}

		java.util.Map<Character, String> map = new java.util.HashMap<>();
		java.util.Set<String> set = new java.util.HashSet<>();

		for (int i = 0; i < words.length; i++) {
			char eachCharacter = pattern.charAt(i);
			String word = words[i];

			if (map.containsKey(eachCharacter)) {
				if (!map.get(eachCharacter).equals(word)) {
					return false;
				}
			} else {
				if (set.contains(word)) {
					return false;
				} else {
					map.put(eachCharacter, word);
					set.add(word);
				}
			}
		}
		return true; 
    }
}
