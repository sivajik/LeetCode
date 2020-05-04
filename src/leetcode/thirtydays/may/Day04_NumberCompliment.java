package leetcode.thirtydays.may;

public class Day04_NumberCompliment {

	public static void main(String[] args) {
		System.out.println(findComplement(5));
		System.out.println(findComplement(1));
	}

	public static int findComplement(int num) {
		String s = Integer.toBinaryString(num);
		s = s.replace('1', 'x');
		s = s.replace('0', '1');
		s = s.replace('x', '0');
		return Integer.parseInt(s, 2);
	}
}
