package leetcode.medium;

public class Prob244_ShortestWordDistance2 {

	public static void main(String[] args) {
		WordDistance obj = new WordDistance(new String[] { "practice", "makes", "perfect", "coding", "makes" });
		System.out.println(obj.shortest("coding", "practice"));
		System.out.println(obj.shortest("makes", "coding"));
	}

	
	static class WordDistance {
		String[] words = null;

		public WordDistance(String[] wordsDict) {
			this.words = wordsDict;
		}

		public int shortest(String word1, String word2) {
			int i1 = -1;
			int i2 = -1;
			int res = Integer.MAX_VALUE;
			for (int i = 0; i < this.words.length; i++) {
				if (this.words[i].equals(word1)) {
					i1 = i;
				}
				if (this.words[i].equals(word2)) {
					i2 = i;
				}
				if (i1 != -1 && i2 != -1) {
					res = Math.min(res, Math.abs(i1 - i2));
				}
			}
			return res;
		}
	}
}
