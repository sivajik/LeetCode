package leetcode.g5.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob1122_Relative_Sort_Array {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(
				relativeSortArray(new int[] { 2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19 }, new int[] { 2, 1, 4, 3, 9, 6 })));
		System.out.println(
				Arrays.toString(relativeSortArray(new int[] { 28, 6, 22, 8, 44, 17 }, new int[] { 22, 28, 8, 6 })));
		System.out.println(Arrays.toString(relativeSortArray(new int[] {}, new int[] { 22, 28, 8, 6 })));
		System.out.println(Arrays.toString(relativeSortArray(new int[] { 28, 6, 22, 8, 44, 17 }, new int[] {})));
	}

	static public int[] relativeSortArray(int[] arr1, int[] arr2) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr2.length; i++) {
			map.put(arr2[i], i);
		}

		List<Integer> l = new ArrayList<>();
		List<Integer> m = new ArrayList<>();
		for (int elem : arr1) {
			if (map.containsKey(elem)) {
				l.add(elem);
			} else {
				m.add(elem);
			}
		}

		Comparator<Integer> cmp1 = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return map.get(o1) - map.get(o2);

			}
		};

		Comparator<Integer> cmp2 = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;

			}
		};

		l.sort(cmp1);
		m.sort(cmp2);

		int[] res = new int[arr1.length];
		int c = 0;
		for (int i = 0; i < l.size(); i++) {
			res[c++] = l.get(i);
		}

		for (int j = 0; j < m.size(); j++) {
			res[c++] = m.get(j);
		}
		return res;
	}
}
