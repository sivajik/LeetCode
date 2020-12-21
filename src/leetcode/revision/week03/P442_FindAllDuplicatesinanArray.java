package leetcode.revision.week03;

import java.util.ArrayList;
import java.util.List;;

public class P442_FindAllDuplicatesinanArray {

	public static void main(String[] args) {
		System.out.println(findDuplicates(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }));
	}

	static public List<Integer> findDuplicates(int[] nums) {
		List<Integer> l = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]) - 1;
			if (nums[index] > 0) {
				nums[index] = -1 * nums[index];
			} else {
				l.add(Math.abs(nums[i]));
			}
		}
		return l; 
	}
}
// 4, -3, -2, -7, 8, 2, -3, 1 