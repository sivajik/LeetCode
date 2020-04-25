package leetcode.easy;
import java.util.List;

public class Prob1380_LuckyNumbersInMatric {

	public static void main(String[] args) {
		System.out.println(luckyNumbers(new int[][] { { 3, 7, 8 }, { 9, 11, 13 }, { 15, 16, 17 } }));
		System.out.println(luckyNumbers(new int[][] { { 1, 10, 4, 2 }, { 9, 3, 8, 7 }, { 15, 16, 17, 12 } }));
		System.out.println(luckyNumbers(new int[][] { { 7, 8 }, { 1, 2 } }));
	}

	public static List<Integer> luckyNumbers(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;

		int[][] tranMat = new int[cols][rows];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				tranMat[j][i] = matrix[i][j];
			}
		}

		java.util.Set<Integer> rowMinArray = new java.util.HashSet<Integer>();
		for (int i = 0; i < matrix.length; i++) {
			rowMinArray.add(min(matrix[i]));
		}

		java.util.List<Integer> list = new java.util.ArrayList<Integer>();

		for (int i = 0; i < tranMat.length; i++) {
			int temp = max(tranMat[i]);
			if (rowMinArray.contains(temp)) {
				list.add(temp);
			}
		}

		return list;
	}

	public static int max(int[] is) {
		int maxVal = Integer.MIN_VALUE;
		for (int elem : is) {
			if (elem > maxVal) {
				maxVal = elem;
			}
		}
		return maxVal;
	}

	public static Integer min(int[] is) {
		int minVal = Integer.MAX_VALUE;
		for (int elem : is) {
			if (elem < minVal) {
				minVal = elem;
			}
		}
		return minVal;
	}
}
