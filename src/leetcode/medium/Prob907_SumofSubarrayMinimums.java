package leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class Prob907_SumofSubarrayMinimums {

	public static void main(String[] args) {
		System.out.println(sumSubarrayMins(new int[] { 3, 1, 2, 4 }));
		System.out.println(sumSubarrayMins(new int[] { 11, 81, 94, 43, 3 }));
	}

	static public int sumSubarrayMins(int[] A) {
		long res = 0;
		Deque<Integer> stack = new ArrayDeque<>();
		for (int i = 0; i <= A.length; i++) {
			while (!stack.isEmpty() && (i == A.length || A[stack.peek()] > A[i])) {
				int mid = stack.pop(), L = mid - (stack.isEmpty() ? -1 : stack.peek()), R = i - mid;
				res += (long) A[mid] * L * R;
			}
			stack.push(i);
		}
		return (int) (res % 1_000_000_007);

	}

	static public int sumSubarrayMinsBruteForce(int[] arr) {
		List<List<Integer>> res = new ArrayList<>();
		solver(arr, 0, 0, res, new ArrayList<>());

		int sum = 0;
		int mod = 1_000_000_000 + 7;
		for (List<Integer> l : res) {
			Collections.sort(l);
			sum = (sum + l.get(0)) % mod;
		}
		return sum;
	}

	private static void solver(int[] arr, int start, int end, List<List<Integer>> res, List<Integer> tempList) {
		if (arr.length == end) {
			return;
		} else if (start > end) {
			solver(arr, 0, end + 1, res, tempList);
		} else {
			List<Integer> temp = new ArrayList<>();
			for (int i = start; i <= end; i++) { // until including end
				temp.add(arr[i]);
			}
			if (temp.size() > 0) {
				res.add(new ArrayList(temp));
			}
			solver(arr, start + 1, end, res, tempList);
		}
	}
}
