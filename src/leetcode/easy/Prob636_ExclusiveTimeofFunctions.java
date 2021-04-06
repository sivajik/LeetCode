package leetcode.easy;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Prob636_ExclusiveTimeofFunctions {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(
				exclusiveTime(2, Arrays.asList(new String[] { "0:start:0", "1:start:2", "1:end:5", "0:end:6" }))));
	}

	static public int[] exclusiveTime(int n, List<String> logs) {
		Stack<int[]> stack = new Stack<>();
		int[] res = new int[n];
		for (String log : logs) {
			String[] s = log.split(":");
			int idx = Integer.parseInt(s[0]);
			int time = Integer.parseInt(s[2]);

			if (s[1].equals("start")) {
				stack.push(new int[] { idx, time });
			} else { // if (s[1].equals("end")) {
				int duration = time - stack.pop()[1] + 1;
				res[idx] += duration;

				if (!stack.empty()) {
					// so that earlier started process does not count this as its.
					res[stack.peek()[0]] -= duration;
				}
			}
		}
		return res;
	}
}
