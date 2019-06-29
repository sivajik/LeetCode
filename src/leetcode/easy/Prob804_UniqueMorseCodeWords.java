package leetcode.easy;

import java.util.HashMap;

public class Prob804_UniqueMorseCodeWords {

	public static void main(String[] args) {
		System.out.println(uniqueMorseRepresentations(new String[] {"gin", "zen", "gig", "msg"}));
		System.out.println(uniqueMorseRepresentations(new String[] {}));
		System.out.println(uniqueMorseRepresentations(new String[] {"gin", "gin", "gin", "msg"}));

	}

	public static int uniqueMorseRepresentations(String[] words) {
		String[] morseCodes = new String[] { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
				"-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
				"-.--", "--.." };

		HashMap<Character, String> morseCodesMap = new HashMap<>();
		for (int i = 0; i < 26; i++) {
			morseCodesMap.put((char) (i + 97), morseCodes[i]);
		}

		HashMap<String, Integer> results = new HashMap<>();
		for (String word : words) {
			StringBuilder bldr = new StringBuilder();
			for (char c : word.toCharArray()) {
				bldr.append(morseCodesMap.get(c));
			}
			results.put(bldr.toString(), 1);
		}
		return results.size();
	}
}
