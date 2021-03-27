package leetcode.medium;

public class Prob86_PartitionList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static public ListNode partition(ListNode head, int x) {
		ListNode beforeHead = new ListNode(-999);
		ListNode afterHead = new ListNode(-999);
		ListNode before = beforeHead;
		ListNode after = afterHead;

		while (head != null) {
			if (head.val < x) {
				// before
				before.next = head;
				before = before.next;
			} else {
				// after
				after.next = head;
				after = after.next;
			}
			head = head.next;
		}
		after.next = null; // key step
		before.next = afterHead.next;
		return beforeHead.next;

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
