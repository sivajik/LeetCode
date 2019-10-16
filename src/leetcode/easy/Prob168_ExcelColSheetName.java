package leetcode.easy;

public class Prob168_ExcelColSheetName {

	public static void main(String[] args) {
		System.out.println(convertToTitle(2));
		System.out.println(convertToTitle(27));
		System.out.println(convertToTitle(28));
		System.out.println(convertToTitle(701));
	}

	public static String convertToTitle(int n) {
		String result = "";
		while (n > 0) {
			n = n - 1;
			int x = n % 26;
			n = n / 26;
			char c = (char) (x + 'A');
			result = c + result;
		}
		return result;
	}
}
