package leetcode.medium;

public class Prob442_DuplicatesInArray {

	public static void main(String[] args) {
		System.out.println(findDuplicates(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }));
		System.out.println();
		System.out.println(findDuplicates(new int[] { 10, 2, 5, 10, 9, 1, 1, 4, 3, 7 }));
	}

	public static java.util.List<Integer> findDuplicates(int[] nums) {
		java.util.List<Integer> list = new java.util.ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int val = Math.abs(nums[i]) - 1;
			if (nums[val] > 0) {
				nums[val] = -1 * nums[val];
			} else {
				// System.out.println("Already there: " + nums[val] + " -> " + (val+1));
				list.add(Math.abs(val + 1));
			}
		}
		// System.out.println(Arrays.toString(nums));
		return list;
	}
}
