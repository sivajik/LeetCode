package leetcode.medium;

public class Prob1615_MaximalNetworkRank {

	public static void main(String[] args) {
		System.out.println(maximalNetworkRank(4, new int[][] { { 0, 1 }, { 0, 3 }, { 1, 2 }, { 1, 3 } }));
	}

	static public int maximalNetworkRank(int n, int[][] roads) {
		int[] numRoadsConnCity = new int[100 + 1];
		boolean[][] roadsExist = new boolean[n][n];

		for (int[] eachPair : roads) {
			numRoadsConnCity[eachPair[0]]++;
			numRoadsConnCity[eachPair[1]]++;

			roadsExist[eachPair[0]][eachPair[1]] = true;
			roadsExist[eachPair[1]][eachPair[0]] = true;
		}

		int maxRank = 0;

		for (int i = 0; i < n - 1; i++) { // do until n-1 as j starts from i+1
			for (int j = i + 1; j < n; j++) {
				int rank = numRoadsConnCity[i] + numRoadsConnCity[j];
				if (roadsExist[i][j]) {
					rank = rank - 1;
				}
				maxRank = Math.max(rank, maxRank);
			}
		}

		return maxRank;
	}
}
