package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class Prob1155_NumberofDiceRollsWithTargetSum {

	public static void main(String[] args) {
		System.out.println(numRollsToTarget(1, 6, 3));
		System.out.println(numRollsToTarget(2, 6, 7));
	}

	static int mod = 1_000_000_007;
	static Map<String, Integer> memo = new HashMap<>(); // use global cache, dont keep in method.

	static public int numRollsToTarget(int d, int f, int target) {
		if (target > d * f) { // d = 2, f =6, you ask for 13
			return 0;
		}
		if (target < d) { // d == 1 you ask for 0.
			return 0;
		}

		if (d == 1) { // d = 1, f = 6, you ask for 4
			return target <= f ? 1 : 0;
		}

		String key = "" + d + f + target;
		if (!memo.containsKey(key)) {
			int sum = 0;
			for (int i = 1; i<=f; i++) { // for each face use all dice with a target-<dice_value>
				sum += numRollsToTarget(d - 1, f, target - i);
				sum = sum % mod;
			}
			memo.put(key, sum);
		}
		return memo.get(key);
	}
}
