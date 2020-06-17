package leetcode.medium;

public class Prob743_NetworkDelayTime {

	public static void main(String[] args) {
		System.out.println(networkDelayTime(new int[][] { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } }, 4, 2));
	}

	// need to find max path from K - that's all.
	static public int networkDelayTime(int[][] times, int N, int K) {
		int[] dist = new int[N + 1];
		java.util.Arrays.fill(dist, Integer.MAX_VALUE);
		dist[K] = 0;

		// start travelling to each node.
		for (int i = 1; i < N; i++) {
			for (int[] eachEntry : times) {
				int u = eachEntry[0];
				int v = eachEntry[1];
				int w = eachEntry[2];

				if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
					dist[v] = dist[u] + w;
				}
			}
		}

		// Find max of all values.
		int maxTime = Integer.MIN_VALUE;
		for (int i = 1; i < dist.length; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				return -1;
			} else {
				maxTime = Math.max(maxTime, dist[i]);
			}
		}
		return maxTime;
	}
}
