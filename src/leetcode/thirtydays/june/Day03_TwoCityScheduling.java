package leetcode.thirtydays.june;

public class Day03_TwoCityScheduling {

	public static void main(String[] args) {
		System.out.println(twoCitySchedCost(new int[][] { { 10, 20 }, { 30, 200 }, { 400, 50 }, { 30, 20 } }));
	}

	static public int twoCitySchedCost(int[][] costs) {
		int ans = 0;
		java.util.Arrays.sort(costs, new java.util.Comparator<int[]>() {

			@Override
			public int compare(int[] a, int[] b) {
				return (a[0] - a[1]) - (b[0] - b[1]);
			}
		});
		for (int i = 0; i < costs.length; i++) {
			if (i < costs.length / 2) {
				ans += costs[i][0];
			} else {
				ans += costs[i][1];
			}
		}
		return ans;
	}
}
