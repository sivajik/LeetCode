package leetcode.medium;

public class Prob621_TaskScheduler {

	public static void main(String[] args) {
		System.out.println(leastInterval(new char[] { 'A','A','A','A','A','A','B','C','D','E','F','G' }, 2));

	}

	static public int leastInterval(char[] tasks, int n) {
		int[] charMap = new int[26];
		for (char c : tasks) {
			charMap[c - 'A']++;
		}
		java.util.Arrays.sort(charMap);
		int maxVal = charMap[25] - 1;
		int idleslots = maxVal * n;

		for (int i = 24; i >= 0; i--) {
			idleslots -= Math.min(charMap[i], maxVal);
		}

		return idleslots > 0 ? idleslots + tasks.length : tasks.length;
	}
}
