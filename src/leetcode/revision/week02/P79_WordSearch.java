package leetcode.revision.week02;

public class P79_WordSearch {

	public static void main(String[] args) {
		System.out.println(exist(new char[][] {
			{'A', 'B', 'C', 'E'},
			{'S', 'F', 'C', 'S'},
			{'A', 'D', 'E', 'E'}}, "ABCCED"));

	}

	static public boolean exist(char[][] board, String word) {
		if (word == null || word.length() == 0) {
			return false;
		}

		if (board == null || board[0].length == 0) {
			return false;
		}

		boolean[][] visited = new boolean[board.length][board[0].length];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (dfs(i, j, 0, word, visited, board)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean dfs(int i, int j, int charIndex, String word, boolean[][] visited, char[][] board) {
		if (charIndex == word.length()) {
			return true;
		}

		if (i < 0 || j < 0 || i >= visited.length || j >= visited[i].length || visited[i][j] == true
				|| word.charAt(charIndex) != board[i][j]) {
			return false;
		}

		visited[i][j] = true;
		boolean res = dfs(i + 1, j, charIndex + 1, word, visited, board)
				|| dfs(i - 1, j, charIndex + 1, word, visited, board)
				|| dfs(i, j + 1, charIndex + 1, word, visited, board)
				|| dfs(i, j - 1, charIndex + 1, word, visited, board);

		visited[i][j] = false;

		// TODO Auto-generated method stub
		return res;
	}

}
