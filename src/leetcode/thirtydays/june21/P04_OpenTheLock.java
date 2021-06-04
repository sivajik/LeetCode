package leetcode.thirtydays.june21;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class P04_OpenTheLock {

	public static void main(String[] args) {
		System.out.println(openLock(new String[] { "0201", "0101", "0102", "1212", "2002" }, "0202"));
		System.out.println(openLock(new String[] { "8888" }, "0009"));
		System.out.println(
				openLock(new String[] { "8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888" }, "8888"));
		System.out.println(openLock(new String[] { "0000" }, "8888"));
	}

	static public int openLock(String[] deadends, String target) {
		Set<String> set = new HashSet<>();
		for (String s : deadends) {
			set.add(s);
		}
		int moves = 0;
		Queue<String> q = new LinkedList<>();
		Set<String> seen = new HashSet<>();
		seen.add("0000");

		if (!set.contains("0000")) {
			q.offer("0000");
			seen.add("0000");
		}

		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				String curr = q.poll();

				if (curr.equals(target)) {
					return moves;
				}

				for (String currMove : getPossibleMoves(curr)) {
					if (!set.contains(currMove) && !seen.contains(currMove)) {
						q.add(currMove);
						seen.add(currMove);
					}
				}
			}
			moves++;
		}
		return -1;
	}

	private static List<String> getPossibleMoves(String curr) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			int currVal = ((int) curr.charAt(i)) - (int) '0';

			int forwardSpin = currVal + 1 > 9 ? 0 : currVal + 1;
			int reverseSpin = currVal - 1 < 0 ? 9 : currVal - 1;

			StringBuilder sbrForward = new StringBuilder(curr);
			sbrForward.setCharAt(i, (char) (forwardSpin + (int) '0'));

			StringBuilder sbrReverse = new StringBuilder(curr);
			sbrReverse.setCharAt(i, (char) (reverseSpin + (int) '0'));

			list.add(sbrForward.toString());
			list.add(sbrReverse.toString());
		}
		return list;
	}
}
