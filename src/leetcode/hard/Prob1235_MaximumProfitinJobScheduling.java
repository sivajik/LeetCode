package leetcode.hard;

import java.util.Arrays;
import java.util.TreeMap;

public class Prob1235_MaximumProfitinJobScheduling {

	public static void main(String[] args) {
		System.out.println(
				jobScheduling(new int[] { 1, 2, 3, 3 }, new int[] { 3, 4, 5, 6 }, new int[] { 50, 10, 40, 70 }));

	}

	static public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

		int n = startTime.length;
		int[][] jobs = new int[n][];
		for (int i = 0; i < n; i++) {
			jobs[i] = new int[] { startTime[i], endTime[i], profit[i] };
		}
		Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
		TreeMap<Integer, Integer> dp = new TreeMap<>();
		dp.put(0, 0);
		int res = 0;
		for (int[] job : jobs) {
			int cur = dp.floorEntry(job[0]).getValue() + job[2];
			if (cur > res) {
				dp.put(job[1], res = cur);
			}
		}
		return res;

	}
}
