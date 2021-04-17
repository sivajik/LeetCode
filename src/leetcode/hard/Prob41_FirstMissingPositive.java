package leetcode.hard;

public class Prob41_FirstMissingPositive {

	public static void main(String[] args) {
		System.out.println(firstMissingPositive(new int[] { 1, 2, 0 }));
		System.out.println(firstMissingPositive(new int[] { 3, 4, 6, 1 }));
		System.out.println(firstMissingPositive(new int[] { 7, 8, 9, 11, 12 }));
	}

	static public int firstMissingPositive(int[] nums) {
		int curr = 0;
		while (curr < nums.length) {
			int index = nums[curr] - 1;
			// exclude negative numbers
			// swap only if current number is NOT in its 'supposed to be right' place
			if (nums[curr] > 0 && index < nums.length && nums[curr] != nums[index]) {
				swap(nums, curr, index);
			} else {
				curr++;
			}
		}
		// if i-th number is not in i-th index (ofcourse 1-based)
		for (curr = 0; curr < nums.length; curr++) {
			if (nums[curr] != curr + 1) {
				return curr + 1;
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
