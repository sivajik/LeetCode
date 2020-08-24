package leetcode.hard;

public class Prob1032_StreamofCharacters {

	public static void main(String[] args) {
		StreamChecker streamChecker = new StreamChecker(new String[] { "cd", "f", "kl" }); // init the dictionary.
		streamChecker.query('a'); // return false
		streamChecker.query('b'); // return false
		streamChecker.query('c'); // return false
		streamChecker.query('d'); // return true, because 'cd' is in the wordlist
		streamChecker.query('e'); // return false
		streamChecker.query('f'); // return true, because 'f' is in the wordlist
		streamChecker.query('g'); // return false
		streamChecker.query('h'); // return false
		streamChecker.query('i'); // return false
		streamChecker.query('j'); // return false
		streamChecker.query('k'); // return false
		streamChecker.query('l'); // return true, because 'kl' is in the wordlist

		/*
		 * StreamChecker s = new StreamChecker(new String[] {
		 * "ab","ba","aaab","abab","baa" }); // init the dictionary. s.query('a');
		 * s.query('a'); s.query('a'); s.query('a'); s.query('a'); s.query('b');
		 * s.query('a');
		 */
	}

}

class MyTrieNode {
	boolean isLeaf;
	MyTrieNode[] children;

	MyTrieNode() {
		this.isLeaf = false;
		this.children = new MyTrieNode[26];
	}

}

class MyTrie {
	MyTrieNode root;

	MyTrie() {
		this.root = new MyTrieNode();
	}

	public void insert(String eachWord) {
		StringBuilder sb = new StringBuilder(eachWord);
		eachWord = sb.reverse().toString();

		MyTrieNode temp = root;
		for (char c : eachWord.toCharArray()) {
			int index = c - 'a';
			if (temp.children[index] != null) {
				temp = temp.children[index];
			} else {
				MyTrieNode newNode = new MyTrieNode();
				temp.children[index] = newNode;
				temp = temp.children[index];
			}
		}
		temp.isLeaf = true;
	}

	public boolean startsWith(String mostRecentWord) {
		MyTrieNode temp = root;
		for (char c : mostRecentWord.toCharArray()) {
			int index = c - 'a';
			if (temp.children[index] != null) {
				temp = temp.children[index];
			} else {
				return false;
			}
		}
		return temp != null;
	}

	public boolean contains(String mostRecentWord) {
		MyTrieNode temp = root;
		for (char c : mostRecentWord.toCharArray()) {
			int index = c - 'a';
			if (temp.children[index] != null) {
				temp = temp.children[index];
			} else {
				return false;
			}
		}
		return temp != null && temp.isLeaf;
	}
}

class StreamChecker {
	MyTrie t;

	private StringBuilder mostRecentWord = new StringBuilder();

	public StreamChecker(String[] words) {
		t = new MyTrie();
		for (String eachWord : words) {
			t.insert(eachWord);
		}
	}

	public boolean query(char letter) {
		mostRecentWord = mostRecentWord.append(letter);
		MyTrieNode node = t.root;
		for (int i = mostRecentWord.length() - 1; i >= 0 && node != null; i--) {
			char c = mostRecentWord.charAt(i);
			int index = c - 'a';
			node = node.children[index];
			if (node != null && node.isLeaf) {
				System.out.println(letter + " => " + true);
				return true;
			}
		}
		System.out.println(letter + " => " + false);
		return false;
	}
}
