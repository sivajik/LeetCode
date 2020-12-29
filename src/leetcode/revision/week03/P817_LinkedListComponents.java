package leetcode.revision.week03;

import java.util.*;

public class P817_LinkedListComponents {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static public int numComponents(ListNode head, int[] G) {
		Set<Integer> set = new HashSet<>();
		for (int x : G) {
			set.add(x);
		}

		ListNode temp = head;
		int c = 0;
		while (temp != null) {
			if (set.contains(temp.val) && (temp.next == null || !set.contains(temp.next.val))) {
				c++;
			}
			temp = temp.next;
		}
		return c;
	}

	class ListNode {
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
