package leetcode.thirtydays.april;

public class Day25_JumpGame {

	public static void main(String[] args) {
		System.out.println(canJump(new int[] { 2, 3, 1, 1, 4 }));

	}

	public static boolean canJump(int[] nums) {
		if (nums.length <= 1) {
			return true;
		}
		int reach = 0;
		for (int i = 0; i <= reach; i++) {
			reach = Math.max(reach, i + nums[i]);
			if (reach >= nums.length - 1) {
				return true;
			}
		}
		return false;
	}
}
