package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Prob216_CombinationSumIII {

	public static void main(String[] args) {
		for (List<Integer> l : combinationSum3(3, 7)) {
			System.out.println(l);
		}
	}

	static public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> comb = new ArrayList<>();

		solver(n, k, comb, 0, res);

		return res;
	}

	static private void solver(int remain, int k, List<Integer> comb, int start, List<List<Integer>> res) {
		if (remain == 0 && comb.size() == k) {
			res.add(new ArrayList(comb));
			return;
		}

		if (remain < 0 || comb.size() == k) {
			return;
		}

		for (int i = start; i < 9; i++) {
			comb.add(i + 1);
			solver(remain - i - 1, k, comb, i + 1, res); // if u keep start+1, gone.
			comb.remove(comb.size() - 1);

		}
	}
}
