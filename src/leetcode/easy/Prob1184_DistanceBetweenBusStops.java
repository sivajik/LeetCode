package leetcode.easy;

public class Prob1184_DistanceBetweenBusStops {

	public static void main(String[] args) {
		System.out.println(distanceBetweenBusStops(new int[] { 1, 2, 3, 4 }, 0, 1));
		System.out.println(distanceBetweenBusStops(new int[] { 1, 2, 3, 4 }, 0, 2));
		System.out.println(distanceBetweenBusStops(new int[] { 1, 2, 3, 4 }, 0, 3));
	}

	static public int distanceBetweenBusStops(int[] distance, int start, int destination) {
		int s = start, d = destination;
		if (start > destination) {
			s = destination;
			d = start;
		}

		int totalCircleLen = 0;
		for (int i : distance) {
			totalCircleLen += i;
		}
		int stripLen = 0;
		for (int i = s; i < d; i++) {
			stripLen += distance[i];
		}
		return Math.min(stripLen, totalCircleLen - stripLen);
	}
}
