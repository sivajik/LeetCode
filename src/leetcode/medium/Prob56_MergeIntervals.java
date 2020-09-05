package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Prob56_MergeIntervals {

	public static void main(String[] args) {
		for (int[] eachelem : merge(new int[][] {{1,3},{2,6},{8,10},{15,18}})) {
			System.out.println(Arrays.toString(eachelem));
		}
		System.out.println();
		for (int[] eachelem : merge(new int[][] {{1,4}, {4,5}})) {
			System.out.println(Arrays.toString(eachelem));
		}
		System.out.println();
		for (int[] eachelem : merge(new int[][] {{1,4}, {2,3}})) {
			System.out.println(Arrays.toString(eachelem));
		}		
	}

	static public int[][] merge(int[][] intervals) {
		if (intervals == null || intervals.length == 0) {
			return intervals;
		}
		
		Arrays.sort(intervals, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] < o2[0]) {
					return -1;
				} else if (o1[0] == o2[0]) {
					return 0;
				} else {
					return 1;
				}
			}			
		});
		List<int[]> result = new ArrayList<>();
		
		// main logic starts
		for (int i = 0; i < intervals.length; i++) {
			if (result.isEmpty()) {
				result.add(intervals[i]);
			} else {
				int[] lastElemInList = result.get(result.size() - 1);
				int[] currElem = intervals[i];
				
				if (lastElemInList[1] >= currElem[0]) {
					lastElemInList[1] = Math.max(currElem[1], lastElemInList[1]);
				} else {
					result.add(currElem);
				}
			}
		}
		// main logic ends
		
		int c = 0;
		int[][] result1 = new int[result.size()][];
		for (int[] eachElem : result) {
			result1[c++] = eachElem;
		}
		
		return result1;
	}
}
