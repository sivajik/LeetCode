package leetcode.revision.week03;

import java.util.ArrayList;
import java.util.List;

public class P207_CourseSchedule {

	public static void main(String[] args) {
		System.out.println(canFinish(2, new int[][] { { 1, 0 } }));
		System.out.println("--------------------");
		System.out.println(canFinish(2, new int[][] { { 1, 0 }, { 0, 1 } }));
		System.out.println("--------------------");
		System.out.println(canFinish(4, new int[][] { { 1, 0 }, { 2, 1 }, { 3, 2 }, { 0, 3 } }));
		System.out.println("--------------------");

	}

	static public boolean canFinish(int numCourses, int[][] prerequisites) {
		List<List<Integer>> adjList = new ArrayList<>();

		for (int i = 0; i < numCourses; i++) {
			adjList.add(new ArrayList<>());
		}

		for (int[] preReq : prerequisites) {
			adjList.get(preReq[1]).add(preReq[0]);
		}

		// calculate 'in-bounds' of each vertex.
		int[] inBounds = new int[numCourses];
		for (int i = 0; i < numCourses; i++) {
			for (Integer edge : adjList.get(i)) {
				inBounds[edge]++;
			}
		}

		java.util.Queue<Integer> q = new java.util.LinkedList<>();
		for (int i = 0; i < inBounds.length; i++) {
			if (inBounds[i] == 0) {
				q.add(i);
			}
		}

		java.util.List<Integer> topoSort = new java.util.ArrayList<>();
		int processed = 0;

		while (!q.isEmpty()) {
			Integer vertex = q.poll();
			topoSort.add(vertex);

			for (int eachAdjVert : adjList.get(vertex)) {
				inBounds[eachAdjVert]--;
				if (inBounds[eachAdjVert] == 0) {
					q.add(eachAdjVert);
				}
			}
			processed++;
		}

		if (processed == numCourses) {
			return true;
		}

		return false;
	}
}
