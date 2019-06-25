package leetcode.easy;

public class Prob771_JewelsAndStones {
	public static void main(String[] args) throws Exception {
		System.out.println(numJewelsInStones("aA", "aAAbbbb"));
		System.out.println(numJewelsInStones("z", "ZZ"));
	}

	public static int numJewelsInStones(String J, String S) {
		int count = 0;
		for (char c : S.toCharArray()) {
			if (J.indexOf(c) != -1) {
				count++;
			}
		}
		return count;
	}
}
