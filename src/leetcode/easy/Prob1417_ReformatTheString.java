package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class Prob1417_ReformatTheString {

	public static void main(String[] args) {
		System.out.println(reformat("a0b1c2"));
		System.out.println(reformat("leetcode"));
		System.out.println(reformat("1229857369"));
		System.out.println(reformat("covid2019"));
		System.out.println(reformat("ab123"));
	}

	static public String reformat(String s) {
		List<Character> digits = new ArrayList<>();
		List<Character> letters = new ArrayList<>();

		for (char c : s.toCharArray()) {
			if (Character.isDigit(c)) {
				digits.add(c);
			} else {
				letters.add(c);
			}
		}

		if (Math.abs(digits.size() - letters.size()) <= 1) {
			StringBuilder sdlbr = new StringBuilder();
			int i = 0;
			if (digits.size() > letters.size()) { // 1 2 3 4 a b c 1a2b3c4
				for (; i < letters.size(); i++) {
					sdlbr.append(digits.get(i)).append(letters.get(i));
				}
				sdlbr.append(digits.get(i));
			} else if (digits.size() < letters.size()) { // a b c d 2 9 8 a2b9c8d
				for (; i < digits.size(); i++) {
					sdlbr.append(letters.get(i)).append(digits.get(i));
				}
				sdlbr.append(letters.get(i));
			} else {
				for (; i < letters.size(); i++) {
					sdlbr.append(letters.get(i)).append(digits.get(i));
				}
			}
			return sdlbr.toString();
		} else {
			return "";
		}
	}
}
