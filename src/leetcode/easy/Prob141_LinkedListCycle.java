package leetcode.easy;

public class Prob141_LinkedListCycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Use FLoyds Loop detection algorithm
	public static boolean hasCycle(ListNode head) {
		boolean cycleExists = false;
		ListNode fastPointer = head;
		ListNode slowPointer = head;

		while (fastPointer != null && fastPointer.next != null) {
			fastPointer = fastPointer.next;
			fastPointer = fastPointer.next;
			slowPointer = slowPointer.next;

			if (slowPointer == fastPointer) {
				cycleExists = true;
				break;
			}
		}
		return cycleExists;
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
