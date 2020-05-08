package leetcode.thirtydays.may;

public class Day08_CheckStraightLine {

	public static void main(String[] args) {
		System.out
				.println(checkStraightLine(new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 6, 7 } }));
		System.out
				.println(checkStraightLine(new int[][] { { 1, 1 }, { 2, 2 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 7, 7 } }));

	}

	public static boolean checkStraightLine(int[][] coordinates) {
		int[] a = coordinates[1];
		int[] b = coordinates[0];
		float variant = getVariant(a, b);

		for (int i = 1; i < coordinates.length; i++) {
			int[] p1 = coordinates[i];
			int[] p2 = coordinates[0];
			float currVariant = getVariant(p1, p2);
			if (variant != currVariant)
				return false;
		}
		return true;
	}

	private static float getVariant(int[] a, int[] b) {
		if ((a[0] - b[0]) == 0)
			return 0;
		return (float) (b[1] - a[1]) / (b[0] - a[0]);
	}
}
