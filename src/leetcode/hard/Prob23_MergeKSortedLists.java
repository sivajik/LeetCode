package leetcode.hard;

public class Prob23_MergeKSortedLists {

	public static void main(String[] args) {
		ListNode[] arr = new ListNode[3];

		arr[0] = new ListNode(1);
		arr[0].next = new ListNode(3);
		arr[0].next.next = new ListNode(5);
		arr[0].next.next.next = new ListNode(7);

		arr[1] = new ListNode(2);
		arr[1].next = new ListNode(4);
		arr[1].next.next = new ListNode(6);
		arr[1].next.next.next = new ListNode(8);

		arr[2] = new ListNode(0);
		arr[2].next = new ListNode(9);
		arr[2].next.next = new ListNode(10);
		arr[2].next.next.next = new ListNode(11);

		ListNode finalNoe = mergeKLists(arr);
		print(finalNoe);

	}

	static public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0) {
			return null;
		}
		int k = lists.length;
		java.util.PriorityQueue<ListNode> q = new java.util.PriorityQueue<ListNode>(
				new java.util.Comparator<ListNode>() {
					@Override
					public int compare(ListNode o1, ListNode o2) {
						// TODO Auto-generated method stub
						return o1.val - o2.val;
					}
				});

		for (int i = 0; i < k; i++) {
			if (lists[i] != null) {
				q.add(lists[i]);
			}
		}

		ListNode headOfFinalList = null;
		ListNode endOfFinalList = null;

		while (!q.isEmpty()) {
			ListNode top = q.peek();
			ListNode topNode = q.poll();

			if (top.next != null) {
				q.add(top.next);
			}

			if (headOfFinalList == null) {
				headOfFinalList = topNode;
				endOfFinalList = topNode;
			} else {
				endOfFinalList.next = topNode;
				endOfFinalList = endOfFinalList.next;
			}
		}
		return headOfFinalList;
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
