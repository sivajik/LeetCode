package leetcode.easy;

public class Prob1374_StringOddCounts {

	public static void main(String[] args) {
		System.out.println(generateTheString(3));
		System.out.println(generateTheString(2));
		System.out.println(generateTheString(4));
		System.out.println(generateTheString(7));
	}

	public static String generateTheString(int n) {
		StringBuilder sb = new StringBuilder();
		if (n % 2 == 0) {
			for (int i = 0; i < n - 1; i++) {
				sb.append('a');
			}
			sb.append('b');
		} else {
			for (int i = 0; i < n; i++) {
				sb.append('a');
			}
		}
		return sb.toString();
	}
}
