package leetcode.thirtydays.august;

public class Day10_ExcelSheetNumber {

	public static void main(String[] args) {
		System.out.println(titleToNumber("AB"));

	}
    static public int titleToNumber(String s) {
        char[] t = s.toCharArray();
		int res = 0;
		for (int i = t.length - 1, j = 0; i >= 0; i--, j++) {
			int temp = (int) (Math.pow(26, j) * (t[i] - 'A' + 1));
			res += temp;
		}
		return res;
    }
}
