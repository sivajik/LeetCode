package leetcode.hard;

public class Prob564_FindtheClosestPalindrome {

	public static void main(String[] args) {
		System.out.println(nearestPalindromic("1001"));
	}

	static public String nearestPalindromic(String n) {
		/*
		 * So given 1001 for 
		 * eg: smaller = mirror(1000 -1) = mirror(999) = 999 
		 * larger = mirror(1000 + 100) = mirror(1100) = 1111
		 */
		int halfOfLen = (int) Math.pow(10, n.length() / 2); // sort of order of number
		Long inputNumber = Long.valueOf(new String(n));

		Long palinOfGivenNum = mirror(inputNumber);
		Long larger = mirror((inputNumber / halfOfLen) * halfOfLen + halfOfLen);
		Long smaller = mirror((inputNumber / halfOfLen) * halfOfLen - 1);
		if (palinOfGivenNum > inputNumber) {
			larger = (long) Math.min(palinOfGivenNum, larger); // get closest number (hence min) to original number
		} else if (palinOfGivenNum < inputNumber) {
			smaller = (long) Math.max(palinOfGivenNum, smaller);
		}
		return String.valueOf(inputNumber - smaller <= larger - inputNumber ? smaller : larger);
	}

	static Long mirror(Long ans) {
		char[] a = String.valueOf(ans).toCharArray();
		int i = 0;
		int j = a.length - 1;
		while (i < j) {
			a[j--] = a[i++];
		}
		return Long.valueOf(new String(a));
	}
}
