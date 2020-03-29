package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class Prob36_ValidSudoku {

	public static void main(String[] args) {
		char[][] board = new char[][] {
/*			
{'5','3','.','.','7','.','.','.','.'},
{'6','.','.','1','9','5','.','.','.'},
{'.','9','8','.','.','.','.','6','.'},
{'8','.','.','.','6','.','.','.','3'},
{'4','.','.','8','.','3','.','.','1'},
{'7','.','.','.','2','.','.','.','6'},
{'.','6','.','.','.','.','2','8','.'},
{'.','.','.','4','1','9','.','.','5'},
{'.','.','.','.','8','.','.','7','9'}
*/
			
			{'.','.','.','.','5','.',   '.','1','.'},
			{'.','4','.','3','.','.',   '.','.','.'},
			{'.','.','.','.','.','3',   '.','.','1'},
			{'8','.','.','.','.','.','.','2','.'},
			{'.','.','2','.','7','.','.','.','.'},
			{'.','1','5','.','.','.','.','.','.'},
			{'.','.','.','.','.','2','.','.','.'},
			{'.','2','.','9','.','.','.','.','.'},
			{'.','.','4','.','.','.','.','.','.'}	
		};
		System.out.println(isValidSudoku(board));
	}

	public static boolean isValidSudoku(char[][] board) {
		// Checking row correctness.
		for (int i = 0; i < board.length; i++) {
			Map<Character, Boolean> rowMap = new HashMap<Character, Boolean>();
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] != '.') {
					if (rowMap.containsKey(board[i][j])) {
						return false;
					} else {
						rowMap.put(board[i][j], true);
					}
				}
			}
			rowMap = null;
		}

		// Checking column correctness.
		for (int i = 0; i < board.length; i++) {
			Map<Character, Boolean> colMap = new HashMap<Character, Boolean>();
			for (int j = 0; j < 9; j++) {
				if (board[j][i] != '.') {
					if (colMap.containsKey(board[j][i])) {
						return false;
					} else {
						colMap.put(board[j][i], true);
					}
				}
			}
			colMap = null;
		}

		// Each 3 X 3 check.
		for (int i = 0; i < board.length; i = i + 3) {
			for (int j = 0; j < board[i].length; j = j + 3) {
				if (!isValidCube(i, j, board)) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean isValidCube(int i, int j, char[][] board) {
		Map<Character, Boolean> cubeMap = new HashMap<Character, Boolean>();
		for (int rowIndex = i; rowIndex < i + 3; rowIndex++) {
			for (int colIndex = j; colIndex < j + 3; colIndex++) {
				if (board[rowIndex][colIndex] != '.') {
					if (cubeMap.containsKey(board[rowIndex][colIndex])) {
						return false;
					} else {
						cubeMap.put(board[rowIndex][colIndex], true);
					}
				}
			}
		}
		return true;
	}
}
