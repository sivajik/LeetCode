package leetcode.medium;

public class Prob8_StringtoInteger {

	public static void main(String[] args) {
		System.out.println(myAtoi("42"));
		System.out.println(myAtoi("  -42"));
	}

	static public int myAtoi(String s) {
		int i = 0;
		if (s.length() == 0) {
			return 0;
		}

		while (i < s.length() && s.charAt(i) == ' ') {
			i++;
		}
		int sign = 1;
		if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
			sign = s.charAt(i) == '-' ? -1 : 1;
			i++;
		}

		int res = 0;
		while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
			// this is the key to handle max values & boundaries
			// since we are multiplying res by 10
			// if its already > max/10 OR ( it is max/10 and curr char is > max%10)
			if (res > Integer.MAX_VALUE / 10
					|| (res == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' > Integer.MAX_VALUE % 10)) {
				return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}

			res = res * 10;
			res += s.charAt(i) - '0';
			i++;
		}

		return res * sign;
	}
}
