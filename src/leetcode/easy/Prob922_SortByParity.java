package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Prob922_SortByParity {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(sortArrayByParityII(new int[] { 4, 2, 5, 7 })));

	}

	public static int[] sortArrayByParityII(int[] A) {
		List<Integer> oddList = new ArrayList<Integer>();
		List<Integer> evenList = new ArrayList<Integer>();

		for (int i = 0; i < A.length; i = i + 1) {
			if (A[i] % 2 == 0) {
				evenList.add(A[i]);
			} else {
				oddList.add(A[i]);
			}
		}

		Collections.sort(evenList);
		Collections.sort(oddList);

		for (int i = 0, k = 0; i < evenList.size(); i++, k = k + 2) {
			A[k] = evenList.get(i);
			A[k + 1] = oddList.get(i);
		}
		return A;
	}
}
