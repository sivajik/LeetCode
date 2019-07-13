package leetcode.easy;

public class Prob504_Base7 {

	public static void main(String[] args) {
		System.out.println(convertToBase7(100));
	}
    public static String convertToBase7(int num) {
        return Integer.toString(num, 7);
    }
}
