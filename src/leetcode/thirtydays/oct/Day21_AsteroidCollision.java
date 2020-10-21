package leetcode.thirtydays.oct;

import java.util.Arrays;
import java.util.Stack;

public class Day21_AsteroidCollision {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(asteroidCollision(new int[] { 5, 10, -5 })));
		System.out.println(Arrays.toString(asteroidCollision(new int[] { 8, -8 })));
		System.out.println(Arrays.toString(asteroidCollision(new int[] { 10, 2, -5 })));
		System.out.println(Arrays.toString(asteroidCollision(new int[] { -2, -1, 1, 2 })));
	}

	static public int[] asteroidCollision(int[] asteroids) {
		if (asteroids.length <= 1) {
			return asteroids;
		}
		Stack<Integer> stack = new Stack<>();

		int i = 0;
		while (i < asteroids.length) {
			if (asteroids[i] > 0) {
				stack.push(asteroids[i]);
			} else {
				while (!stack.isEmpty() && stack.peek() > 0 && Math.abs(asteroids[i]) > stack.peek()) {
					stack.pop();
				}
				if (stack.isEmpty() || stack.peek() < 0) {
					stack.push(asteroids[i]);
				} else if ((Math.abs(stack.peek()) == Math.abs(asteroids[i])) && stack.peek() * asteroids[i] < 0) {
					stack.pop();
				}
			}
			i++;
		}

		int[] res = new int[stack.size()];
		i = stack.size() - 1;
		while (!stack.isEmpty()) {
			res[i--] = stack.pop();
		}
		return res;
	}
}
