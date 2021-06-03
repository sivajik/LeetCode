package leetcode.thirtydays.june21;

import java.util.Arrays;

public class P03_MaximumAreaCake {

	public static void main(String[] args) {
		System.out.println(maxArea(5, 4, new int[] { 1, 2, 4 }, new int[] { 1, 3 }));
		System.out.println(maxArea(5, 4, new int[] { 3, 1 }, new int[] { 1 }));

	}

	static public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
		Arrays.sort(horizontalCuts);
		Arrays.sort(verticalCuts);

		long maxH = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length - 1]);
		for (int i = 1; i < horizontalCuts.length; i++) {
			maxH = Math.max(maxH, horizontalCuts[i] - horizontalCuts[i - 1]);
		}
		// System.out.println(maxH);

		long maxW = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]);
		for (int i = 1; i < verticalCuts.length; i++) {
			maxW = Math.max(maxW, verticalCuts[i] - verticalCuts[i - 1]);
		}
		// System.out.println(maxW);

		return (int) ((maxW * maxH) % (1e9 + 7));
	}
}
