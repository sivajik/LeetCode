package leetcode.thirtydays.feb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class P08_PeekingIterator {

	public static void main(String[] args) {
		List<Integer> l = new ArrayList<>();
		l.add(1);
		l.add(2);
		l.add(3);

		PeekingIterator p = new PeekingIterator(l.iterator());
		System.out.println(p.next() == 1);
		System.out.println(p.peek() == 2);
		System.out.println(p.next() == 2);
		System.out.println(p.next() == 3);
		System.out.println(p.hasNext() == false);
	}

	static class PeekingIterator implements Iterator<Integer> {
		Iterator<Integer> itr;
		boolean visitedPeekElem = false;
		Integer nextElem;

		public PeekingIterator(Iterator<Integer> iterator) {
			this.itr = iterator;
		}

		public Integer peek() {
			if (itr.hasNext()) {
				if (visitedPeekElem == false) {
					nextElem = itr.next();
					visitedPeekElem = true;
				}
			}
			return nextElem;
		}

		@Override
		public Integer next() {
			if (visitedPeekElem) {
				visitedPeekElem = false;
				return nextElem;
			}
			return itr.next();
		}

		@Override
		public boolean hasNext() {
			if (visitedPeekElem == true) {
				return true;
			} else {
				return itr.hasNext();
			}
		}
	}
}
