package leetcode.thirtydays.july;

public class Day05_HammingDistance {

	public static void main(String[] args) {
		System.out.println(hammingDistance(1, 1));
		System.out.println(hammingDistance(1, 2));
	}
    static public int hammingDistance(int x, int y) {
        int xor = x ^ y;
		String s1 = Integer.toBinaryString(xor);
		return (int) s1.chars().filter(c -> c == '1').count();
    }
}
