package leetcode.easy;

import java.util.Collections;
import java.util.PriorityQueue;

public class Prob414_3rdLargestInArray {

	public static void main(String[] args) {
		System.out.println(thirdMax(new int[] { 1, 1, 2 }));
		System.out.println(thirdMax(new int[] { 3, 2, 1 }));
		System.out.println(thirdMax(new int[] { 1, 2 }));
		System.out.println(thirdMax(new int[] { 2, 2, 3, 1 }));
	}

	public static int thirdMax(int[] nums) {
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		for (int num : nums) {
			if (!q.contains(num)) {
				q.add(num);
			}
		}

		int result = -1;
		if (q.size() < 3) {
			result = q.remove();
		} else {
			int k = 3;
			while (k > 0) {
				result = q.remove();
				k--;
			}
		}
		return result;
	}
}
