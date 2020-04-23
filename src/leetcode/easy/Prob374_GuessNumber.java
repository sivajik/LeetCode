package leetcode.easy;

public class Prob374_GuessNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int guessNumber(int n) {
		int left = 1;
		int right = n;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (guess(mid) == 0) {
				return mid;
			} else if (guess(mid) == -1) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}

	static int guess(int num) {
		return -1;
	}
}
