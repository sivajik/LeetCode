package leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class Prob362_DesignHitCounter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static class HitCounter {
		Queue<Integer> q = null;

		public HitCounter() {
			this.q = new LinkedList<>();
		}

		public void hit(int timestamp) {
			q.add(timestamp);
		}

		public int getHits(int timestamp) {
			while (q.size() > 0) {
				int topTimeStamp = q.peek();
				if (timestamp - topTimeStamp >= 300) {
					q.remove();
				} else {
					// important..
					break;
				}
			}
			return q.size();
		}
	}
}
