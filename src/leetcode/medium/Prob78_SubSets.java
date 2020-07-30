package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Prob78_SubSets {
	public static void main(String[] args) throws Exception {
		for (List<Integer> eachList : subsets(new int[] { 89, 12, 74, 26 })) {
			System.out.println(eachList);
		}
	}

	static public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> finalResult = new ArrayList<>();
		int[] bitsArray = new int[nums.length];
		solver(nums, /* startIndex= */ 0, bitsArray, finalResult);
		return finalResult;
	}

	static private void solver(int[] nums, int startIndex, int[] bitsArray, List<List<Integer>> finalResult) {
		if (startIndex == nums.length) {
			List<Integer> tempList = new ArrayList<>();
			for (int i = 0; i < bitsArray.length; i++) {
				if (bitsArray[i] == 1) {
					tempList.add(nums[i]);
				}
			}
			finalResult.add(tempList);
			return; // if you don't return line 32 would blast.
		}

		bitsArray[startIndex] = 0;
		solver(nums, startIndex + 1, bitsArray, finalResult);

		bitsArray[startIndex] = 1;
		solver(nums, startIndex + 1, bitsArray, finalResult);
	}
}
/*
 * x y z
 */