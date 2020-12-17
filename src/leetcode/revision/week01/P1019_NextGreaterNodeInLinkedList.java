package leetcode.revision.week01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class P1019_NextGreaterNodeInLinkedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		head.next = new ListNode(7);
		head.next.next = new ListNode(4);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(5);
		System.out.println(Arrays.toString(nextLargerNodes(head)));

		ListNode head1 = new ListNode(2);
		head1.next = new ListNode(1);
		head1.next.next = new ListNode(5);
		System.out.println(Arrays.toString(nextLargerNodes(head1)));

		ListNode head2 = new ListNode(1);
		head2.next = new ListNode(7);
		head2.next.next = new ListNode(5);
		head2.next.next.next = new ListNode(1);
		head2.next.next.next.next = new ListNode(9);
		head2.next.next.next.next.next = new ListNode(2);
		head2.next.next.next.next.next.next = new ListNode(5);
		head2.next.next.next.next.next.next.next = new ListNode(1);
		System.out.println(Arrays.toString(nextLargerNodes(head2)));

		ListNode head3 = new ListNode(3);
		head3.next = new ListNode(3);
		System.out.println(Arrays.toString(nextLargerNodes(head3)));

		ListNode head4 = new ListNode(5);
		head4.next = new ListNode(2);
		head4.next.next = new ListNode(5);
		System.out.println(Arrays.toString(nextLargerNodes(head4)));

	}

	static public int[] nextLargerNodes(ListNode head) {
		List<Integer> list = new ArrayList<>();

		while (head != null) {
			list.add(head.val);
			head = head.next;
		}
		Stack<Integer> s = new Stack<>();
		int[] result = new int[list.size()];

		// 2 7 4 3 5
		for (int i = list.size() - 1; i >= 0; i--) {
			int elem = list.get(i);

			// empty means, start
			if (s.isEmpty()) {
				result[i] = 0;
			} else if (s.peek() > elem) {
				// stack top has highest than curr elem, so must be the largest one
				result[i] = s.peek();
			} else if (s.peek() <= elem) { // <= must match with while loop's <=
				// remove all lower elems.
				while (!s.isEmpty() && s.peek() <= elem) { // <= must match with while loop's <=
					s.pop();
				}
				// no more elems? this must be the largest
				if (s.isEmpty()) {
					result[i] = 0;
				} else {
					result[i] = s.peek();
				}
			}
			s.push(elem);
		}
		return result;
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
