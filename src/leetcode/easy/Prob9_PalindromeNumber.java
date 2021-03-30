package leetcode.easy;

public class Prob9_PalindromeNumber {

	public static void main(String[] args) {
		System.out.println(isPalindrome(121));

	}
	static  public boolean isPalindrome(int x) {
		int sum = 0;
		int rev = x;
		while (rev > 0) {
			sum = ((sum * 10) + (rev % 10));
			rev = rev/10;
		}
		
		return sum == x;
    }
}
