package leetcode.thirtydays.may;

public class Day14_TrieImplementation {

	public static void main(String[] args) {
		Trie obj = new Trie();
		obj.insert("apple");
		boolean param_2 = obj.search("apple");
		boolean param_3 = obj.startsWith("appy");
		System.out.println(param_2 + " -> " + param_3);
	}

}

class Trie {

	class TrieNode {
		TrieNode[] children;
		boolean isLeafNode;

		TrieNode() {
			this.children = new TrieNode[26];
		}
	}

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
				tmp.children[index] = x;
				tmp = x;
			} else {
				tmp = tmp.children[index];
			}
		}
		tmp.isLeafNode = true;

	}

	public boolean search(String word) {
		TrieNode p = searchForNode(word);
		if (p == null) {
			return false;
		} else {
			if (p.isLeafNode) {
				return true;
			}
		}
		return false;
	}

	public boolean startsWith(String prefix) {
		TrieNode p = searchForNode(prefix);
		if (p == null) {
			return false;
		} else {
			return true;
		}
	}

	private TrieNode searchForNode(String word) {
		TrieNode tmp = root;
		for (int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';
			if (tmp.children[index] != null) {
				tmp = tmp.children[index];
			} else {
				return null;
			}
		}
		return tmp == root ? null : tmp;
	}
}