package leetcode.hard;

import java.util.Stack;

public class Prob84_LargestRectangleinHistogram {

	public static void main(String[] args) {
		System.out.println(largestRectangleArea(new int[] { 6, 7, 5, 2, 4, 5, 9, 3 }));

	}

	static public int largestRectangleArea(int[] heights) {
		int size = heights.length;
		Stack<Integer> stk = new Stack<>();
		stk.push(-1);
		int max = 0;
		for (int i = 0; i < heights.length; i++) {
			while (stk.peek() != -1 && heights[i] < heights[stk.peek()]) {
				int h = heights[stk.pop()];
				int w = i - stk.peek() - 1;
				max = Math.max(max, h * w);
			}
			stk.push(i);
		}

		while (stk.peek() != -1) {
			int h = heights[stk.pop()];
			int w = size - stk.peek() - 1;
			max = Math.max(max, h * w);
		}
		return max;
	}
}
