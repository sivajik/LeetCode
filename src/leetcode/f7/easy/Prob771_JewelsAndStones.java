package leetcode.f7.easy;

public class Prob771_JewelsAndStones {

	public static void main(String[] args) {
		System.out.println(numJewelsInStones("aA", "aAAbbbb"));
		System.out.println(numJewelsInStones("z", "ZZ"));
	}

	static public int numJewelsInStones(String jewels, String stones) {
		int c = 0;
		for (char ch : stones.toCharArray()) {
			if (jewels.indexOf(ch) != -1) {
				c++;
			}
		}
		return c;
	}
}
