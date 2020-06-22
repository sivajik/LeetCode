package leetcode.easy;

public class Prob1486_XOROperationInArray {

	public static void main(String[] args) {
		System.out.println(xorOperation(5, 0) == 8);
		System.out.println(xorOperation(4, 3) == 8);
		System.out.println(xorOperation(1, 7) == 7);
		System.out.println(xorOperation(10, 5) == 2);
	}

	static public int xorOperation(int n, int start) {
		int res = 0;

		for (int i = 0; i < n; i++) {
			res = res ^ (start + (2 * i));
		}

		return res;
	}
}
