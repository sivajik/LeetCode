package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prob57_InsertInterval {

	public static void main(String[] args) {
		for (int[] e : insert(new int[][] { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } },
				new int[] { 4, 8 })) {
			System.out.println(Arrays.toString(e));
		}

	}

	static public int[][] insert(int[][] intervals, int[] newInterval) {
		int newStart = newInterval[0];
		int newEnd = newInterval[1];

		int i = 0, n = intervals.length;
		List<int[]> op = new ArrayList<>();

		// add before
		while (i < n && intervals[i][1] < newStart) {
			op.add(intervals[i]);
			i++;
		}
		// merge if needed
		while (i < n && intervals[i][0] <= newEnd) {
			newStart = Math.min(newStart, intervals[i][0]);
			newEnd = Math.max(newEnd, intervals[i][1]);
			i++;
		}
		op.add(new int[] { newStart, newEnd });

		// add after
		while (i < n) {
			op.add(intervals[i]);
			i++;
		}

		return op.toArray(new int[0][0]);
	}
}
