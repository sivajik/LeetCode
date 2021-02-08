package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Prob1557MinimumNumberVerticesReachAllNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
		boolean[] indegree = new boolean[n];
		for (List<Integer> l : edges) {
			indegree[l.get(1)] = true;// ++;
		}

		List<Integer> op = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (!indegree[i]) {
				op.add(i);
			}
		}
		return op;
	}
}
