package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Prob658_FindKClosestElements {

	public static void main(String[] args) {
		System.out.println(findClosestElements(new int[] {1,2,3,4,5}, 4, 3));

	}
	// not so efficient solution
	static public List<Integer> findClosestElements(int[] arr, int k, int x) {
		List<Integer> a = new ArrayList<>();
		for (int i : arr) {
			a.add(i);
		}

		a.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer a, Integer b) {
					return Math.abs(a - x) - Math.abs(b - x);
			}
		});
		System.out.println(a);
		a = a.subList(0, k);
		Collections.sort(a);
		return a;
	}
}
