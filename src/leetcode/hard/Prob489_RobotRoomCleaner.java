package leetcode.hard;

import java.util.HashSet;
import java.util.Set;

public class Prob489_RobotRoomCleaner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}

interface Robot {
	// Returns true if the cell in front is open and robot moves into the cell.
	// Returns false if the cell in front is blocked and robot stays in the current
	// cell.
	public boolean move();

	// Robot will stay in the same cell after calling turnLeft/turnRight.
	// Each turn will be 90 degrees.
	public void turnLeft();

	public void turnRight();

	// Clean the current cell.
	public void clean();
}

class Solution {

	int[][] diretion = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	Set<Pair> visited = new HashSet();
	Robot robot;

	public void cleanRoom(Robot robot) {
		this.robot = robot;
		backtrack(0, 0, 0);
	}

	private void backtrack(int row, int col, int d) {
		visited.add(new Pair(row, col));
		robot.clean();

		for (int i = 0; i < 4; i++) {
			int newD = (d + i) % 4;
			int newRow = row + diretion[newD][0];
			int newcol = col + diretion[newD][1];

			if (!visited.contains(new Pair(newRow, newcol)) && robot.move()) {
				backtrack(newRow, newcol, newD);
				goback();
			}
			robot.turnRight();
		}
	}

	public void goback() {
		robot.turnRight();
		robot.turnRight();
		robot.move();
		robot.turnRight();
		robot.turnRight();
	}

}

class Pair {
	int r;
	int c;

	Pair(int a, int b) {
		this.r = a;
		this.c = b;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + c;
		result = prime * result + r;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		if (c != other.c)
			return false;
		if (r != other.r)
			return false;
		return true;
	}

}
