package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Prob1376_TimeNeededtoInformAllEmployees {

	public static void main(String[] args) {
		System.out.println(numOfMinutes(7, 6, new int[] { 1, 2, 3, 4, 5, 6, -1 }, new int[] { 0, 6, 5, 4, 3, 2, 1 }));
	}

	static int max = Integer.MIN_VALUE;
	static HashMap<Integer, List<Integer>> org = new HashMap<>();

	static public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
		buildTree(n, manager);
		search(headID, informTime[headID], informTime);
		return max;
	}

	private static void search(int headId, int time, int[] informTime) {
		max = Math.max(max, time);

		if (org.containsKey(headId)) {
			for (Integer eachSubOrdinate : org.get(headId)) {
				search(eachSubOrdinate, time + informTime[eachSubOrdinate], informTime);
			}
		}

	}

	private static void buildTree(int n, int[] manager) {
		for (int i = 0; i < n; i++) {
			if (!org.containsKey(manager[i])) {
				org.put(manager[i], new ArrayList<>());
			}
			org.get(manager[i]).add(i);
		}
	}
}
