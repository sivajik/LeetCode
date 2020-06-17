package leetcode.easy;

public class Prob720_LongestWordInDictionary {

	public static void main(String[] args) {
		System.out.println(longestWord(new String[] { "w", "wo", "wor", "worl", "world" }));
		System.out.println(longestWord(new String[] { "a", "banana", "app", "appl", "ap", "apply", "apple" }));
		
		System.out.println(longestWord(new String[] {"b","br","bre","brea","break","breakf","breakfa","breakfas","breakfast","l","lu","lun","lunc","lunch","d","di","din","dinn","dinne","dinner"}));
	}

	static public String longestWord(String[] words) {
		java.util.Arrays.sort(words, new java.util.Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if (o1.length() == o2.length()) {
					return o2.compareTo(o1);
				}
				return o1.length() - o2.length();
			}
		});

		Trie trie = new Trie();

		for (String eachWord : words) {
			trie.insert(eachWord);
		}

		for (int i = words.length - 1; i >= 0; i--) {
			// banana, apple, apply, appl, app, ap, a
			String word = words[i];
			boolean allSubWordsFound = true;
			for (int j = word.length() - 1; j > 0; j--) {
				String subWord = word.substring(0, j);
				if (!trie.exists(subWord)) {
					allSubWordsFound = false;
					break; // stop there. pick the next word.
				}
			}

			if (allSubWordsFound) {
				return word;
			}
		}
		return null;
	}
}

class TrieNode {
	TrieNode[] children;
	boolean isLeaf;

	TrieNode() {
		this.children = new TrieNode[26];
	}
}

class Trie {
	TrieNode root;

	Trie() {
		this.root = new TrieNode();
	}

	public void insert(String eachWord) {
		TrieNode temp = root;
		for (char c : eachWord.toCharArray()) {
			int index = c - 'a';
			if (temp.children[index] == null) {
				TrieNode x = new TrieNode();
				temp.children[index] = x;
				temp = temp.children[index];
			} else {
				temp = temp.children[index];
			}
		}
		temp.isLeaf = true;
	}

	public boolean exists(String subWord) {
		TrieNode temp = root;
		for (char c : subWord.toCharArray()) {
			int index = c - 'a';
			if (temp.children[index] == null) {
				return false;
			} else {
				temp = temp.children[index];
			}
		}
		return temp == root ? false : (temp == null ? false : temp.isLeaf);
	}

}