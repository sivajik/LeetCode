package leetcode.easy;

public class Prob038_CountAndSay {

	public static void main(String[] args) {
		for (int i = 1; i <= 30; i++) {
			System.out.println(i + "] " + countAndSay(i));
		}
	}

	public static String countAndSay(int n) {
		int count = 1;
		String start = "1";
		while (count < n) {
			start = prefixCountsForString(start);
			count++;
		}
		return start;
	}

	public static String prefixCountsForString(String str) {
		char[] numbers = str.toCharArray();
		StringBuilder finalStr = new StringBuilder();
		for (int i = 0; i < numbers.length;) {
			int count = 1;
			char currChar = numbers[i];
			int j = i;
			while (j + 1 < numbers.length && numbers[j + 1] == currChar) {
				j = j + 1;
				count = count + 1;
			}
			i = i + count;
			finalStr = finalStr.append("" + count + "" + currChar);
		}
		return finalStr.toString();
	}
}