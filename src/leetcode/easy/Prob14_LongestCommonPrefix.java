package leetcode.easy;

public class Prob14_LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String longestCommonPrefix(String[] strs) {

		if (strs == null)
			return "";

		int minLen = Integer.MAX_VALUE;
		Trie t = new Trie();
		for (String s : strs) {
			t.insert(s);
			minLen = Math.min(minLen, s.length());
		}

		if (minLen == 0) {
			return "";
		}

		TrieNode temp = t.root;
		StringBuilder sbr = new StringBuilder();
		while (temp != null) {
			int totalNumOfChildren = 0;
			int activeIndex = -1;
			for (int i = 0; i < 26; i++) {
				if (temp.children[i] != null && !temp.isLeafNode) {
					totalNumOfChildren++;
					activeIndex = i;
				}
			}
			if (totalNumOfChildren == 1) {
				sbr.append(temp.children[activeIndex].nodeValue);
				temp = temp.children[activeIndex];
			} else {
				break;
			}
		}
		return sbr.toString();

	}

	static class TrieNode {
		public TrieNode[] children;
		public boolean isLeafNode;
		char nodeValue;

		TrieNode() {
			this.children = new TrieNode[26];
		}
	}

	static class Trie {

		TrieNode root;

		public Trie() {
			this.root = new TrieNode();
		}

		public void insert(String word) {
			TrieNode tmp = root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				int index = c - 'a';
				if (tmp.children[index] == null) {
					TrieNode x = new TrieNode();
					x.nodeValue = c;
					tmp.children[index] = x;
					tmp = x;
				} else {
					tmp = tmp.children[index];
				}
			}
			tmp.isLeafNode = true;
		}
	}

}
