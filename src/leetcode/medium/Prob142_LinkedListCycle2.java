package leetcode.medium;

public class Prob142_LinkedListCycle2 {

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

	static public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}

		ListNode slow = head;
		ListNode fast = head;
		boolean cycleFound = false;
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				cycleFound = true;
				break;
			}
		}

		if (!cycleFound) {
			return null;
		} else {
			slow = head;
			while (slow != fast) {
				slow = slow.next;
				fast = fast.next;
			}
		}
		return slow;
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
