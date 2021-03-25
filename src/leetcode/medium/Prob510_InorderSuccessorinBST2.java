package leetcode.medium;

public class Prob510_InorderSuccessorinBST2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static public Node inorderSuccessor(Node p) {
		if (p.right != null) {
			p = p.right;
			while (p.left != null) {
				p = p.left;
			}
			return p;
		}

		while (p.parent != null && p.parent.right == p) {
			// u go to as long as its right child
			// stop when its left child. i.e we found the node which is left. so return its
			// parent.
			p = p.parent;
		}
		return p.parent;
	}

	static class Node {
		int val;
		Node left;
		Node right;
		Node parent;

		Node(int x) {
			val = x;
		}
	}
}
