package leetcode.g5.medium;

import java.util.HashMap;
import java.util.Map;

public class Prob1570_DotProductTwoSparseVectors {

	public static void main(String[] args) {
		SparseVector v1 = new SparseVector(new int[] { 0, 1, 0, 0, 2, 0, 0 });
		SparseVector v2 = new SparseVector(new int[] { 1, 0, 0, 0, 3, 0, 4 });
		int ans = v1.dotProduct(v2);
		System.out.println(ans);

	}

	static class SparseVector {
		Map<Integer, Integer> map = new HashMap<>();

		SparseVector(int[] nums) {
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] != 0) {
					map.put(i, nums[i]);
				}
			}
		}

		// Return the dotProduct of two sparse vectors
		public int dotProduct(SparseVector vec) {
			int sum = 0;
			for (int eachKey : vec.map.keySet()) {
				if (map.containsKey(eachKey)) {
					sum += map.get(eachKey) * vec.map.get(eachKey);
				}
			}
			return sum;
		}
	}
}
