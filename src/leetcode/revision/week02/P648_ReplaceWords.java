package leetcode.revision.week02;

import java.util.*;

public class P648_ReplaceWords {

	public static void main(String[] args) {
		List<String> d1 = new ArrayList<>();
		d1.add("cat");
		d1.add("bat");
		d1.add("rat");
		System.out.println(replaceWords(d1, "the cattle was rattled by the battery").equals("the cat was rat by the bat"));
		
		List<String> d2 = new ArrayList<>();
		d2.add("a");
		d2.add("b");
		d2.add("c");
		System.out.println(replaceWords(d2, "aadsfasf absbs bbab cadsfafs").equals("a a b c"));
		
		
		List<String> d3 = new ArrayList<>();
		d3.add("a");
		d3.add("aa");
		d3.add("aaa");
		d3.add("aaaa");
		//System.out.println(replaceWords(d3, "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"));
		System.out.println(replaceWords(d3, "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa").equals("a a a a a a a a bbb baba a"));
		
		
		List<String> d4 = new ArrayList<>();
		d4.add("catt");
		d4.add("cat");
		d4.add("bat");
		d4.add("rat");
		System.out.println(replaceWords(d4, "the cattle was rattled by the battery").equals("the cat was rat by the bat"));
		
		
		List<String> d5 = new ArrayList<>();
		d5.add("ac");
		d5.add("ab");
		System.out.println(replaceWords(d5, "it is abnormal that this solution is accepted").equals("it is ab that this solution is ac"));
		
	}

	static public String replaceWords(List<String> dictionary, String sentence) {
		StringBuilder sbr = new StringBuilder();

		Trie t = new Trie();
		for (String str : dictionary) {
			t.insert(str);
		}

		String[] tokens = sentence.split("\\s+");
		for (String eachToken : tokens) {
			String rootWord = t.getRootWord(eachToken);
			if (rootWord != null) {
				sbr.append(rootWord);
			} else {
				sbr.append(eachToken);
			}
			sbr.append(" ");
		}
		return sbr.toString().trim();
	}

}

class TrieNode {
	boolean isLeaf;
	TrieNode[] cell;
	String word;

	TrieNode() {
		this.isLeaf = false;
		this.cell = new TrieNode[26];
		this.word = null;
	}
}

class Trie {
	TrieNode root = null;

	Trie() {
		this.root = new TrieNode();
	}

	public void insert(String str) {
		TrieNode tmp = root;
		for (char c : str.toCharArray()) {
			int index = c - 'a';

			if (tmp.cell[index] == null) {
				TrieNode x = new TrieNode();
				tmp.cell[index] = x;
				tmp = tmp.cell[index];
			} else {
				tmp = tmp.cell[index];
			}
		}
		tmp.isLeaf = true;
		tmp.word = str;
	}

	public String getRootWord(String str) {
		TrieNode tmp = root;
		TrieNode prev = null;
		for (char c : str.toCharArray()) {
			int index = c - 'a';
			if (tmp.cell[index] == null) {
				if (prev != null) {
					return prev.word;
				} else {
					return null;	
				}
			} else {
				if (prev == null && tmp.cell[index].isLeaf == true) {
					prev = tmp.cell[index];
					return prev.word;
				}
				tmp = tmp.cell[index];
			}
		}
		return prev != null ? prev.word : null;
	}
}
