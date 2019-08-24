package leetcode.medium;

import java.util.Arrays;

public class Prob739_DailyTemperatures {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(dailyTemperatures(new int[] { 73, 74, 75, 71, 69, 72, 76, 73 })));
		System.out.println(Arrays.toString(dailyTemperatures(new int[] {})));
		System.out.println(Arrays.toString(dailyTemperatures(new int[] { 73 })));
		System.out.println(Arrays.toString(dailyTemperatures(new int[] { 73, 69, 68 })));
		System.out.println(Arrays.toString(dailyTemperatures(new int[] { 73, 74, 75 })));
		System.out.println(Arrays.toString(dailyTemperatures(new int[] { 89,62,70,58,47,47,46,76,100,70 })));
	}

	public static int[] dailyTemperatures(int[] T) {
		int[] result = new int[T.length];
		for (int i = 0; i < T.length; i++) {
			int forwardPointer = i + 1;
			while (true) {
				if (forwardPointer < T.length) {
					if (T[i] >= T[forwardPointer]) {
						forwardPointer++;
					} else {
						break;
					}
				} else {
					forwardPointer = i;
					break;
				}
			}
			result[i] = forwardPointer - i;
		}
		return result;
	}
}