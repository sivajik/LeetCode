package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prob1079_LetterTilePossibilities {

	public static void main(String[] args) {
		System.out.println(numTilePossibilities("AAB"));
		System.out.println(numTilePossibilities("AAABBC"));
	}

	static int count = 0;

	static public int numTilePossibilities(String tiles) {
		if (tiles == null || tiles.length() == 0) {
			return 0;
		}

		count = 0;

		char[] tokens = tiles.toCharArray();
		Arrays.sort(tokens);
		int[] bits = new int[tokens.length];

		solve(tokens, bits);
		return count;
	}

	private static void solve(char[] tokens, int[] bits) {
		for (int i = 0; i < tokens.length; i++) {
			if (bits[i] == 1) {
				continue;
			}

			bits[i] = 1;
			count++;
			solve(tokens, bits);
			bits[i] = 0;

			while (i + 1 < tokens.length && tokens[i] == tokens[i + 1]) {
				i++;
			}

		}
	}

	private static void solve1(char[] tokens, int[] bits, int startAt) {
		if (startAt == tokens.length) {
			List<Character> list = new ArrayList<>();
			for (int i = 0; i < bits.length; i++) {
				if (bits[i] == 1) {
					list.add(tokens[i]);
				}
			}
			System.out.println(list);
			return;
		}

		bits[startAt] = 0;
		count++;
		solve1(tokens, bits, startAt + 1);

		bits[startAt] = 1;
		count++;
		solve1(tokens, bits, startAt + 1);

		// TODO Auto-generated method stub

	}
}
