package leetcode.revision.week02;

public class P419_BattleshipsInABoard {

	public static void main(String[] args) {
		System.out.println(countBattleships(new char[][] {
			{'X', '.', '.', 'X'},
			{'.', '.', '.', 'X'},
			{'.', '.', '.', 'X'}
		}));
	}

	static public int countBattleships(char[][] board) {
		int count = 0;
		if (board == null || board.length == 0 || board[0].length == 0) {
			return count;
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 'X') {
					count += helper(board, i, j);
				}
			}
		}
		return count;
	}

	private static int helper(char[][] board, int i, int j) {
		if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] == '.') {
			return 0;
		}

		board[i][j] = '.';
		helper(board, i + 1, j);
		helper(board, i - 1, j);
		helper(board, i, j + 1);
		helper(board, i, j - 1);
		return 1;
	}
}
