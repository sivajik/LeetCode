package leetcode.easy;

public class Prob997_TownJudge {

	public static void main(String[] args) {

		System.out.println(findJudge(2, new int[][] { { 1, 2 } }));
		System.out.println(findJudge(3, new int[][] { { 1, 3 }, { 2, 3 } }));
		System.out.println(findJudge(3, new int[][] { { 1, 3 }, { 2, 3 }, { 3, 1 } }));
		System.out.println(findJudge(3, new int[][] { { 1, 2 }, { 2, 3 } }));
		System.out.println(findJudge(4, new int[][] { { 1, 3 }, { 1, 4 }, { 2, 3 }, { 2, 4 }, { 4, 3 } }));
		System.out.println(
				findJudge(11, new int[][] { { 1, 8 }, { 1, 3 }, { 2, 8 }, { 2, 3 }, { 4, 8 }, { 4, 3 }, { 5, 8 },
						{ 5, 3 }, { 6, 8 }, { 6, 3 }, { 7, 8 }, { 7, 3 }, { 9, 8 }, { 9, 3 }, { 11, 8 }, { 11, 3 } }));
	}

	public static int findJudge(int N, int[][] trust) {
		java.util.Map<Integer, java.util.List<Integer>> map = new java.util.HashMap<>();

		for (int[] pair : trust) {
			int a = pair[0];
			int b = pair[1];

			if (map.containsKey(a)) {
				java.util.List<Integer> l = map.get(a);
				l.add(b);
				map.put(a, l);
			} else {
				java.util.List<Integer> l = new java.util.ArrayList<>();
				l.add(b);
				map.put(a, l);
			}
		}

		// ensure all other parties are there in map except the 'missing' one.
		if (map.size() != N - 1) {
			return -1;
		}

		int missing = -1;
		for (int i = 1; i <= N; i++) {
			if (!map.containsKey(i)) {
				missing = i;
				break;
			}
		}
		// all keys exists means judge is not there.
		if (missing == -1) {
			return -1;
		} else {
			// 'missing' is the judge. ensure all values has him as a common.
			for (java.util.Map.Entry<Integer, java.util.List<Integer>> entry : map.entrySet()) {
				java.util.List<Integer> l = entry.getValue();
				if (!l.contains(missing)) {
					return -1;
				}
			}
			return missing;
		}
	}
}