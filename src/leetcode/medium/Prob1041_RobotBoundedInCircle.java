package leetcode.medium;

public class Prob1041_RobotBoundedInCircle {

	public static void main(String[] args) {
		System.out.println(isRobotBounded("GGLLGG"));
		System.out.println(isRobotBounded("GG"));
		System.out.println(isRobotBounded("GL"));		
	}

	static public boolean isRobotBounded(String instructions) {
		if (instructions == null || instructions.length() == 0) {
			return false;
		}

		int x = 0;
		int y = 0;

		String east = "east";
		String west = "west";
		String south = "south";
		String north = "north";

		String dir = north;
		
		for (char c : instructions.toCharArray()) {
			if (c == 'G') {
				if (dir.equals(north)) {
					y++;
				} else if (dir.equals(south)) {
					y--;
				} else if (dir.equals(east)) {
					x++;
				} else if (dir.equals(west)) {
					x--;
				}
			} else if (c == 'L') {
				if (dir.equals(north)) {
					dir = west;
				} else if (dir.equals(west)) {
					dir = south;
				} else if (dir.equals(south)) {
					dir = east;
				} else {
					dir = north;
				}
			} else if (c == 'R') {
				if (dir.equals(north)) {
					dir = east;
				} else if (dir.equals(east)) {
					dir = south;
				} else if (dir.equals(south)) {
					dir = west;
				} else {
					dir = north;
				}
			}
		}
		if (x == 0 && y == 0)
			return true;
		if (dir.equals(north))
			return false;
		return true;
	}

}
