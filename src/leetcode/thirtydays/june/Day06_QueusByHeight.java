package leetcode.thirtydays.june;

public class Day06_QueusByHeight {

	public static void main(String[] args) {
		int[][] r = reconstructQueue(new int[][] { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } });
		for (int[] p : r) {
			if (p != null) {
				System.out.println(java.util.Arrays.toString(p));
			}
		}
	}
	/*
	 * Input: [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
	 * 
	 * Output: [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
	 */
	static public int[][] reconstructQueue(int[][] people) {
		java.util.Arrays.sort(people, new java.util.Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return -o1[0] + o2[0];
			}
		});
		
		java.util.List<int[]> list = new java.util.LinkedList<int[]>();
		
		for (int[] p : people) {
			// System.out.println("Seting: " + p[1] + " at " + p[0]);
			list.add(p[1], p);
		}
		return list.toArray(new int[list.size()][]);
	}
}
