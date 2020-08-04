package leetcode.thirtydays.august;

public class Day03_ValdiatePalindrome {

	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome("race a car"));
	}

	static public boolean isPalindrome(String s) {

		char[] chars = s.toCharArray();
		int low = 0;
		int high = chars.length - 1;

		while (low < high) {
			if (!Character.isLetterOrDigit(chars[low])) {
				low++;
				continue;
			}
			if (!Character.isLetterOrDigit(chars[high])) {
				high--;
				continue;
			}
			if (Character.toUpperCase(chars[low]) != Character.toUpperCase(chars[high])) {
				return false;
			} else {
				low++;
				high--;
			}
		}

		return true;

	}
}
