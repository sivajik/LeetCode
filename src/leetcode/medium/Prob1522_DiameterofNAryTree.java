package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Prob1522_DiameterofNAryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static int diam = 0;

	static public int diameter(Node root) {
		height(root);
		return diam;
	}

	static int height(Node root) {
		if (root == null || root.children.size() == 0) {
			return 0;
		}

		int maxH1 = 0, maxH2 = 0;
		for (Node eachChild : root.children) {
			int parentHeight = height(eachChild) + 1;
			if (parentHeight > maxH1) {
				maxH2 = maxH1;
				maxH1 = parentHeight;
			} else if (parentHeight > maxH2) {
				maxH2 = parentHeight;
			}
			int dist = maxH1 + maxH2;
			diam = Math.max(diam, dist);
		}

		return maxH1;
	}

	static class Node {
		public int val;
		public List<Node> children;

		public Node() {
			children = new ArrayList<Node>();
		}

		public Node(int _val) {
			val = _val;
			children = new ArrayList<Node>();
		}

		public Node(int _val, ArrayList<Node> _children) {
			val = _val;
			children = _children;
		}
	}
}
