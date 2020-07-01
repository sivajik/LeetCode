package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class Prob212_WordSearch2 {

	public static void main(String[] args) {
		/*
		 * List<String> l = findWords(new char[][] { { 'o', 'a', 'a', 'n' }, { 'e', 't',
		 * 'a', 'e' }, { 'i', 'h', 'k', 'r' }, { 'i', 'f', 'l', 'v' } }, new String[] {
		 * "oath", "pea", "eat", "rain", "nerv" });
		 */

		// List<String> l = findWords(new char[][] { { 'a', 'a'} }, new String[] { "aaa"
		// });
		List<String> l = findWords(new char[][] { { 'a', 'b' }, { 'a', 'a' } },
				new String[] { "aba", "baa", "bab", "aaab", "aaa", "aaaa", "aaba" });
		for (String s : l) {
			System.out.println(s);
		}

	}

	static public List<String> findWords(char[][] board, String[] words) {
		List<String> result = new ArrayList<>();

		if (board == null || board.length == 0 || board[0].length == 0) {
			return result;
		}

		boolean[][] visited = new boolean[board.length][board[0].length];

		Trie t = new Trie();
		for (String eachWord : words) {
			t.insert(eachWord);
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				dfs(board, i, j, t, visited, "", result);
				visited = new boolean[board.length][board[0].length];
			}
		}
		return result;
	}

	static private void dfs(char[][] board, int i, int j, Trie t, /* String word, */ boolean[][] visited,
			String startStr, List<String> result) {
		if (i < 0 || j < 0 || i >= board.length || j >= board[i].length || visited[i][j] == true) {
			return;
		}

		visited[i][j] = true;

		startStr = startStr + board[i][j];

		if (t.find(startStr)) {
			if (!result.contains(startStr)) {
				result.add(startStr);
			}
		}

		if (!t.startsWith(startStr)) {
			visited[i][j] = false;
			return;
		}

		dfs(board, i + 1, j, t, visited, startStr, result);
		dfs(board, i - 1, j, t, visited, startStr, result);
		dfs(board, i, j + 1, t, visited, startStr, result);
		dfs(board, i, j - 1, t, visited, startStr, result);

		visited[i][j] = false;
	}

}

class TrieNode {
	TrieNode[] children;
	boolean isLeafNode;

	TrieNode() {
		this.children = new TrieNode[26];
		this.isLeafNode = false;
	}
}

class Trie {
	TrieNode root;

	Trie() {
		this.root = new TrieNode();
	}

	public void insert(String word) {
		TrieNode temp = root;

		for (char c : word.toCharArray()) {
			int index = c - 'a';
			if (temp.children[index] == null) {
				TrieNode x = new TrieNode();
				temp.children[index] = x;
				temp = temp.children[index];
			} else {
				temp = temp.children[index];
			}
		}
		temp.isLeafNode = true;
	}

	public boolean find(String word) {
		TrieNode temp = getNode(word);
		return temp != null && temp.isLeafNode == true;
	}

	public boolean startsWith(String word) {
		TrieNode temp = getNode(word);
		return temp != null && temp.isLeafNode == false;
	}

	private TrieNode getNode(String word) {
		TrieNode temp = root;

		for (char c : word.toCharArray()) {
			int index = c - 'a';
			if (temp.children[index] == null) {
				return null;
			} else {
				temp = temp.children[index];
			}
		}
		return temp;
	}
}