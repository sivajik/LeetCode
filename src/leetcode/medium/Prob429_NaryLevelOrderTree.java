package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Prob429_NaryLevelOrderTree {

	public static void main(String[] args) {
		Node n1 = new Node(1);

		Node n3 = new Node(3);
		Node n2 = new Node(2);
		Node n4 = new Node(4);

		List<Node> n1Childs = new ArrayList<>();
		n1Childs.add(n3);
		n1Childs.add(n2);
		n1Childs.add(n4);
		n1.children = n1Childs;

		Node n5 = new Node(5);
		Node n6 = new Node(6);
		List<Node> n3Childs = new ArrayList<>();
		n3Childs.add(n5);
		n3Childs.add(n6);
		n3.children = n3Childs;

		List<List<Integer>> l = levelOrder(n1);
		for (List<Integer> list : l) {
			System.out.println(list);
		}
	}

	public static List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> list = new ArrayList<>();

		if (root == null) {
			return list;
		}
		
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		q.add(null);

		List<Integer> tempList = new ArrayList<>();

		while (!q.isEmpty()) {
			Node t = q.poll();
			if (t != null) {
				tempList.add(t.val);
				List<Node> child = t.children;
				if (child != null && child.size() > 0) {
					q.addAll(child);
				}
			} else {
				list.add(tempList);
				if (!q.isEmpty()) {
					q.add(null);
					tempList = new ArrayList<>();
				}
			}

		}
		return list;
	}

	static class Node {
		public int val;
		public List<Node> children;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	};
}
