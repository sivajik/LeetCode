package leetcode.thirtydays.may;

public class Day12_SingleElement {

	public static void main(String[] args) {
		System.out.println(singleNonDuplicate(new int[] { 1, 1, 2, 3, 3, 4, 4, 8, 8 }));
		System.out.println(singleNonDuplicate(new int[] { 3, 3, 7, 7, 10, 11, 11 }));
		System.out.println(singleNonDuplicate(new int[] { 3 }));
	}

	public static int singleNonDuplicateXor(int[] nums) {
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			res = res ^ nums[i];
		}
		return res;
	}

	public static int singleNonDuplicate(int[] nums) {
		int l = 0;
		int h = nums.length - 1;
		while (l < h) {
			int m = l + (h - l) / 2;
			if (m % 2 == 0) { // [1,1,3,3,'4',4,5,5,6]
				if (m + 1 < nums.length && nums[m] == nums[m + 1]) {
					l = m + 2;
				} else {
					h = m;
				}
			} else { // [1,1,3,3,4,5,5]
				if (m - 1 >= 0 && nums[m] == nums[m - 1]) {
					l = m + 1;
				} else {
					h = m - 1;
				}
			}
		}
		return nums[l];
	}
}
