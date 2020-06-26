package leetcode.medium;

public class Prob287_FindTheDuplicateNumber {

	public static void main(String[] args) {
		System.out.println(findDuplicate(new int[] { 1, 3, 4, 2, 2 }));
		System.out.println(findDuplicate(new int[] { 3,1,3,4,2 }));

	}

	// [1,3,4,2,2]
	static public int findDuplicate(int[] nums) {
		for (int elem : nums) {
			int index = Math.abs(elem) - 1;

			if (nums[index] < 0) {
				return Math.abs(elem);
			} else {
				nums[index] = -nums[index];
			}
		}
		return -1;
	}
}
