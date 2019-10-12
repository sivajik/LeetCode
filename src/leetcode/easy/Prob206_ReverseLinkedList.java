package leetcode.easy;

public class Prob206_ReverseLinkedList {
	public static void main(String[] args) throws Exception {

	}

	public static ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;

		while (curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
