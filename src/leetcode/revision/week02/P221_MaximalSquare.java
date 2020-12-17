package leetcode.revision.week02;

public class P221_MaximalSquare {

	public static void main(String[] args) {
		System.out.println(maximalSquare(new char[][] {
			{'1','0','1','0','0'},
			{'1','0','1','1','1'},
			{'1','1','1','1','1'},
			{'1','0','0','1','0'}
		}));
		
		System.out.println(maximalSquare(new char[][] {
			{'0', '1'},
			{'1','0'}
		}));
		
		System.out.println(maximalSquare(new char[][] {
			{'0'}
		}));		
	}

	static public int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix[0].length == 0) {
			return 0;
		}

		int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
		int maxSq = Integer.MIN_VALUE;
		for (int i = 1; i <= matrix.length; i++) {
			for (int j = 1; j <= matrix[0].length; j++) {
				if (matrix[i - 1][j - 1] == '1') {
					dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
					maxSq = Math.max(maxSq, dp[i][j]);
				}
			}
		}
		return maxSq * maxSq;
	}
}
