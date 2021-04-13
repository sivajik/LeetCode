package leetcode.medium;

public class Prob849_MaximizeDistancetoClosestPerson {

	public static void main(String[] args) {
		System.out.println(maxDistToClosest(new int[] { 1, 0, 0, 0, 1, 0, 1 }));

	}

	static public int maxDistToClosest(int[] seats) {
		int i = 0;
		int n = seats.length;
		int left = -1, right = -1;
		int dist = 0;
		while (i < n) {
			while (i < n && seats[i] == 1) {
				i++;
			}
			left = i;

			while (i < n && seats[i] == 0) {
				i++;
			}
			right = i;

			if (left == 0 || right == n) {
				dist = Math.max(dist, right - left);
			} else {
				dist = Math.max((int) Math.ceil((right - left) / 2.0), dist);
			}
		}
		return dist;
	}
}
