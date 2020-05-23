package leetcode.easy;

public class Prob27_RemoveElement {

	public static void main(String[] args) {
		System.out.println(removeElement(new int[] { 3, 2, 2, 3 }, 3));
		System.out.println(removeElement(new int[] { 0, 1, 2, 2, 3, 0, 4, 2 }, 2));
		System.out.println(removeElement(new int[] { 3, 3 }, 3));
		System.out.println(removeElement(new int[] {}, 1));
	}

	public static int removeElement(int[] nums, int val) {
		int c = 0;
		for (int num: nums) {
			if (num != val) {
				nums[c++] = num;
			}
		}
		return c;
	}
}
