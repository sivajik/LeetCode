package leetcode.medium;

import java.util.Arrays;
import java.util.Stack;

public class Prob1762_BuildingsWithAnOceanView {

	public static void main(String[] args) {
		// System.out.println(Arrays.toString(findBuildings(new int[] { 4, 2, 3, 1 })));
		// System.out.println(Arrays.toString(findBuildings(new int[] { 4, 3, 2, 1 })));
		System.out.println(Arrays.toString(findBuildings(new int[] { 1, 3, 2, 4 })));
	}

	static public int[] findBuildings(int[] heights) {
		Stack<Integer> s = new Stack<Integer>();

		for (int i = 0; i < heights.length; i++) {
			while (!s.isEmpty() && heights[s.peek()] <= heights[i]) {
				s.pop();
			}
			s.push(i);
		}

		int[] res = new int[s.size()];
		int size = s.size();
		for (int i = size - 1; i >= 0; i--) {
			res[i] = s.pop();
		}

		return res;
	}
}
