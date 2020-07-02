package leetcode.hard;

public class Prob329_LongestIncreasingPathInAMatrix {

	public static void main(String[] args) {
		System.out.println(longestIncreasingPath(new int[][] { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } }));
		System.out.println(longestIncreasingPath(new int[][] { { 3,4,5 }, { 3,2,6 }, { 2,2,1 } }));
		System.out.println(longestIncreasingPath(new int[][] {{0,1,2,3,4,5,6,7,8,9},{19,18,17,16,15,14,13,12,11,10},{20,21,22,23,24,25,26,27,28,29},{39,38,37,36,35,34,33,32,31,30},{40,41,42,43,44,45,46,47,48,49},{59,58,57,56,55,54,53,52,51,50},{60,61,62,63,64,65,66,67,68,69},{79,78,77,76,75,74,73,72,71,70},{80,81,82,83,84,85,86,87,88,89},{99,98,97,96,95,94,93,92,91,90},{100,101,102,103,104,105,106,107,108,109},{119,118,117,116,115,114,113,112,111,110},{120,121,122,123,124,125,126,127,128,129},{139,138,137,136,135,134,133,132,131,130},{0,0,0,0,0,0,0,0,0,0}} ));
	
	}

	static int max = Integer.MIN_VALUE;;
	
	static public int longestIncreasingPath(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}

		int rows = matrix.length;
		int cols = matrix[0].length;

		int[][] dp = new int[rows][cols];
		max = Integer.MIN_VALUE;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				getLongestPathFrom(matrix, dp, i, j);
			}
		}

		return max;
	}

	private static int getLongestPathFrom(int[][] matrix, int[][] dp, int i, int j) {
	    if(dp[i][j] != 0)
	        return dp[i][j];
	    
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };

		int res = 0;
		for (int t = 0; t < 4; t++) {
			int x = i + dx[t];
			int y = j + dy[t];

			if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] <= matrix[i][j])
				continue;
			res = Math.max(res, getLongestPathFrom(matrix, dp, x, y));
		}
		dp[i][j] = 1 + res;
		max = Math.max(dp[i][j], max);
		return dp[i][j];
	}
}
