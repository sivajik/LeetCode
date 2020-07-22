package leetcode.thirtydays.july;

public class Day21_WordSearch {
	public static void main(String[] args) throws Exception {

	}

	public boolean exist(char[][] board, String word) {

		if (board == null || board.length == 0 || board[0].length == 0) {
			return false;
		}

		boolean[][] visited = new boolean[board.length][board[0].length];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (DFS(board, word, i, j, visited, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean DFS(char[][] board, String word, int i, int j, boolean[][] visited, int charIndex) {
		if (charIndex == word.length()) {
			return true;
		}

		if (i >= board.length || i < 0 || j >= board[i].length || j < 0 || visited[i][j] == true
				|| board[i][j] != word.charAt(charIndex)) {
			return false;
		}

		visited[i][j] = true;
		boolean res = DFS(board, word, i + 1, j, visited, charIndex + 1)
				|| DFS(board, word, i - 1, j, visited, charIndex + 1)
				|| DFS(board, word, i, j + 1, visited, charIndex + 1)
				|| DFS(board, word, i, j - 1, visited, charIndex + 1);

		visited[i][j] = false;
		return res;
	}
}
