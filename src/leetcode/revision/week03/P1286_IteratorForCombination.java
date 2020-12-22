package leetcode.revision.week03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class P1286_IteratorForCombination {

	public static void main(String[] args) {
		CombinationIterator itr = new CombinationIterator("abc", 2);
		itr.next(); // return "ab"
		itr.hasNext(); // return True
		itr.next(); // return "ac"
		itr.hasNext(); // return True
		itr.next(); // return "bc"
		itr.hasNext(); // return False

	}

}

class CombinationIterator {
	Iterator<String> itr;

	public CombinationIterator(String str, int combinationLength) {
		List<String> l = new ArrayList<>();
		helper(str, 0, l, new ArrayList<>(), combinationLength);
		this.itr = l.iterator();
	}

	private void helper(String str, int currIndex, List<String> res, List<Character> temp, int combinationLength) {
		if (temp.size() == combinationLength) {
			StringBuilder sbr = new StringBuilder();
			for (Character c : temp) {
				sbr.append(c);
			}
			res.add(sbr.toString());
			return;
		}

		for (int i = currIndex; i < str.length(); i++) {
			temp.add(str.charAt(i));
			helper(str, i  + 1, res, temp, combinationLength);
			temp.remove(temp.size() - 1);
		}
	}

	public String next() {
		String str = itr.next();
		// System.out.println(str);
		return str;
	}

	public boolean hasNext() {
		boolean res = itr.hasNext();
		// System.out.println(res);
		return res;
	}
}
