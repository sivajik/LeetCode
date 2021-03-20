package leetcode.medium;

public class Prob794_ValidTicTacToeState {

	public static void main(String[] args) {
		System.out.println(validTicTacToe(new String[] { "O  ", "   ", "   " }) == false);
		System.out.println(validTicTacToe(new String[] { "XOX", " X ", "   " }) == false);
		System.out.println(validTicTacToe(new String[] { "XXX", "   ", "OOO" }) == false);
		System.out.println(validTicTacToe(new String[] { "XOX", "O O", "XOX" }) == true);
	}

	static public boolean validTicTacToe(String[] board) {
		int xCount = 0;
		int oCount = 0;
		for (int i = 0; i < board.length; i++) {
			for (char c : board[i].toCharArray()) {
				if (c == 'X') {
					xCount++;
				} else if (c == 'O') {
					oCount++;
				}
			}
		}

		if (xCount != oCount && xCount != oCount + 1) {
			return false;
		}
		if (win(board, 'X') && xCount != oCount + 1) {
			return false;
		}
		if (win(board, 'O') && xCount != oCount) {
			return false;
		}
		return true;
	}

	static private boolean win(String[] board, char c) {
		for (int i = 0; i < 3; i++) {
			if (board[i].charAt(0) == c && board[i].charAt(1) == c && board[i].charAt(2) == c) {
				return true;
			}
			if (board[0].charAt(i) == c && board[1].charAt(i) == c && board[2].charAt(i) == c) {
				return true;
			}
		}
		if (board[0].charAt(0) == c && board[1].charAt(1) == c && board[2].charAt(2) == c) {
			return true;
		}
		if (board[2].charAt(0) == c && board[1].charAt(1) == c && board[0].charAt(2) == c) {
			return true;
		}
		return false;
	}
}
