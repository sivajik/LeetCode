package leetcode.thirtydays.august;

public class Day05_AddSearchWordDesign {

	public static void main(String[] args) {
		WordDictionary d = new WordDictionary();
		d.addWord("ran");
		d.addWord("rune");
		d.addWord("runner");
		d.addWord("runs");
		d.addWord("add");
		d.addWord("adds");		
		d.addWord("adder");
		d.addWord("addee");

				
		System.out.println(d.search("....e."));
	}
}
/*
 ["WordDictionary","addWord","addWord","addWord","addWord","addWord","addWord","addWord","addWord","search","search","search","search","search","search","search","search","search","search"]
[[],,["r.n"],["ru.n.e"],["add"],["add."],["adde."],[".an."],["...s"],["....e."],["......."],["..n.r"]]
 */
class WordDictionary {

	private MyTrie trie;

	public WordDictionary() {
		this.trie = new MyTrie();
	}

	public void addWord(String word) {
		this.trie.insertWord(word);
	}

	public boolean search(String word) {
		return this.trie.search(word);
	}
}

class Node {
	boolean isLeaf;
	Node[] children;

	Node() {
		this.children = new Node[26];
	}
}

class MyTrie {
	Node root;

	MyTrie() {
		this.root = new Node();
	}

	public void insertWord(String str) {
		Node temp = root;
		for (char c : str.toCharArray()) {
			int index = c - 'a';
			if (temp.children[index] != null) {
				temp = temp.children[index];
			} else {
				Node newNode = new Node();
				temp.children[index] = newNode;
				temp = temp.children[index];
			}
		}
		temp.isLeaf = true;
	}

	public boolean search(String word) {
		return match(word.toCharArray(), root, 0);
	}

	private boolean match(char[] word, Node node, int index) {
		if (node == null) {
			return false;
		}

		if (index == word.length) {
			return node.isLeaf;
		}

		char c = word[index];
		if (c == '.') {
			for (char i=0; i < 26; i++) {
				Node nextLevelNode = node.children[i];
				if (nextLevelNode != null && match(word, nextLevelNode, index + 1)) {
					return true;
				}
			}
		} else {
			return node.children[c - 'a'] != null && match(word, node.children[c - 'a'], index + 1);
		}
		return false;
	}
}
