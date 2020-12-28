package leetcode.revision.week03;

import java.util.ArrayDeque;
import java.util.*;

public class P279_PerfectSquares {

	public static void main(String[] args) {
		//System.out.println(numSquares(12));
		//System.out.println(numSquares(13));
		System.out.println(numSquares(43));
	}

	static public int numSquares(int n) {
		List<Integer> squares = new ArrayList<>();
		for (int i = 1; i * i <= n; i++) {
			squares.add(i * i);
		}

		Queue<Integer> q = new ArrayDeque<>();
		q.add(n);

		int levels = 0;

		while (!q.isEmpty()) {
			levels++;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int number = q.poll();

				if (squares.contains(number)) {
					return levels;
				}

				for (int eachSquare : squares) {
					if (eachSquare < number) {
						q.add(number - eachSquare);
					} else {
						break;
					}
				}
			}
		}
		return levels;
	}
}
