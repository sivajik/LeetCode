package leetcode.easy;

public class Prob1266_MinTimeVistingAllPoints {

	public static void main(String[] args) {
		System.out.println(minTimeToVisitAllPoints(new int[][] { { 1, 1 }, { 3, 4 }, { -1, 0 } }));
		System.out.println(minTimeToVisitAllPoints(new int[][] { { 3, 2 }, { -2, 2 } }));
	}

	public static int minTimeToVisitAllPoints(int[][] points) {
		int time = 0;
		for (int i = 0; i < points.length - 1; i++) {
			time += getTime(points[i], points[i + 1]);
		}
		return time;
	}

	private static int getTime(int[] is, int[] is2) {
		int xDist = Math.abs(is[0] - is2[0]);
		int yDist = Math.abs(is[1] - is2[1]);
		return Math.max(xDist, yDist);
	}
}
