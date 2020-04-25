package leetcode.easy;

public class Prob1051_HeightChecker {

	public static void main(String[] args) {
		System.out.println(heightChecker(new int[] { 1, 1, 4, 2, 1, 3 }));
		System.out.println(heightChecker(new int[] { 1, 2, 3, 4, 5 }));
		System.out.println(heightChecker(new int[] { 5, 1, 2, 3, 4 }));

	}

	public static int heightChecker(int[] heights) {
		int c = 0;
		int[] heightsNew = java.util.Arrays.copyOf(heights, heights.length);
		java.util.Arrays.sort(heightsNew);
		for (int i = 0; i < heights.length; i++) {
			if (heights[i] != heightsNew[i]) {
				c++;
			}
		}
		return c;
	}
}
