package leetcode.revision.week03;

import java.util.*;

public class P210_CourseSchedule2 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(findOrder(4, new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } })));
		System.out.println(Arrays.toString(findOrder(2, new int[][] { { 1, 0 } })));

		System.out.println(Arrays.toString(findOrder(2, new int[][] { {} })));
		System.out.println(Arrays.toString(findOrder(4, new int[][] { {} })));
		System.out.println(Arrays.toString(findOrder(1, new int[][] { {} })));
		System.out.println(Arrays.toString(findOrder(4, null)));

		System.out.println(Arrays.toString(findOrder(2, new int[][] { { 0, 1 }, { 1, 0 } })));
	}

	static public int[] findOrder(int numCourses, int[][] prerequisites) {
		if (prerequisites == null) {
			prerequisites = new int[][] {};
		}

		List<List<Integer>> adjList = new ArrayList<>();

		// make adj list
		for (int i = 0; i < numCourses; i++) {
			adjList.add(new ArrayList<>());
		}

		for (int[] eachPrereq : prerequisites) {
			if (eachPrereq.length == 2) {
				adjList.get(eachPrereq[1]).add(eachPrereq[0]);
			}
		}

		// calcualte inbound edge count
		int[] inbounds = new int[numCourses];
		for (int i = 0; i < numCourses; i++) {
			for (int eachAdjVert : adjList.get(i)) {
				inbounds[eachAdjVert]++;
			}
		}

		// dfs from zero
		Queue<Integer> q = new LinkedList<>();

		for (int i = 0; i < inbounds.length; i++) {
			if (inbounds[i] == 0) {
				q.add(i);
			}
		}

		int processed = 0;
		List<Integer> topSort = new ArrayList<>();

		while (!q.isEmpty()) {
			Integer vertex = q.poll();
			topSort.add(vertex);
			for (int eachAdjVertex : adjList.get(vertex)) {
				inbounds[eachAdjVertex]--;
				if (inbounds[eachAdjVertex] == 0) {
					q.add(eachAdjVertex);
				}
			}
			processed++;
		}

		if (processed == numCourses) {
			int[] res = new int[topSort.size()];
			for (int i = 0; i < res.length; i++) {
				res[i] = topSort.get(i);
			}
			return res;
		} else {
			return new int[] {};
		}
	}
}
