package leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Prob126_WordLadderII {

	public static void main(String[] args) {
		/*for (List<String> l : findLadders("hit", "cog",
				Arrays.asList(new String[] { "hot", "dot", "dog", "lot", "log", "cog" }))) {
			System.out.println(l);
		}
		*/
		for (List<String> l : findLadders("aaaaaaaaaa", "cccccccccc",
				Arrays.asList(new String[] { "aaaaaaaaaa","caaaaaaaaa","cbaaaaaaaa","daaaaaaaaa","dbaaaaaaaa","eaaaaaaaaa","ebaaaaaaaa","faaaaaaaaa","fbaaaaaaaa","gaaaaaaaaa","gbaaaaaaaa","haaaaaaaaa","hbaaaaaaaa","iaaaaaaaaa","ibaaaaaaaa","jaaaaaaaaa","jbaaaaaaaa","kaaaaaaaaa","kbaaaaaaaa","laaaaaaaaa","lbaaaaaaaa","maaaaaaaaa","mbaaaaaaaa","naaaaaaaaa","nbaaaaaaaa","oaaaaaaaaa","obaaaaaaaa","paaaaaaaaa","pbaaaaaaaa","qaaaaaaaaa","qbaaaaaaaa","raaaaaaaaa","rbaaaaaaaa","saaaaaaaaa","sbaaaaaaaa","taaaaaaaaa","tbaaaaaaaa","uaaaaaaaaa","ubaaaaaaaa","vaaaaaaaaa","vbaaaaaaaa","waaaaaaaaa","wbaaaaaaaa","xaaaaaaaaa","xbaaaaaaaa","yaaaaaaaaa","ybaaaaaaaa","zaaaaaaaaa","zbaaaaaaaa","bbaaaaaaaa","bbcaaaaaaa","bbcbaaaaaa","bbdaaaaaaa","bbdbaaaaaa","bbeaaaaaaa","bbebaaaaaa","bbfaaaaaaa","bbfbaaaaaa","bbgaaaaaaa","bbgbaaaaaa","bbhaaaaaaa","bbhbaaaaaa","bbiaaaaaaa","bbibaaaaaa","bbjaaaaaaa","bbjbaaaaaa","bbkaaaaaaa","bbkbaaaaaa","bblaaaaaaa","bblbaaaaaa","bbmaaaaaaa","bbmbaaaaaa","bbnaaaaaaa","bbnbaaaaaa","bboaaaaaaa","bbobaaaaaa","bbpaaaaaaa","bbpbaaaaaa","bbqaaaaaaa","bbqbaaaaaa","bbraaaaaaa","bbrbaaaaaa","bbsaaaaaaa","bbsbaaaaaa","bbtaaaaaaa","bbtbaaaaaa","bbuaaaaaaa","bbubaaaaaa","bbvaaaaaaa","bbvbaaaaaa","bbwaaaaaaa","bbwbaaaaaa","bbxaaaaaaa","bbxbaaaaaa","bbyaaaaaaa","bbybaaaaaa","bbzaaaaaaa","bbzbaaaaaa","bbbbaaaaaa","bbbbcaaaaa","bbbbcbaaaa","bbbbdaaaaa","bbbbdbaaaa","bbbbeaaaaa","bbbbebaaaa","bbbbfaaaaa","bbbbfbaaaa","bbbbgaaaaa","bbbbgbaaaa","bbbbhaaaaa","bbbbhbaaaa","bbbbiaaaaa","bbbbibaaaa","bbbbjaaaaa","bbbbjbaaaa","bbbbkaaaaa","bbbbkbaaaa","bbbblaaaaa","bbbblbaaaa","bbbbmaaaaa","bbbbmbaaaa","bbbbnaaaaa","bbbbnbaaaa","bbbboaaaaa","bbbbobaaaa","bbbbpaaaaa","bbbbpbaaaa","bbbbqaaaaa","bbbbqbaaaa","bbbbraaaaa","bbbbrbaaaa","bbbbsaaaaa","bbbbsbaaaa","bbbbtaaaaa","bbbbtbaaaa","bbbbuaaaaa","bbbbubaaaa","bbbbvaaaaa","bbbbvbaaaa","bbbbwaaaaa","bbbbwbaaaa","bbbbxaaaaa","bbbbxbaaaa","bbbbyaaaaa","bbbbybaaaa","bbbbzaaaaa","bbbbzbaaaa","bbbbbbaaaa","bbbbbbcaaa","bbbbbbcbaa","bbbbbbdaaa","bbbbbbdbaa","bbbbbbeaaa","bbbbbbebaa","bbbbbbfaaa","bbbbbbfbaa","bbbbbbgaaa","bbbbbbgbaa","bbbbbbhaaa","bbbbbbhbaa","bbbbbbiaaa","bbbbbbibaa","bbbbbbjaaa","bbbbbbjbaa","bbbbbbkaaa","bbbbbbkbaa","bbbbbblaaa","bbbbbblbaa","bbbbbbmaaa","bbbbbbmbaa","bbbbbbnaaa","bbbbbbnbaa","bbbbbboaaa","bbbbbbobaa","bbbbbbpaaa","bbbbbbpbaa","bbbbbbqaaa","bbbbbbqbaa","bbbbbbraaa","bbbbbbrbaa","bbbbbbsaaa","bbbbbbsbaa","bbbbbbtaaa","bbbbbbtbaa","bbbbbbuaaa","bbbbbbubaa","bbbbbbvaaa","bbbbbbvbaa","bbbbbbwaaa","bbbbbbwbaa","bbbbbbxaaa","bbbbbbxbaa","bbbbbbyaaa","bbbbbbybaa","bbbbbbzaaa","bbbbbbzbaa","bbbbbbbbaa","bbbbbbbbca","bbbbbbbbcb","bbbbbbbbda","bbbbbbbbdb","bbbbbbbbea","bbbbbbbbeb","bbbbbbbbfa","bbbbbbbbfb","bbbbbbbbga","bbbbbbbbgb","bbbbbbbbha","bbbbbbbbhb","bbbbbbbbia","bbbbbbbbib","bbbbbbbbja","bbbbbbbbjb","bbbbbbbbka","bbbbbbbbkb","bbbbbbbbla","bbbbbbbblb","bbbbbbbbma","bbbbbbbbmb","bbbbbbbbna","bbbbbbbbnb","bbbbbbbboa","bbbbbbbbob","bbbbbbbbpa","bbbbbbbbpb","bbbbbbbbqa","bbbbbbbbqb","bbbbbbbbra","bbbbbbbbrb","bbbbbbbbsa","bbbbbbbbsb","bbbbbbbbta","bbbbbbbbtb","bbbbbbbbua","bbbbbbbbub","bbbbbbbbva","bbbbbbbbvb","bbbbbbbbwa","bbbbbbbbwb","bbbbbbbbxa","bbbbbbbbxb","bbbbbbbbya","bbbbbbbbyb","bbbbbbbbza","bbbbbbbbzb","bbbbbbbbbb","aaaaaaaaac","aaaaaaaacc","aaaaaaaccc","aaaaaacccc","aaaaaccccc","aaaacccccc","aaaccccccc","aacccccccc","accccccccc","cccccccccc" }))) {
			System.out.println(l);
		}
	}

	static public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		// https://leetcode.com/problems/word-ladder-ii/discuss/40468/One-way-BFS
		List<List<String>> res = new ArrayList<>();

		if (wordList == null || wordList.size() == 0) {
			return res;
		}

        Set<String> wordDict = new HashSet<>();
        for (String word : wordList) {
            wordDict.add(word);
        }
		Set<String> visited = new HashSet<>();

		Queue<Node> q = new LinkedList<>();
		q.add(new Node(beginWord, 1, Arrays.asList(new String[] { beginWord })));

		Integer shortestDist = null;

		while (!q.isEmpty()) {
			// Record what we meet at this level
			Set<String> thisLevelVisited = new HashSet<>();
			int size = q.size();
			for (int k = 0; k < size; k++) {
				Node currNode = q.poll();

				if (shortestDist != null && currNode.distance > shortestDist) {
					continue;
				}

				if (currNode.word.equals(endWord)) {
					if (shortestDist == null) {
						shortestDist = currNode.distance;
					}
					res.add(currNode.path);
					continue;
				}

				List<String> nextWords = findNextWords(currNode.word, wordDict, visited);
				for (String nextWord : nextWords) {
					List<String> newPath = new ArrayList<>(currNode.path);
					newPath.add(nextWord);
					q.offer(new Node(nextWord, currNode.distance + 1, newPath));
					thisLevelVisited.add(nextWord);
				}
			}
			visited.addAll(thisLevelVisited);
		}
		return res;
	}

	private static List<String> findNextWords(String word, Set<String> wordDict, Set<String> visited) {
		List<String> res = new ArrayList<>();
		char[] letters = word.toCharArray();

		for (int i = 0; i < letters.length; i++) {
			char originLetter = letters[i];
			for (char c = 'a'; c <= 'z'; c++) {
				if (c == originLetter) {
					continue;
				}

				letters[i] = c;
				String nextWord = new String(letters);
				if (wordDict.contains(nextWord) && !visited.contains(nextWord)) {
					res.add(nextWord);
				}
			}
			letters[i] = originLetter;
		}
		return res;
	}

	static class Node {
		String word;
		int distance;
		List<String> path;

		Node(String word, int distance, List<String> path) {
			this.word = word;
			this.distance = distance;
			this.path = path;
		}
	}
}
