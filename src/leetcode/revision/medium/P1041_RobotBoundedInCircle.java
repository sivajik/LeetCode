package leetcode.revision.medium;

public class P1041_RobotBoundedInCircle {

	public static void main(String[] args) {
		System.out.println(isRobotBounded("GGLLGG"));
		System.out.println(isRobotBounded("GG"));
		System.out.println(isRobotBounded("GL"));

	}

	static public boolean isRobotBounded(String instructions) {
		int x = 0;
		int y = 0;

		DIRECTIONS dir = DIRECTIONS.NORTH;

		for (char c : instructions.toCharArray()) {
			if (c == 'G') {
				switch (dir) {
				case NORTH:
					y++;
					break;
				case SOUTH:
					y--;
					break;
				case EAST:
					x++;
					break;
				case WEST:
					x--;
					break;
				}
			} else if (c == 'R') {
				switch (dir) {
				case NORTH:
					dir = DIRECTIONS.EAST;
					break;
				case SOUTH:
					dir = DIRECTIONS.WEST;
					break;
				case EAST:
					dir = DIRECTIONS.SOUTH;
					break;
				case WEST:
					dir = DIRECTIONS.NORTH;
					break;
				}
			} else if (c == 'L') {
				switch (dir) {
				case NORTH:
					dir = DIRECTIONS.WEST;
					break;
				case SOUTH:
					dir = DIRECTIONS.EAST;
					break;
				case EAST:
					dir = DIRECTIONS.NORTH;
					break;
				case WEST:
					dir = DIRECTIONS.SOUTH;
					break;
				}
			}
		}

		if (x == 0 && y == 0) {
			return true;
		}
		if (dir == DIRECTIONS.NORTH) {
			return false;
		}
		return true;
	}

	static enum DIRECTIONS {
		NORTH, SOUTH, EAST, WEST;
	}
}
