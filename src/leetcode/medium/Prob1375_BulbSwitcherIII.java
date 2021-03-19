package leetcode.medium;

public class Prob1375_BulbSwitcherIII {

	public static void main(String[] args) {
		System.out.println(numTimesAllBlue(new int[] { 2, 1, 3, 5, 4 }) == 3);
		System.out.println(numTimesAllBlue(new int[] { 3, 2, 4, 1, 5 }) == 2);
		System.out.println(numTimesAllBlue(new int[] { 4, 1, 2, 3 }) == 1);
		System.out.println(numTimesAllBlue(new int[] { 2, 1, 4, 3, 6, 5 }) == 3);
		System.out.println(numTimesAllBlue(new int[] { 1, 2, 3, 4, 5, 6 }) == 6);
	}

	static public int numTimesAllBlue(int[] light) {
		int ans = 0, max = 0;
		for (int i = 0; i < light.length; ++i) {
			max = Math.max(max, light[i] - 1);
			if (max == i)
				ans++;
		}
		return ans;
	}
}
