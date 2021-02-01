package leetcode.thirtydays.feb;

public class P01_NumberOfBits {

	public static void main(String[] args) {
		System.out.println(hammingWeight(11));

	}

	static public int hammingWeight(int n) {
		int counter = 0;
		int mask = 1;
		for (int i = 0; i < 32; i++) {
			if ((mask & n) != 0) {
				counter++;
			}
			mask = mask << 1;
		}
		return counter;
	}
}
