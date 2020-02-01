package leetcode.easy;

public class Prob1323_Maximum69Number {

	public static void main(String[] args) {
		System.out.println(maximum69Number(9669));
		System.out.println(maximum69Number(9996));
	}

	public static int maximum69Number(int num) {
		String s = String.valueOf(num);
		char[] charArray = s.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] == '6') {
				charArray[i] = '9';
				break;
			}
		}
		return Integer.parseInt(new String(charArray));
	}
}
