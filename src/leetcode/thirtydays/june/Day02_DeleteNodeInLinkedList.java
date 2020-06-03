package leetcode.thirtydays.june;

public class Day02_DeleteNodeInLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
