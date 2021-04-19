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
		int[][] jobs = new int[n][3];
		for (int i = 0; i < n; i++) {
			jobs[i] = new int[] { startTime[i], endTime[i], profit[i] };
		}
		Arrays.sort(jobs, (a, b) -> a[1] - b[1]);

		for (int[] j : jobs) {
			System.out.println(Arrays.toString(j));
		}
		
		TreeMap<Integer, Integer> map = new TreeMap<>();
		map.put(0, 0);
		int maxProft = 0;
		for (int[] job : jobs) {
			int currProfit = map.floorEntry(job[0]).getValue() + job[2];
			if (currProfit > maxProft) {
				map.put(job[1], currProfit);
				maxProft = currProfit;
			}
		}
		return maxProft;

	}
}
