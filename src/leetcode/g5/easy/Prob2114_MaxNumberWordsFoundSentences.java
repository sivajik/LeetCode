package leetcode.g5.easy;

public class Prob2114_MaxNumberWordsFoundSentences {

	public static void main(String[] args) {
		System.out.println(mostWordsFound(
				new String[] { "alice and bob love leetcode", "i think so too", "this is great thanks very much" }));
		System.out.println(mostWordsFound(new String[] { "please wait", "continue to fight", "continue to win" }));
	}

	// bit better one
	static public int mostWordsFound(String[] sentences) {
		int res = Integer.MIN_VALUE;
		for (String sen : sentences) {
			int cnt = 0;
			for (char c : sen.toCharArray()) {
				if (c == ' ') {
					cnt++;
				}
			}
			if (cnt > res) {
				res = cnt;
			}
		}
		return res + 1;
	}

	// Ver slow one
	static public int mostWordsFound1(String[] sentences) {
		int res = Integer.MIN_VALUE;
		for (String sen : sentences) {
			String[] temp = sen.split("\\s");
			if (temp.length > res) {
				res = temp.length;
			}
		}
		return res;
	}
}
