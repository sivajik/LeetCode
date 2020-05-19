package leetcode.easy;

public class Prob171_ExcelSheeet2Col {

	public static void main(String[] args) {
		System.out.println(titleToNumber("A"));
		System.out.println(titleToNumber("AB"));
		System.out.println(titleToNumber("ZY"));
	}

	public static int titleToNumber(String s) {
		char[] t = s.toCharArray();
		int res = 0;
		for (int i = t.length - 1, j = 0; i >= 0; i--, j++) {
			int temp = (int) (Math.pow(26, j) * (t[i] - 'A' + 1));
			res += temp;
		}
		return res;
	}
}