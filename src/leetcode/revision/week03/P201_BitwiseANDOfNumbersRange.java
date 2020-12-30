package leetcode.revision.week03;

public class P201_BitwiseANDOfNumbersRange {

	public static void main(String[] args) {
		System.out.println(rangeBitwiseAnd(9, 12));

	}

	static public int rangeBitwiseAnd(int m, int n) {
		while (m < n) {
			n = n & (n-1);
			System.out.println(n);
		}
		return n;
	}
}
