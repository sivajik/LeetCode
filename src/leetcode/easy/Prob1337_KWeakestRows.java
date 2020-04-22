package leetcode.easy;

public class Prob1337_KWeakestRows {

	public static void main(String[] args) {
		System.out.println(java.util.Arrays.toString(kWeakestRows(new int[][] { { 1, 1, 0, 0, 0 }, { 1, 1, 1, 1, 0 },
				{ 1, 0, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 1, 1, 1, 1, 1 } }, 3)));

		System.out.println(java.util.Arrays.toString(
				kWeakestRows(new int[][] { { 1, 0, 0, 0 }, { 1, 1, 1, 1 }, { 1, 0, 0, 0 }, { 1, 0, 0, 0 } }, 2)));

		System.out.println(java.util.Arrays.toString(kWeakestRows(new int[][] { { 1, 0 }, { 0, 0 }, { 1, 0 } }, 2)));
	}

	static class IndexAndCount {
		int index;
		int count;

		IndexAndCount(int index, int count) {
			this.index = index;
			this.count = count;
		}

		public String toString() {
			return "Index: " + index + " Count: " + count;
		}
	}

	public static int[] kWeakestRows(int[][] mat, int k) {
		int[] result = new int[k];
		java.util.PriorityQueue<IndexAndCount> pq = new java.util.PriorityQueue<IndexAndCount>(
				new java.util.Comparator<IndexAndCount>() {

					@Override
					public int compare(IndexAndCount o1, IndexAndCount o2) {
						if (o1.count == o2.count) {
							if (o1.index < o2.index) {
								return -1;
							} else {
								return +1;
							}
						} else {
							return o1.count - o2.count;
						}
					}
				});

		for (int i = 0; i < mat.length; i++) {

			int left = 0;
			int right = mat[i].length - 1;
			int mid = -1;
			int lastFoundMidPost = -1;
			while (left <= right) {
				mid = left + (right - left) / 2;
				if (mat[i][mid] == 1) {
					left = mid + 1;
					lastFoundMidPost = mid;
				} else {
					right = mid - 1;
				}
			}

			if (lastFoundMidPost != -1) {
				// System.out.println("Found: " + (lastFoundMidPost + 1));
				pq.add(new IndexAndCount(i, lastFoundMidPost + 1));
			} else {
				pq.add(new IndexAndCount(i, 0));
			}
		}

		for (int i = 0; i < k; i++) {
			result[i] = pq.remove().index;
		}
		return result;
	}
}
