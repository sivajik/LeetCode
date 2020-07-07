package leetcode.easy;

public class Prob203_RemoveLinkedListElements {

	public static void main(String[] args) {
		ListNode l1 = createList(new int[] { 1, 1 });
		print(l1);
		ListNode l2 = removeElements(l1, 1);
		print(l2);
	}

	static public ListNode removeElements(ListNode head, int val) {
		ListNode temp = head;
		ListNode prev = null;

		while (temp != null) {
			if (temp.val == val) {
				if (prev == null) {
					head = head.next;
				} else {
					prev.next = temp.next;
				}
			} else {
				prev = temp;
			}
			temp = temp.next;
		}
		return head;
	}

	private static void print(ListNode l1) {
		System.out.println("Printing List::");
		ListNode temp = l1;
		while (temp != null) {
			System.out.print(temp.val + ", ");
			temp = temp.next;
		}
		System.out.println("\n");
	}

	private static ListNode createList(int[] is) {
		ListNode head = null;
		for (int i = is.length - 1; i >= 0; i--) {
			ListNode temp = new ListNode(is[i], head);
			head = temp;
		}
		return head;
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
