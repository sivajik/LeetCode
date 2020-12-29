package leetcode.revision.week03;

public class P142_LinkedListCycle {

	public static void main(String[] args) {

		ListNode n0 = new ListNode(3);
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(0);
		ListNode n3 = new ListNode(4);

		n0.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n1;

		System.out.println(detectCycle(n0).val);

	}

	private static ListNode detectCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		boolean cycleFound = false;
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next;
			fast = fast.next; // jump twice.

			if (slow == fast) {
				cycleFound = true;
				break;
			}
		}

		if (cycleFound) {
			slow = head;
			while (slow != fast) {
				slow = slow.next;
				fast = fast.next;
			}
			return slow; // or fast

		} else {
			return null;
		}
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
