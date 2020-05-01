package leetcode.thirtydays.may;

public class Day01_FirstBadVersion {
	public static void main(String[] args) throws Exception {
		System.out.println(firstBadVersion(10));
	}

	public static int firstBadVersion(int n) {
		int left = 0;
		int right = n;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (isBadVersion(mid)) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

	public static boolean isBadVersion(int version) {
		if (version >= 4) {
			return true;
		}
		return false;
	}
}
