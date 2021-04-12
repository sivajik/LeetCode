package leetcode.medium;

public class Prob351_AndroidUnlockPatterns {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class Solution {

		int res = 0;
		int m;
		int n;

		int[][] directions = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { -1, 1 }, { 1, -1 },
				{ -1, -1 }, { -2, 1 }, { -2, -1 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 }, { 1, 2 }, { -1, 2 } };
		int[][] crossdirec = new int[][] { { 0, 2 }, { 0, -2 }, { 2, 0 }, { -2, 0 }, { -2, -2 }, { 2, 2 }, { 2, -2 },
				{ -2, 2 } };

		boolean[][] visited = new boolean[3][3];

		public int numberOfPatterns(int m, int n) {
			this.m = m;
			this.n = n;

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					dfs(1, i, j, visited);
				}
			}
			return res;
		}

		private void dfs(int count, int i, int j, boolean[][] visited) {
			if (count >= m && count <= n) {
				res++;
			}
			if (count == n) {
				return;
			}

			visited[i][j] = true;
			for (int[] eachdir : directions) {
				int newX = i + eachdir[0];
				int newY = j + eachdir[1];

				if (!isValid(newX, newY)) {
					continue;
				}
				dfs(count + 1, newX, newY, visited);
			}

			for (int[] eachdir : crossdirec) {
				int newX = i + eachdir[0];
				int newY = j + eachdir[1];

				if (!isValid(newX, newY)) {
					continue;
				}

				int midX = i + eachdir[0] / 2;
				int midY = j + eachdir[1] / 2;
				if (visited[midX][midY]) {
					// passing through some visisted spot.
					dfs(count + 1, newX, newY, visited);
				}
			}

			visited[i][j] = false;
		}

		private boolean isValid(int i, int j) {
			if (i >= 0 && i <= 2 && j >= 0 && j <= 2 && visited[i][j] == false) {
				return true;
			}
			return false;
		}
	
}
}
