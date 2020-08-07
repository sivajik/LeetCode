package leetcode.easy;

public class Prob665_NonDecArray {

	public static void main(String[] args) {
		System.out.println(checkPossibility(new int[] { 4, 2, 3 }));
		System.out.println(checkPossibility(new int[] { 4, 2, 1 }));

	}

	public static boolean checkPossibility(int[] nums) {

		if (nums == null || nums.length < 2)
			return true;

		int problematicIndex = -1;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < nums[i - 1]) {
				if (problematicIndex != -1) {
					return false;
				} else {
					problematicIndex = i - 1;
				}
			}
		}

		if (problematicIndex == -1) {
			return true;
		}

		if (problematicIndex == 0 || problematicIndex == nums.length - 2) {
			return true;
		}
		if (nums[problematicIndex - 1] <= nums[problematicIndex + 1] || nums[problematicIndex] <= nums[problematicIndex + 2])
			return true;
		return false;
	}
}
