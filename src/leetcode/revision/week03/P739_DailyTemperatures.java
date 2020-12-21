package leetcode.revision.week03;

import java.util.Arrays;
import java.util.Stack;

public class P739_DailyTemperatures {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(dailyTemperatures(new int[] { 73, 74, 75, 71, 69, 72, 76, 73 })));
		System.out.println(Arrays.toString(dailyTemperatures(new int[] {})));
		System.out.println(Arrays.toString(dailyTemperatures(new int[] { 73 })));
		System.out.println(Arrays.toString(dailyTemperatures(new int[] { 73, 69, 68 })));
		System.out.println(Arrays.toString(dailyTemperatures(new int[] { 73, 74, 75 })));
		System.out.println(Arrays.toString(dailyTemperatures(new int[] { 89, 62, 70, 58, 47, 47, 46, 76, 100, 70 })));
	}

	static public int[] dailyTemperatures(int[] T) {
		int[] result = new int[T.length];
		Stack<Integer> s = new Stack<>();
		Stack<Integer> in = new Stack<>();

		for (int i = T.length - 1; i >= 0; i--) {
			if (i == T.length - 1) {
				s.push(T[i]);
				in.push(i);
				result[i] = 0;
				continue;
			} else {
				if (!s.isEmpty() && s.peek() <= T[i]) {
					while (!s.isEmpty() && s.peek() <= T[i]) {
						s.pop();
						in.pop();
					}
					if (s.isEmpty()) {
						result[i] = 0;
					} else {
						result[i] = in.peek() - i;
					}
				} else if (!s.isEmpty() && s.peek() > T[i]) {
					result[i] = in.peek() - i;
				}
				s.push(T[i]);
				in.push(i);
			}
		}
		return result;
	}
}
/*
 * [73, 74, 75, 71, 69, 72, 76, 73] [ 1, 1, 4, 2, 1, 1, 0, 0 ].
 */