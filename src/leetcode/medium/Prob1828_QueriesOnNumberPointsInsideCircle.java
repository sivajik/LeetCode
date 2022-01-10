package leetcode.medium;

import java.util.Arrays;

public class Prob1828_QueriesOnNumberPointsInsideCircle {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(countPoints(new int[][] { { 1, 3 }, { 3, 3 }, { 5, 3 }, { 2, 2 } },
				new int[][] { { 2, 3, 1 }, { 4, 3, 1 }, { 1, 1, 2 } })));

		System.out.println(Arrays.toString(countPoints(new int[][] { { 1, 1 }, { 2, 2 }, { 3, 3 }, { 4, 4 }, { 5, 5 } },
				new int[][] { { 1, 2, 2 }, { 2, 2, 2 }, { 4, 3, 2 }, { 4, 3, 3 } })));
	}

	static public int[] countPoints(int[][] points, int[][] queries) {
		int[] result = new int[queries.length];
		int index = 0;

		for (int[] eachQry : queries) {
			int dist = eachQry[2];

			for (int[] eachPoint : points) {
				double d = ((eachPoint[0] - eachQry[0]) * (eachPoint[0] - eachQry[0])) + ((eachPoint[1] - eachQry[1]) * (eachPoint[1] - eachQry[1])) ;//distBetween(new int[] { eachQry[0], eachQry[1] }, eachPoint);
				if (d <= dist * dist) {
					result[index]++;
				}
			}
			index++;
		}
		return result;
	}
}