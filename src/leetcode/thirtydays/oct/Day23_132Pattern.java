package leetcode.thirtydays.oct;

import java.util.Stack;

public class Day23_132Pattern {

	public static void main(String[] args) {
		System.out.println(find132pattern(new int[] { 6, 12, 3, 4, 6, 11, 20 }));
	}

	static public boolean find132pattern(int[] nums) {
		if (nums.length < 3) {
			return false;
		}

		int[] min = new int[nums.length];
		min[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			min[i] = Math.min(nums[i], min[i - 1]);
		}
		Stack<Integer> stack = new Stack<>();

		for (int j = nums.length - 1; j >= 0; j--) {
			if (nums[j] > min[j]) { // left hand value is less than middle value. now find K
				while (!stack.isEmpty() && stack.peek() <= min[j])
					stack.pop();
				if (!stack.isEmpty() && stack.peek() < nums[j])
					return true;
				stack.push(nums[j]);
			}
		}

		return false;
	}
}
