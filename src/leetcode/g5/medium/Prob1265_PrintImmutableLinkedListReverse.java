package leetcode.g5.medium;

public class Prob1265_PrintImmutableLinkedListReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static public void printLinkedListInReverse(ImmutableListNode head) {
		if (head == null) {
			return;
		}
		printLinkedListInReverse(head.getNext());
		head.printValue();
		
		/*
		Stack<ImmutableListNode> stk = new Stack<>();
		ImmutableListNode temp = head;
		while (temp != null) {
			stk.push(temp);
			temp = temp.getNext();
		}

		while (!stk.isEmpty()) {
			stk.pop().printValue();
		}*/
	}

	interface ImmutableListNode {
		public void printValue(); // print the value of this node.

		public ImmutableListNode getNext(); // return the next node.
	};
}
