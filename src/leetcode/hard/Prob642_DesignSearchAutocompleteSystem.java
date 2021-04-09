package leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prob642_DesignSearchAutocompleteSystem {

	public static void main(String[] args) {
		AutocompleteSystem obj = new AutocompleteSystem(
				new String[] { "i love you", "island", "ironman", "i love leetcode" }, new int[] { 5, 3, 2, 2 });
		System.out.println(obj.input('i'));

	}

	static class AutocompleteSystem {
		Trie root;
		String currentSentence = "";

		public AutocompleteSystem(String[] sentences, int[] times) {
			this.root = new Trie();
			for (int i = 0; i < sentences.length; i++) {
				insert(root, sentences[i], times[i]);
			}
		}

		private int toInt(char c) {
			return c == ' ' ? 26 : c - 'a';
		}

		private void insert(Trie root, String s, int times) {
			for (int i = 0; i < s.length(); i++) {
				if (root.children[toInt(s.charAt(i))] == null) {
					root.children[toInt(s.charAt(i))] = new Trie();
				}
				// dont put in else
				root = root.children[toInt(s.charAt(i))];

			}
			root.times += times;
		}

		private List<Node> lookup(Trie root, String currentSentence) {
			List<Node> list = new ArrayList<>();

			for (int i = 0; i < currentSentence.length(); i++) {
				if (root.children[toInt(currentSentence.charAt(i))] == null) {
					return new ArrayList<>();
				}
				// dont put this in else block
				root = root.children[toInt(currentSentence.charAt(i))];

			}

			traverse(currentSentence, root, list);
			return list;
		}

		private void traverse(String s, Trie t, List<Node> list) {
			if (t.times > 0) {
				list.add(new Node(s, t.times));
			}
			for (char i = 'a'; i <= 'z'; i++) {
				if (t.children[i - 'a'] != null) {
					traverse(s + i, t.children[i - 'a'], list);
				}
			}
			if (t.children[26] != null) {
				traverse(s + ' ', t.children[26], list);
			}
		}

		public List<String> input(char c) {
			List<String> res = new ArrayList<>();
			if (c == '#') {
				insert(root, currentSentence, 1);
				currentSentence = "";
			} else {
				currentSentence += c;
				List<Node> list = lookup(root, currentSentence);
				Collections.sort(list,
						(a, b) -> a.times == b.times ? a.sentence.compareTo(b.sentence) : b.times - a.times);
				for (int i = 0; i < Math.min(3, list.size()); i++) {
					res.add(list.get(i).sentence);
				}
			}
			return res;
		}
	}

	static class Trie {
		int times;
		Trie[] children = new Trie[27];
	}

	static class Node {
		int times;
		String sentence;

		Node(String a, int b) {
			this.sentence = a;
			this.times = b;
		}
	}
}
