package leetcode.revision.week03;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class P1429_FirstUniqueNumber {

	public static void main(String[] args) {
		FirstUnique firstUnique = new FirstUnique(new int[] { 2, 3, 5 });
		System.out.println(firstUnique.showFirstUnique()); // return 2
		firstUnique.add(5); // the queue is now [2,3,5,5]
		System.out.println(firstUnique.showFirstUnique()); // return 2
		firstUnique.add(2); // the queue is now [2,3,5,5,2]
		System.out.println(firstUnique.showFirstUnique()); // return 3
		firstUnique.add(3); // the queue is now [2,3,5,5,2,3]
		System.out.println(firstUnique.showFirstUnique()); // return -1
	}

}

class FirstUnique {
	Queue<Integer> q = new ArrayDeque<>();
	Map<Integer, Boolean> m = new HashMap<>();

	public FirstUnique(int[] nums) {
		for (int n : nums) {
			add(n);
		}
	}

	public int showFirstUnique() {
		while (!q.isEmpty() && m.get(q.peek()) == false) {
			q.remove();
		}
		if (q.isEmpty()) {
			return -1;
		}
		return q.peek();
	}

	public void add(int value) {
		if (m.containsKey(value)) {
			m.put(value, false);
		} else {
			m.put(value, true);
			this.q.add(value);
		}
	}
}