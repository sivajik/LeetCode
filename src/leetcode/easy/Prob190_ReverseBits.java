package leetcode.easy;

public class Prob190_ReverseBits {

	public static void main(String[] args) {
		System.out.println(reverseBits(4));
	}

	static public int reverseBits(int n) {
		int ans = 0;
		for (int i = 0; i < 32; i++) {
			ans <<= 1;
			ans = ans | (n & 1);
			n >>= 1;
		}
		return ans;
	}
}
