package leetcode.medium;

public class Prob82_RemoveDuplicatesSortedList2 {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);

		ListNode n3 = new ListNode(1);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(3);
		ListNode n6 = new ListNode(4);
		ListNode n7 = new ListNode(5);

		n1.next = n2;

		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;

		print(deleteDuplicates(n1));
	}

	static public ListNode deleteDuplicates(ListNode head) {
		ListNode dummy = new ListNode();
		dummy.next = head;

		ListNode prev = dummy;
		ListNode curr = head;
		while (curr != null && curr.next != null) {
			ListNode nextNode = curr.next;
			boolean dupsFound = false;
			while (nextNode != null && nextNode.val == curr.val) {
				nextNode = nextNode.next;
				dupsFound = true;
			}

			if (dupsFound) {
				prev.next = nextNode;
				curr = nextNode;
			} else {
				prev = curr;
				curr = curr.next;
			}

		}
		return dummy.next;
	}

	static void print(ListNode t) {
		ListNode temp = t;
		while (temp != null) {
			System.out.print(temp.val + ", ");
			temp = temp.next;
		}
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
