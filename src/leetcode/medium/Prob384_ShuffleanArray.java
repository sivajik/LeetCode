package leetcode.medium;

import java.util.Arrays;
import java.util.Random;

public class Prob384_ShuffleanArray {

	public static void main(String[] args) {
		Solution solution = new Solution(new int[] {1, 2, 3});
		System.out.println(Arrays.toString(solution.shuffle()));    // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must be equally likely to be returned. Example: return [3, 1, 2]
		System.out.println(Arrays.toString(solution.reset()));      // Resets the array back to its original configuration [1,2,3]. Return [1, 2, 3]
		System.out.println(Arrays.toString(solution.shuffle()));    // Returns the random shuffling of array [1,2,3]. Example: return [1, 3, 2]
	}

	static class Solution {
		int[] nums;
		int[] orig;

		public Solution(int[] nums) {
			this.nums = Arrays.copyOf(nums, nums.length);
			this.orig = Arrays.copyOf(nums, nums.length);
		}

		public int[] reset() {
			this.nums = Arrays.copyOf(this.orig, this.orig.length);
			return this.nums;
		}

		public int[] shuffle() {
			Random r = new Random();
			for (int i = 0; i < this.nums.length; i++) {
				int index1 = i;
				int index2 = r.nextInt(this.nums.length);
				
				int temp = nums[index1];
				nums[index1] = nums[index2];
				nums[index2] = temp;
			}
			return this.nums;
		}
	}
}
