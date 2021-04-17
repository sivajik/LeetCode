package leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob212_WordSearch2 {

	public static void main(String[] args) {
		for (String s : findWords(new char[][] { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
				{ 'i', 'f', 'l', 'v' } }, new String[] { "oath", "pea", "eat", "rain" })) {
			System.out.println(s);
		}
	}

	static public List<String> findWords(char[][] board, String[] words) {
		// 1) push all words to Trie.
		TrieNode root = new TrieNode();
		for (String word : words) {
			TrieNode node = root;
			for (Character letter : word.toCharArray()) {
				if (node.children.containsKey(letter)) {
					node = node.children.get(letter);
				} else {
					TrieNode newNode = new TrieNode();
					node.children.put(letter, newNode);
					node = newNode;
				}
			}
			node.word = word;
		}

		// 2) process backtrack.
		ArrayList<String> result = new ArrayList<String>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (root.children.containsKey(board[i][j])) {
					backtrack(i, j, root, board, result);
				}
			}
		}
		return result;
	}

	private static void backtrack(int i, int j, TrieNode parentNode, char[][] board, ArrayList<String> result) {
		Character letter = board[i][j];
		TrieNode currNode = parentNode.children.get(letter);

		if (currNode.word != null) {
			result.add(currNode.word);
			currNode.word = null;
		}

		board[i][j] = '£';

		int[] rowOffset = { -1, 0, 1, 0 };
		int[] colOffset = { 0, 1, 0, -1 };
		for (int x = 0; x < 4; x++) {
			int newRow = i + rowOffset[x];
			int newCol = j + colOffset[x];

			if (newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[0].length) {
				continue;
			}
			if (currNode.children.containsKey(board[newRow][newCol])) {
				backtrack(newRow, newCol, currNode, board, result);
			}
		}

		board[i][j] = letter; // very imporatnt to keep it back as it was.
		
		// only needed for 25 to 75% optimisation
/*
		if (currNode.children.isEmpty()) {
			parentNode.children.remove(letter);
		}
*/
		
	}

	static class TrieNode {
		String word = null;
		Map<Character, TrieNode> children = new HashMap<>();

		public TrieNode() {

		}
	}
}
