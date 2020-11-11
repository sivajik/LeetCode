package leetcode.thirtydays.nov;

public class Day11_ValidSquare {

	public static void main(String[] args) {
		System.out.println(validSquare(new int[] { 0, 0 }, new int[] { 0, 1 }, new int[] { 1, 0 }, new int[] { 1, 1 }));
	}

	static public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		return isValid(p1, p2, p3, p4) || isValid(p1, p2, p4, p3) || isValid(p1, p3, p2, p4) || isValid(p1, p3, p4, p2)
				|| isValid(p1, p4, p2, p3) || isValid(p1, p4, p3, p2);
	}

	static public boolean isValid(int[] p1, int[] p2, int[] p3, int[] p4) {
		int d12 = dist(p1, p2);
		int d23 = dist(p2, p3);
		int d34 = dist(p3, p4);
		int d41 = dist(p4, p1);

		int d13 = dist(p1, p3);
		int d24 = dist(p2, p4);

		return d12 > 0 && d23 > 0 && d34 > 0 && d41 > 0 && d12 == d23 && d23 == d34 && d34 == d41 && d41 == d12
				&& d13 == d24;
	}

	static public int dist(int[] a, int[] b) {
		int xDist = b[0] - a[0];
		int yDist = b[1] - a[1];
		return (xDist * xDist) + (yDist * yDist);
	}
}
