package leetcode.medium;

public class Prob547_FriendCircles {

	public static void main(String[] args) {
		System.out.println(findCircleNum(new int[][] { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } }));
		System.out.println();
		// System.out.println(findCircleNum(new int[][] { { 1, 1, 0 }, { 1, 1, 1 }, { 0,
		// 1, 1 } }));
	}

	static public int findCircleNum(int[][] M) {
		int vertexCount = M.length;
		// handle validations.
		if (vertexCount == 0) {
			return 0;
		}
		if (M[0].length == 0) {
			return 0;
		}

		int[] parents = new int[vertexCount];
		for (int i = 0; i < vertexCount; i++) {
			parents[i] = i;
		}

		for (int i = 0; i < vertexCount; i++) {
			for (int j = 0; j < M[i].length; j++) {
				if (M[i][j] == 1) {
					// System.out.print("Friending between: " + i + " , " + j);
					union(parents, i, j);
					// System.out.println(java.util.Arrays.toString(parents));
				}
			}
		}

		java.util.Set<Integer> set = new java.util.HashSet<Integer>();
		for (int i = 0; i < vertexCount; i++) {
			set.add(find(parents, i));
		}
		// System.out.println("Total Circles are: " + set.size());
		return set.size();
	}

	static int find(int[] parents, int i) {
		if (parents[i] == i) {
			return i;
		} else {
			int temp = find(parents, parents[i]);
			parents[i] = temp;
			return parents[i];
		}
	}

	static void union(int[] parents, int i, int j) {
		int iParent = find(parents, i);
		int jParent = find(parents, j);
		parents[iParent] = jParent;
	}
}
