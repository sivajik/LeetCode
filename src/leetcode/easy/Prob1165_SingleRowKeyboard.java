package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class Prob1165_SingleRowKeyboard {

	public static void main(String[] args) {
		System.out.println(calculateTime("abcdefghijklmnopqrstuvwxyz", "cba"));
		System.out.println(calculateTime("pqrstuvwxyzabcdefghijklmno", "leetcode"));
	}

	static public int calculateTime(String keyboard, String word) {
		Map<Character, Integer> map = new HashMap<>();
		int j = 0;
		for (char c : keyboard.toCharArray()) {
			map.put(c, j++);
		}

		char curr = word.charAt(0);
		int sum = map.get(curr);
		for (int i = 1; i < word.length(); i++) {
			char next = word.charAt(i);
			sum += Math.abs(map.get(next) - map.get(curr));
			curr = next;
		}
		return sum;
	}
}
