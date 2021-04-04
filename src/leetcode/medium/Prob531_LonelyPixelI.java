package leetcode.medium;

public class Prob531_LonelyPixelI {

	public static void main(String[] args) {
		System.out.println(findLonelyPixel(new char[][] {
			{'W','W','B'},{'W','B','W'},{'B','W','W'}
		}));

	}

	static public int findLonelyPixel(char[][] picture) {
		int[] rows = new int[picture.length];
		int[] cols = new int[picture[0].length];

		for (int i = 0; i < picture.length; i++) {
			for (int j = 0; j < picture[i].length; j++) {
				if (picture[i][j] == 'W') {
					rows[i] += 1;
					cols[j] += 1;
				}
			}
		}
		int res = 0;
		for (int i = 0; i < picture.length; i++) {
			for (int j = 0; j < picture[i].length; j++) {
				if (picture[i][j] == 'B' && rows[i] == cols.length - 1 && cols[j] == rows.length - 1) {
					res++;
				}
			}
		}
		return res;
	}
}
