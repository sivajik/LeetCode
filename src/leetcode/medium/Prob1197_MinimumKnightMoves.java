package leetcode.medium;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Prob1197_MinimumKnightMoves {

	public static void main(String[] args) {
		System.out.println(minKnightMoves(2, 1));
		System.out.println(minKnightMoves(5, 5));
		System.out.println(minKnightMoves(2, 112));
	}

	static public int minKnightMoves(int x, int y) {
		if (x == 0 && y == 0) {
			return 0;
		}

		// Set<Location> visited = new HashSet<>();
		Set<Integer> visited = new HashSet<>();

		int[][] moves = new int[][] { { -1, -2 }, { -2, -1 }, { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 },
				{ 1, -2 } };

		Queue<Location> queue = new ArrayDeque<>();
		Location origin = new Location(0, 0);

		visited.add(origin.x * 1000 + origin.y);
		queue.add(origin);
		int moveCnt = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {

				Location temp = queue.poll();

				if (temp.x == x && temp.y == y) {
					return moveCnt;
				}

				for (int[] eachMove : moves) {
					int newX = temp.x + eachMove[0];
					int newY = temp.y + eachMove[1];
					Location newLoc = new Location(newX, newY);
					mark(newLoc, queue, visited);
				}
			}
			moveCnt++;
		}
		return -1;
	}

	private static void mark(Location newLoc, Queue<Location> queue, Set<Integer> visited) {
		int newX = newLoc.x;
		int newY = newLoc.y;

		if (Math.abs(newX) + Math.abs(newY) > 300) {
			return;
		}

		// important to limit to 300 board or else it never ends..
		if (!visited.contains(newX * 1000 + newY)) {
			queue.add(newLoc);
			visited.add(newX * 1000 + newY); // don't forget or else it never ends
		}

	}

	static class Location {
		int x;
		int y;

		Location(int a, int b) {
			this.x = a;
			this.y = b;
		}

		/*
		 * @Override public int hashCode() { final int prime = 31; int result = 1;
		 * result = prime * result + x; result = prime * result + y; return result; }
		 * 
		 * @Override public boolean equals(Object obj) { if (this == obj) return true;
		 * if (obj == null) return false; if (getClass() != obj.getClass()) return
		 * false; Location other = (Location) obj; if (x != other.x) return false; if (y
		 * != other.y) return false; return true; }
		 */
	}
}
