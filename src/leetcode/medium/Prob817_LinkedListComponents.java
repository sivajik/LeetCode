package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class Prob817_LinkedListComponents {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numComponents(ListNode head, int[] G) {

		int c = 0;

		Set<Integer> set = new HashSet<>();
		for (int e : G) {
			set.add(e);
		}

		ListNode temp = head;
		while (temp != null) {
			if (set.contains(temp.val) && (temp.next == null || !set.contains(temp.next.val))) {
				c++;
			}
			temp = temp.next;
		}
		return c;

	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}
