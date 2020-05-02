package leetcode.thirtydays.may;

public class Day02_JewelsAndStones {

	public static void main(String[] args) {
		System.out.println(numJewelsInStones("aA", "aAAbbbb"));

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
