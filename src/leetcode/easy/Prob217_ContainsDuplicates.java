package leetcode.easy;

public class Prob217_ContainsDuplicates {

	public static void main(String[] args) {
		System.out.println(containsDuplicate(new int[] { 1, 2, 3, 1 }));
		System.out.println(containsDuplicate(new int[] { 1, 2, 3, 4 }));
		System.out.println(containsDuplicate(new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 }));
	}

	public static boolean containsDuplicate(int[] nums) {
		if (nums.length == 0) {
			return false;
		}
		
		java.util.Arrays.sort(nums);
		int prev = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == prev) {
				return true;
			} else {
				prev = nums[i];
			}
		}
		return false;
	}

	public static boolean containsDuplicate1(int[] nums) {
		java.util.Map<Integer, Integer> m = new java.util.HashMap<Integer, Integer>();
		for (int n : nums) {
			if (m.containsKey(n)) {
				return true;
			} else {
				m.put(n, 1);
			}
		}
		return false;
	}
}
