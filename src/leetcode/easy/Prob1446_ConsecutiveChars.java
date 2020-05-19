package leetcode.easy;

public class Prob1446_ConsecutiveChars {

	public static void main(String[] args) {
		System.out.println(maxPower("leetcode"));
		System.out.println(maxPower("abbcccddddeeeeedcba"));
		System.out.println(maxPower("triplepillooooow"));
		System.out.println(maxPower("hooraaaaaaaaaaay"));
		System.out.println(maxPower("tourist"));

	}

	public static int maxPower(String s) {
		if (s.length() == 1) {
			return 1;
		}

		int max = Integer.MIN_VALUE;
		char[] c = s.toCharArray();
		char prev = c[0];
		int cCount = 1;
		for (int i = 1; i < c.length; i++) {
			if (c[i] == prev) {
				cCount++;
				if (cCount > max) {
					max = cCount;
				}
			} else {
				cCount = 1;
				prev = c[i];
			}
		}
		return max == Integer.MIN_VALUE ? 1 : max;
	}
}
