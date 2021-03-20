package leetcode.medium;

public class Prob1306_JumpGameIII {

	public static void main(String[] args) {

		System.out.println(canReach(new int[] { 4, 2, 3, 0, 3, 1, 2 }, 5));
		System.out.println(canReach(new int[] { 4, 2, 3, 0, 3, 1, 2 }, 0));
		System.out.println(canReach(new int[] { 3, 0, 2, 1, 2 }, 0));

		System.out.println(canReach(new int[] { 4, 4, 1, 3, 0, 3 }, 2));
	}

	static public boolean canReach(int[] arr, int start) {
		boolean[] visited = new boolean[arr.length];
		boolean res = dfs(arr, start, visited);
		return res;
	}

	private static boolean dfs(int[] arr, int currIndex, boolean[] visited) {
		if (currIndex < 0 || currIndex >= arr.length) {
			return false;
		}

		if (visited[currIndex] == true) {
			return false;
		}

		if (arr[currIndex] == 0) {
			return true;
		}

		visited[currIndex] = true;
		return dfs(arr, currIndex - arr[currIndex], visited) || dfs(arr, currIndex + arr[currIndex], visited);
	}
}
