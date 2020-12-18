package leetcode.revision.week02;

import java.util.HashSet;
import java.util.Set;

public class P547_FriendCircles {

	public static void main(String[] args) {
		System.out.println(findCircleNum(new int[][] { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } }));

	}

	static public int findCircleNum(int[][] m) {
		if (m == null || m[0].length == 0) {
			return 0;
		}

		int totalFriendsCount = m.length;

		int[] parents = new int[totalFriendsCount];
		for (int i = 0; i < totalFriendsCount; i++) {
			parents[i] = i;
		}

		for (int eachFriend = 0; eachFriend < totalFriendsCount; eachFriend++) {
			for (int j = 0; j < m[eachFriend].length; j++) {
				if (m[eachFriend][j] == 1) {
					union(eachFriend, j, parents);
				}
			}
		}

		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < totalFriendsCount; i++) {
			set.add(find(parents, i));
		}
		return set.size();
	}

	static private void union(int i, int j, int[] parents) {
		int ithParent = find(parents, i);
		int jthParent = find(parents, j);
		parents[ithParent] = jthParent;
	}

	static private int find(int[] parents, int i) {
		if (parents[i] == i) {
			return i;
		} else {
			int par = find(parents, parents[i]);
			parents[i] = par;
			return par;
		}
	}
}
