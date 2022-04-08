package leetcode.g5.easy;

import java.util.Collections;
import java.util.Iterator;

public class Prob414_ThirdMaximumNumber {

	public static void main(String[] args) {
		System.out.println(thirdMax(new int[] { 3, 2, 1 }));
		System.out.println(thirdMax(new int[] { 1, 2 }));
		System.out.println(thirdMax(new int[] { 2, 2, 3, 1 }));
		System.out.println(thirdMax(new int[] { -2147483648, 1, 1 }));
	}

	static public int thirdMax(int[] nums) {
		java.util.Set<Integer> set = new java.util.TreeSet<>(Collections.reverseOrder());
		for (int n : nums) {
			set.add(n);
		}
		if (set.size() < 3) {
			Iterator<Integer> itr = set.iterator();
			return itr.next();
		} else {
			Iterator<Integer> itr = set.iterator();
			itr.next();
			itr.next();
			return itr.next();
		}
	}
}
