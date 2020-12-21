package leetcode.revision.week03;

public class P211_DesignAddSearchWordsDataStructure {

	public static void main(String[] args) {
		WordDictionary wordDictionary = new WordDictionary();
		wordDictionary.addWord("bad");
		wordDictionary.addWord("dad");
		wordDictionary.addWord("mad");
		System.out.println(wordDictionary.search("pad")); // return False
		System.out.println(wordDictionary.search("bad")); // return True
		System.out.println(wordDictionary.search(".ad")); // return True
		System.out.println(wordDictionary.search("b..")); // return True
	}

}

class TrieNode {
	TrieNode[] nodes;
	boolean isLeaf;

	TrieNode() {
		this.nodes = new TrieNode[26];
		this.isLeaf = false;
	}
}

class Trie {
	TrieNode root;

	Trie() {
		this.root = new TrieNode();
	}

	public void add(String str) {
		TrieNode temp = root;
		for (char c : str.toCharArray()) {
			int index = c - 'a';
			if (temp.nodes[index] == null) {
				TrieNode newNode = new TrieNode();
				temp.nodes[index] = newNode;
				temp = temp.nodes[index];
			} else {
				temp = temp.nodes[index];
			}
		}
		temp.isLeaf = true;
	}

	public boolean search(String word) {
		return match(word.toCharArray(), root, 0);
	}

	private boolean match(char[] charArray, TrieNode root, int currIndex) {
		if (root == null) {
			return false;
		}

		if (currIndex == charArray.length) {
			return root.isLeaf;
		}

		char c = charArray[currIndex];
		if (c == '.') {
			for (int i = 0; i < 26; i++) {
				if (match(charArray, root.nodes[i], currIndex + 1)) {
					return true;
				}
			}
		} else {
			return match(charArray, root.nodes[c - 'a'], currIndex + 1);
		}
		return false;
	}

}

class WordDictionary {
	Trie myTrie;

	public WordDictionary() {
		this.myTrie = new Trie();
	}

	public void addWord(String word) {
		this.myTrie.add(word);
	}

	public boolean search(String word) {
		return this.myTrie.search(word);
	}
}