package leetcode.thirtydays.nov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Day18_MergeIntervals {

	public static void main(String[] args) {
		for (int[] merged : merge(new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } })) {
			System.out.println(Arrays.toString(merged));
		}
		System.out.println();
		for (int[] merged : merge(new int[][] { { 1, 4 }, { 4, 5 } })) {
			System.out.println(Arrays.toString(merged));
		}
	}

	static public int[][] merge(int[][] intervals) {
		if (intervals == null || intervals.length <= 1) {
			return intervals;
		}

		// sort by first index (0th index)
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		List<int[]> op = new ArrayList<>();
		int[] currInterval = intervals[0];
		op.add(currInterval);

		for (int[] interval : intervals) {
			int currStart = currInterval[0];
			int currEnd = currInterval[1];

			int nextStart = interval[0];
			int nextEnd = interval[1];

			if (currEnd >= nextStart) {
				currInterval[1] = Math.max(currEnd, nextEnd);
			} else {
				currInterval = interval;
				op.add(currInterval);
			}
		}

		return op.toArray(new int[op.size()][]);
	}
}
