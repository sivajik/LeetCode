package leetcode.easy;

public class Prob237_DeleteANodeInLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
