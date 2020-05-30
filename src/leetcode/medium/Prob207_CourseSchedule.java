package leetcode.medium;

public class Prob207_CourseSchedule {

	public static void main(String[] args) {
		System.out.println(canFinish(2, new int[][] { { 1, 0 } }));
		System.out.println("--------------------");
		System.out.println(canFinish(2, new int[][] { { 1, 0 }, { 0, 1 } }));
		System.out.println("--------------------");
		System.out.println(canFinish(4, new int[][] { { 1, 0 }, { 2, 1 }, { 3, 2 }, { 0, 3 } }));
		System.out.println("--------------------");
	}

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		if (prerequisites.length == 0 || (prerequisites[0] != null && prerequisites[0].length == 0)) {
			return true;
		}

		java.util.ArrayList<java.util.ArrayList<Integer>> adj = new java.util.ArrayList<>();
		for (int i = 0; i < numCourses; i++) {
			adj.add(new java.util.ArrayList<>());
		}

		for (int[] deps : prerequisites) {
			adj.get(deps[1]).add(deps[0]);
		}

		// get the inbounds of each vertex
		int[] inbounds = new int[numCourses];
		for (int i = 0; i < numCourses; i++) {
			for (Integer adjVert : adj.get(i)) {
				inbounds[adjVert]++;
			}
		}

		// enqueue vertices with zero inbound.
		java.util.Queue<Integer> q = new java.util.LinkedList<>();
		for (int i = 0; i < inbounds.length; i++) {
			if (inbounds[i] == 0) {
				q.add(i);
			}
		}

		int totalverticesProcess = 0;
		java.util.List<Integer> topoSort = new java.util.ArrayList<>();

		while (!q.isEmpty()) {
			Integer vertex = q.poll();
			topoSort.add(vertex);

			for (int eachAdjVer : adj.get(vertex)) {
				inbounds[eachAdjVer]--;
				if (inbounds[eachAdjVer] == 0) {
					q.add(eachAdjVer);
				}
			}
			totalverticesProcess++;
		}

		if (totalverticesProcess != numCourses) {
			return false;
		} else {
			System.out.println(topoSort.toString());
			return true;
		}
	}


}
