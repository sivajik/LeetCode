package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Prob285_InorderSuccessorinBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		TreeNode succ = null;
		while (root != null) {
			if (p.val >= root.val) { // even in equal case go to right
				root = root.right;
			} else {
				succ = root;
				root = root.left;
			}
		}
		return succ;
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
		List<TreeNode> list = new ArrayList<>();
		helper1(root, list);
		int index = list.indexOf(p);
		if (index == list.size() - 1) {
			return null;
		} else {
			return list.get(1 + index);
		}
	}

	public void helper1(TreeNode root, List<TreeNode> list) {
		if (root != null) {
			helper1(root.left, list);
			list.add(root);
			helper1(root.right, list);
		}
	}
}
