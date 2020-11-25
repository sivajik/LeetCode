package leetcode.revision.week02;

public class P208_ImplementTrie {

	public static void main(String[] args) {
		Trie trie = new Trie();
		System.out.println(trie.startsWith("a")); 
/*
		trie.insert("apple");
		System.out.println(trie.search("apple")); // returns true
		System.out.println(trie.search("app")); // returns false
		System.out.println(trie.startsWith("app")); // returns true
		trie.insert("app");
		System.out.println(trie.search("app")); // returns true
*/	}

	static class TrieNode {
		boolean isLeaf;
		TrieNode[] chars;

		TrieNode() {
			this.isLeaf = false;
			this.chars = new TrieNode[26];
		}
	}

	static class Trie {

		TrieNode root;

		public Trie() {
			this.root = new TrieNode();
		}

		public void insert(String word) {
			TrieNode tmp = root;
			for (char c : word.toCharArray()) {
				int index = c - 'a';
				if (tmp.chars[index] == null) {
					TrieNode t = new TrieNode();
					tmp.chars[index] = t;
					tmp = tmp.chars[index];
				} else {
					tmp = tmp.chars[index];
				}
			}
			tmp.isLeaf = true;
		}

		/** Returns if the word is in the trie. */
		public boolean search(String word) {
			TrieNode t = searchWord(word);
			if (t == null) {
				return false;
			} else {
				if (t.isLeaf) {
					return true;
				}
				return false;
			}
		}

		/**
		 * Returns if there is any word in the trie that starts with the given prefix.
		 */
		public boolean startsWith(String prefix) {
			TrieNode t = searchWord(prefix);
			if (t == null) {
				return false;
			} else {
				return true;
			}
		}
		
		public TrieNode searchWord(String word) {
			TrieNode tmp = root;
			for (char c : word.toCharArray()) {
				int index = c - 'a';
				if (tmp.chars[index] == null) {
					return null;
				} else {
					tmp = tmp.chars[index];
				}
			}
			return tmp == root ? null : tmp;
		}
	}
}
