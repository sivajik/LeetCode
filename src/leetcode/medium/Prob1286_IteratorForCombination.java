package leetcode.medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Prob1286_IteratorForCombination {

	public static void main(String[] args) {
		CombinationIterator iterator = new CombinationIterator("abc", 2); // creates the iterator.

		System.out.println(iterator.next()); // returns "ab"
		System.out.println(iterator.hasNext()); // returns true
		System.out.println(iterator.next()); // returns "ac"
		System.out.println(iterator.hasNext()); // returns true
		System.out.println(iterator.next()); // returns "bc"
		System.out.println(iterator.hasNext()); // returns false
	}
}

class CombinationIterator {
	private Iterator<String> itr;

	public CombinationIterator(String characters, int combinationLength) {
		List<String> res = getnerateAllPossibilities(characters, combinationLength);
		this.itr = res.iterator();
	}

	public String next() {
		return itr.next();
	}

	public boolean hasNext() {
		return itr.hasNext();
	}

	public List<String> getnerateAllPossibilities(String str, int len) {
		List<String> res = new ArrayList<>();
		helper(str, 0, len, res, new ArrayList<Character>());
		return res;
	}

	private void helper(String str, int currIndez, int len, List<String> res, List<Character> l) {
		if (l.size() == len) {
			StringBuilder s = new StringBuilder();
			for (Character c : l) {
				s.append(c);
			}
			res.add(s.toString());
			return;
		}

		for (int i = currIndez; i < str.length(); i++) {
			l.add(str.charAt(i));
			helper(str, i + 1, len, res, l);
			l.remove(l.size() - 1);
		}
	}
}