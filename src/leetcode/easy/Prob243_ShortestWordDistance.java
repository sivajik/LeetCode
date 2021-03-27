package leetcode.easy;

public class Prob243_ShortestWordDistance {

	public static void main(String[] args) {
		System.out.println(shortestDistance(new String[] {"practice", "makes", "perfect", "coding", "makes"}, "coding", "practice"));
		System.out.println(shortestDistance(new String[] {"practice", "makes", "perfect", "coding", "makes"}, "makes", "coding"));
	}

	static public int shortestDistance(String[] wordsDict, String word1, String word2) {
		int pos1 = -1;
		int pos2 = -1;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < wordsDict.length; i++) {
			if (wordsDict[i].equals(word1)) {
				pos1 = i;
			} else if (wordsDict[i].equals(word2)) {
				pos2 = i;
			}

			if (pos1 != -1 && pos2 != -1) {
				min = Math.min(min, Math.abs(pos1 - pos2));
			}
		}
		return min;
	}
}
