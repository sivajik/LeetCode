package leetcode.easy;

import java.util.Arrays;

public class Prob500_KeyboardRow {

	public static void main(String[] args) {
		System.out.println(
				Arrays.toString(findWords(new String[] { "Hello", "Alaska", "Dad", "Peace", "zxcv", "popop" })));
		System.out.println(
				Arrays.toString(findWords(new String[] { })));
		System.out.println(
				Arrays.toString(findWords(new String[] {"puppy" })));
		System.out.println(
				Arrays.toString(findWords(new String[] {"jodha", "aggu" })));
	}

	public static String[] findWords(String[] words) {
		java.util.Set<Character> line1 = new java.util.HashSet<>();
		java.util.Set<Character> line2 = new java.util.HashSet<>();
		java.util.Set<Character> line3 = new java.util.HashSet<>();

		line1.add('q');
		line1.add('w');
		line1.add('e');
		line1.add('r');
		line1.add('t');
		line1.add('y');
		line1.add('u');
		line1.add('i');
		line1.add('o');
		line1.add('p');

		line1.add('Q');
		line1.add('W');
		line1.add('E');
		line1.add('R');
		line1.add('T');
		line1.add('Y');
		line1.add('U');
		line1.add('I');
		line1.add('O');
		line1.add('P');

		line2.add('a');
		line2.add('s');
		line2.add('d');
		line2.add('f');
		line2.add('g');
		line2.add('h');
		line2.add('j');
		line2.add('k');
		line2.add('l');

		line2.add('A');
		line2.add('S');
		line2.add('D');
		line2.add('F');
		line2.add('G');
		line2.add('H');
		line2.add('J');
		line2.add('K');
		line2.add('L');

		line3.add('z');
		line3.add('x');
		line3.add('c');
		line3.add('v');
		line3.add('b');
		line3.add('n');
		line3.add('m');

		line3.add('Z');
		line3.add('X');
		line3.add('C');
		line3.add('V');
		line3.add('B');
		line3.add('N');
		line3.add('M');

		java.util.List<String> output = new java.util.ArrayList<>();
		for (String str : words) {
			// pig
			char[] characters = str.toCharArray();

			int line1Count = 0;
			int line2Count = 0;
			int line3Count = 0;

			for (int i = 0; i < characters.length; i++) {
				char c = characters[i];
				if (line1.contains(c)) {
					line1Count++;
				} else if (line2.contains(c)) {
					line2Count++;
				} else if (line3.contains(c)) {
					line3Count++;
				}
			}

			if (line1Count == 0 && line2Count == 0 && line3Count == characters.length) {
				output.add(str);
			} else if (line1Count == 0 && line3Count == 0 && line2Count == characters.length) {
				output.add(str);
			} else if (line2Count == 0 && line3Count == 0 && line1Count == characters.length) {
				output.add(str);
			}
		}
		String[] op = new String[output.size()];
		for (int i = 0; i < output.size(); i++) {
			op[i] = output.get(i);
		}
		return op;
	}
}
