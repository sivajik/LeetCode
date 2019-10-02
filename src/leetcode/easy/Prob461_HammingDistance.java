package leetcode.easy;

public class Prob461_HammingDistance {

	public static void main(String[] args) {
		System.out.println(hammingDistance(1, 4));
		System.out.println(hammingDistance(Integer.MIN_VALUE, Integer.MAX_VALUE));
		System.out.println(hammingDistance(Integer.MAX_VALUE, Integer.MAX_VALUE));
		System.out.println(hammingDistance(Integer.MAX_VALUE, Integer.MIN_VALUE));
	}

	public static int hammingDistance(int x, int y) {
		int xor = x ^ y;
		String s1 = Integer.toBinaryString(xor);
		return (int) s1.chars().filter(c -> c == '1').count();
	}
}