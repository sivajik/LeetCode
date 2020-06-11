package leetcode.medium;

public class Prob841_KeysAndRooms {

	public static void main(String[] args) {
		java.util.List<java.util.List<Integer>> rooms = new java.util.ArrayList<>();
		// int[][] data = new int[][] { { 1, 3 }, { 3, 0, 1 }, { 2 }, { 0 } };
		// int[][] data = new int[][] { { 1 }, { 2 }, { 3 }, {} };
		int[][] data = new int[][] { {}, {}, {}, {} };
		for (int[] dataEle : data) {
			java.util.List<Integer> l = new java.util.ArrayList<>();
			for (int ele : dataEle) {
				l.add(ele);
			}
			rooms.add(l);
		}
		boolean res = canVisitAllRooms(rooms);
		System.out.println(res);
	}

	static public boolean canVisitAllRooms(java.util.List<java.util.List<Integer>> rooms) {
		int vertexCount = rooms.size(); // say 4; 0 1 2 3

		boolean[] visited = new boolean[vertexCount];

		DFSUtil(0, visited, rooms);

		for (int i = 0; i < vertexCount; i++) {
			if (visited[i] == false) {
				return false;
			}
		}
		return true;
	}

	private static void DFSUtil(int i, boolean[] visited, java.util.List<java.util.List<Integer>> rooms) {
		visited[i] = true;

		for (int eachAdjVer : rooms.get(i)) {
			if (visited[eachAdjVer] == false) {
				DFSUtil(eachAdjVer, visited, rooms);
			}
		}

	}
}
