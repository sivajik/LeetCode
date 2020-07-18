package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Prob210_CourseScheduleII {

	public static void main(String[] args) {
/*		System.out.println(Arrays.toString(findOrder(4, new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } })));
		System.out.println(Arrays.toString(findOrder(2, new int[][] { { 1, 0 } })));
		System.out.println(Arrays.toString(findOrder(2, new int[][] { {} })));
		System.out.println(Arrays.toString(findOrder(4, new int[][] { {} })));
		System.out.println(Arrays.toString(findOrder(1, new int[][] { {} })));
		System.out.println(Arrays.toString(findOrder(4, null)));
*/		System.out.println(Arrays.toString(findOrder(2, new int[][] { { 0,1 }, {1,0} })));

	}

	static public int[] findOrder(int numCourses, int[][] prerequisites) {
		if (prerequisites == null) {
			// return new int[] {};
			prerequisites = new int[][] {};
		}

		List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) {
			adjList.add(new ArrayList<>());
		}

		if (prerequisites.length >= 1) {
			for (int[] eachEdge : prerequisites) {
				if (eachEdge.length == 2) {
					adjList.get(eachEdge[1]).add(eachEdge[0]);
				}
			}
		}

		Queue<Integer> q = new LinkedList<>();
		int[] degrees = new int[numCourses];

		for (int i = 0; i < numCourses; i++) {
			for (int eachNode : adjList.get(i)) {
				degrees[eachNode] += 1;
			}
		}
		for (int i = 0; i < numCourses; i++) {
			if (degrees[i] == 0) {
				q.add(i);
			}
		}
		List<Integer> result = new ArrayList<>();
		int totalCoures = 0;
		while (!q.isEmpty()) {
			Integer leafNode = q.poll();
			result.add(leafNode);
			for (int adjOfLeafNode : adjList.get(leafNode)) {
				degrees[adjOfLeafNode] = degrees[adjOfLeafNode] - 1;
				if (degrees[adjOfLeafNode] == 0) {
					q.add(adjOfLeafNode);
				}
			}
			totalCoures++;
		}
		if (totalCoures != numCourses) {
			return new int[0];
		} else {
			int[] res = new int[numCourses];
			for (int i = 0; i < result.size(); i++) {
				res[i] = result.get(i);
			}
			return res;
		}

	}
}
