package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class Prob1466_ReorderRoutesToMakeAllPathsLeadtotheCityZero {

	public static void main(String[] args) {
		System.out.println(minReorder(6, new int[][] { { 0, 1 }, { 1, 3 }, { 2, 3 }, { 4, 0 }, { 4, 5 } }));
	}

	static public int minReorder(int n, int[][] connections) {
		// [0,1],[1,3],[2,3],[4,0],[4,5]
		Set<Integer> canReachZeros = new HashSet<>();
		canReachZeros.add(0); // this is key

		for (int[] eachConn : connections) {
			if (eachConn[1] == 0) {
				canReachZeros.add(eachConn[0]);
			}
		}

		int count = 0;
		// 4 - is only in set
		while (canReachZeros.size() < n) {
			for (int i = 0; i < connections.length; i++) {
				int[] temp = connections[i];
				// 4 5 OR 0 1
				if (canReachZeros.contains(temp[0]) && !canReachZeros.contains(temp[1])) {
					// reverse the edge and add
					canReachZeros.add(temp[1]);
					count++;
				} else if (!canReachZeros.contains(temp[0]) && canReachZeros.contains(temp[1])) {
					// 2 3 (after adding 0 1 3)
					canReachZeros.add(temp[0]);
				}
			}
		}
		return count;
	}
}
