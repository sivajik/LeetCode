package leetcode.revision.week02;

public class P1265_PrintImmutableLinkedListInReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    static public void printLinkedListInReverse(ImmutableListNode head) {
    	// dont use stack and pop in sequence. rather use recursion
        if (head == null) {
        	return;
        }
        printLinkedListInReverse(head.getNext());
        head.printValue();
    }
}

interface ImmutableListNode {
	public void printValue();
	public ImmutableListNode getNext();
}