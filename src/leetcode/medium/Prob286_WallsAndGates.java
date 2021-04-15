package leetcode.medium;

public class Prob286_WallsAndGates {

	public static void main(String[] args) {

	}

	static public void wallsAndGates(int[][] rooms) {
		int m = rooms.length;
		int n = rooms[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (rooms[i][j] == 0) {
					// a gate. then set distance to nearest cells.
					// readon for running dfs here itself is, gate cant be touched. only adjacent to
					// gates are touched. we never know around gate which cell is a empty one so
					// do all 4 directions.
					dfs(rooms, i + 1, j, 1);
					dfs(rooms, i - 1, j, 1);
					dfs(rooms, i, j + 1, 1);
					dfs(rooms, i, j - 1, 1);
				}
			}
		}
	}

	private static void dfs(int[][] rooms, int i, int j, int distance) {
		if (i < 0 || j < 0 || i >= rooms.length || j >= rooms[i].length || rooms[i][j] < distance) {
			return;
			// either a worst cell or cell got a better distance.
		}
		rooms[i][j] = distance;
		dfs(rooms, i + 1, j, distance + 1);
		dfs(rooms, i - 1, j, distance + 1);
		dfs(rooms, i, j + 1, distance + 1);
		dfs(rooms, i, j - 1, distance + 1);
	}
}
