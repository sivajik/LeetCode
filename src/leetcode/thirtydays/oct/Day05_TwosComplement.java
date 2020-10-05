package leetcode.thirtydays.oct;

public class Day05_TwosComplement {

	public static void main(String[] args) {
		System.out.println(findComplement(5));
	}
	static public int findComplement(int num) {
    	String s = Integer.toBinaryString(num);
    	s = s.replace('1', 'x');
    	s = s.replace('0', '1');
    	s = s.replace('x', '0');
    	return Integer.parseInt(s, 2);
    }
}
