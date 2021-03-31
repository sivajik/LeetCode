package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Prob1650_LowestCommonAncestorofaBinaryTreeIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Node lowestCommonAncestor(Node p, Node q) {
		List<Node> pPath = pathOfP(p);
		while (q.parent != null) {
			for (Node eachNode : pPath) {
				if (eachNode == q) {
					return q;
				}
			}
			q = q.parent;
		}

		return q;
	}

	private List<Node> pathOfP(Node p) {
		List<Node> l = new ArrayList<>();
		l.add(p);
		Node tmp = p;
		while (tmp.parent != null) {
			tmp = tmp.parent;
			l.add(tmp);
		}
		return l;
	}

	static class Node {
		public int val;
		public Node left;
		public Node right;
		public Node parent;
	};
}
