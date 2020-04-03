package leetcode.thirtydays;

public class Day01_SingleNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int singleNumber(int[] nums) {

		int result = nums[0];
		for (int i = 1; i < nums.length; i++) {
			result = result ^ nums[i];
		}
		return result;
	
    }
}
