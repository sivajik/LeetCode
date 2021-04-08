package leetcode.easy;

public class Prob788_RotatedDigits {

	public static void main(String[] args) {
		System.out.println(rotatedDigits(10));
	}

	static public int rotatedDigits(int N) {
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (isGood(i, false)) {
				cnt++;
			}
		}
		return cnt;
	}

	private static boolean isGood(int i, boolean flag) {
		if (i == 0) {
			return flag;
		}

		int num = i % 10;
		if (num == 3 || num == 4 || num == 7) {
			return false;
		}
		if (num == 0 || num == 1 || num == 8) {
			return isGood(i / 10, flag);
		}
		return isGood(i / 10, true);
	}
}
