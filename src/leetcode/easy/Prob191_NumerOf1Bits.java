package leetcode.easy;

public class Prob191_NumerOf1Bits {

	public static void main(String[] args) {
		System.out.println(hammingWeight(00000000000000000000000000001011));
		System.out.println(hammingWeight(00000000000000000000000010000000));
	}

	public static int hammingWeight(int n) {
		return Integer.bitCount(n);
		// String s = Integer.toBinaryString(n);
		// return (int) s.chars().filter(x -> x == '1').count();
	}
}
