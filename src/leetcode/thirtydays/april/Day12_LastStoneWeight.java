package leetcode.thirtydays.april;

import java.util.Collections;
import java.util.PriorityQueue;

public class Day12_LastStoneWeight {

	public static void main(String[] args) {
		System.out.println(lastStoneWeight(new int[] { 2, 7, 4, 1, 8, 1 }));

	}

	public static int lastStoneWeight(int[] stones) {

		PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());
		for (int stone : stones) {
			p.add(stone);
		}

		while (p.size() > 1) {
			int x = p.remove();
			int y = p.remove();
			if (x != y) {
				p.add(x - y);
			}
		}
		return p.size() == 0 ? 0 : p.peek();

	}
}
