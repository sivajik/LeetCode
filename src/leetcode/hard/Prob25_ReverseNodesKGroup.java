package leetcode.hard;

public class Prob25_ReverseNodesKGroup {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(2);
		
		link(n1, n2);
		link(n2, n3);
		link(n3, n4);
		link(n4, n5);
		link(n5, n6);
		
		print(n1);
		print(reverseKGroup(n1, 5));

	}

	static public ListNode reverseKGroup(ListNode head, int k) {
		java.util.Stack<ListNode> s = new java.util.Stack<>();

		ListNode temp = head;
		ListNode newHead = null;
		ListNode newHead1 = null;
		while (temp != null) {
			int count = 0;
			ListNode preTemp = temp;
			while (count < k && temp != null) {
				s.push(temp);
				temp = temp.next;
				count += 1;
			}

			if (count < k) {
				while (preTemp != null) {
					newHead.next = preTemp;
					newHead = newHead.next;
					preTemp = preTemp.next;
				}
			} else {
				while (!s.isEmpty()) {
					if (newHead == null) {
						ListNode dummy = s.pop();
						dummy.next = null;

						newHead = dummy;
						newHead1 = newHead;
					} else {
						ListNode dummy = s.pop();
						dummy.next = null;
						newHead.next = dummy;
						newHead = newHead.next;
					}
				}
			}
		}
		return newHead1;
	}

	static void link(ListNode a, ListNode b) {
		a.next = b;
	}

	static void print(ListNode t) {
		ListNode temp = t;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println();
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
