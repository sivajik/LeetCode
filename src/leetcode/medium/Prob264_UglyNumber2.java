package leetcode.medium;

public class Prob264_UglyNumber2 {

	public static void main(String[] args) {
		for (int i = 1; i <= 1690; i++) {
			System.out.println(nthUglyNumber(i));
		}
	}

	static public int nthUglyNumber(int n) {
		int[] uglyNumbers = new int[n + 1];
		uglyNumbers[0] = 1;

		int uglyNum;

		int mult2 = 2;
		int mult3 = 3;
		int mult5 = 5;

		int cntr2 = 0, cntr3 = 0, cntr5 = 0;

		for (int i = 1; i <= n; i++) {
			uglyNum = Math.min(mult2, Math.min(mult3, mult5));
			uglyNumbers[i] = uglyNum;

			if (uglyNum == mult2) {
				cntr2++;
				mult2 = uglyNumbers[cntr2] * 2;
			}
			if (uglyNum == mult3) {
				cntr3++;
				mult3 = uglyNumbers[cntr3] * 3;
			}
			if (uglyNum == mult5) {
				cntr5++;
				mult5 = uglyNumbers[cntr5] * 5;
			}

		}
		return uglyNumbers[n - 1];
	}
}
