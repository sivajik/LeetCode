package leetcode.thirtydays.april;

public class Day14_PerformStringShifts {

	public static void main(String[] args) {
		System.out.println(stringShift("abc", new int[][] { { 0, 1 }, { 1, 2 } }));
		System.out.println(stringShift("abcdefg", new int[][] { { 1, 1 }, { 1, 1 }, { 0, 2 }, { 1, 3 } }));
		System.out.println(stringShift("abcdefg", new int[][] { { 1, 3 } }));
		System.out.println(stringShift("abcdefg", new int[][] { { 0, 3 } }));
		System.out.println(stringShift("abcdefg", new int[][] { { 0, 3 }, { 1, 3 } }));
		System.out.println(stringShift("abcdefg", new int[][] { { 0, 7 } }));
		System.out.println(stringShift("yisxjwry",
				new int[][] { { 1, 8 }, { 1, 4 }, { 1, 3 }, { 1, 6 }, { 0, 6 }, { 1, 4 }, { 0, 2 }, { 0, 1 } }));
	}

	public static String stringShift(String s, int[][] shift) {
		int[] requiredShifts = countTotalShifts(shift);
		if (requiredShifts[0] == -999) {
			return s;
		} else {
			int direction = requiredShifts[0];
			int times = requiredShifts[1] % s.length();
			if (direction == 0) {
				// left
				String x = s.substring(0, times);
				String y = s.substring(times);
				return y + x;

			} else {
				// right
				String x = s.substring(s.length() - times);
				String y = s.substring(0, s.length() - times);
				return x + y;
			}
		}
	}

	public static int[] countTotalShifts(int[][] shift) {
		int leftShifts = 0;
		int rightShifts = 0;

		for (int[] eachShift : shift) {
			if (eachShift[0] == 0) {
				leftShifts += eachShift[1];
			} else if (eachShift[0] == 1) {
				rightShifts += eachShift[1];
			}
		}
		if (leftShifts == rightShifts) {
			return new int[] { -999, -999 }; //relax!!! no action needed.
		} else if (leftShifts > rightShifts) {
			return new int[] { 0, leftShifts - rightShifts };
		} else {
			return new int[] { 1, rightShifts - leftShifts };
		}
	}
}
