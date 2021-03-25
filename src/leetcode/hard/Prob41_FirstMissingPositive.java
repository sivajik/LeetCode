package leetcode.hard;

public class Prob41_FirstMissingPositive {

	public static void main(String[] args) {
		System.out.println(firstMissingPositive(new int[] { 1, 2, 0 }));
		System.out.println(firstMissingPositive(new int[] { 3, 4, -1, 1 }));
		System.out.println(firstMissingPositive(new int[] { 7, 8, 9, 11, 12 }));
	}

	static public int firstMissingPositive(int[] nums) {
		int i = 0;
		while (i < nums.length) {
			int index = nums[i] - 1;
			if (nums[i] > 0 && index < nums.length && nums[i] != nums[index]) {
				swap(nums, i, index);
			} else {
				i++;
			}
		}

		for (i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}
		return nums.length + 1;
	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
