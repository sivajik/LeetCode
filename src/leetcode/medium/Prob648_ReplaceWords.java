package leetcode.medium;

public class Prob648_ReplaceWords {

	public static void main(String[] args) {
		System.out.println(replaceWords(java.util.Arrays.asList(new String[] { "cat", "bat", "rat" }),
				"the cattle was rattled by the battery"));

	}

	static public String replaceWords(java.util.List<String> dict, String sentence) {
		Trie t = new Trie();

		for (String str : dict) {
			t.insert(str);
		}

		String[] tokens = sentence.split(" ");

		for (int c = 0; c < tokens.length; c++) {
			String eachToken = tokens[c];

			// the
			boolean rootWordFound = false;
			for (int i = 1; i <= eachToken.length(); i++) {
				String tempWord = eachToken.substring(0, i);
				if (t.exists(tempWord)) {
					tokens[c] = tempWord;
					rootWordFound = true;
					break;
				}
			}

			if (!rootWordFound) {
				tokens[c] = eachToken;
			}
		}
		String res = String.join(" ", tokens);
		return res;
	}

	static class TrieNode {
		TrieNode[] children;
		boolean isLeaf;

		TrieNode() {
			this.children = new TrieNode[26];
		}
	}

	static class Trie {
		TrieNode root;

		Trie() {
			this.root = new TrieNode();
		}

		public boolean exists(String s) {
			TrieNode temp = root;
			for (char c : s.toCharArray()) {
				int index = c - 'a';
				if (temp.children[index] == null) {
					return false;
				} else {
					temp = temp.children[index];
				}
			}
			return root == temp ? false : temp.isLeaf;
		}

		public void insert(String str) {
			TrieNode temp = root;
			for (char c : str.toCharArray()) {
				int index = c - 'a';
				if (temp.children[index] == null) {
					TrieNode x = new TrieNode();
					temp.children[index] = x;
					temp = x;
				} else {
					temp = temp.children[index];
				}
			}
			temp.isLeaf = true;
		}
	}
}
