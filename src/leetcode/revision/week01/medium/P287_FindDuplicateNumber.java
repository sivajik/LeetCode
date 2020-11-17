package leetcode.revision.week01.medium;

public class P287_FindDuplicateNumber {

	public static void main(String[] args) {
		System.out.println(findDuplicate(new int[] { 1, 3, 4, 2, 2 }));
		System.out.println(findDuplicate(new int[] { 3, 1, 3, 4, 2 }));
		System.out.println(findDuplicate(new int[] { 1, 1 }));
		System.out.println(findDuplicate(new int[] { 1, 1, 2 }));
	}

	static public int findDuplicate(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]) - 1;
			if (nums[index] < 0) {
				return Math.abs(nums[i]);
			} else {
				nums[index] = -1 * nums[index];
			}
		}
		return -1;
	}
}
