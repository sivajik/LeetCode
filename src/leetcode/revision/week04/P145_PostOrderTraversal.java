package leetcode.revision.week04;

import java.util.*;

public class P145_PostOrderTraversal {

	public static void main(String[] args) {

	}

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		
		Stack<TreeNode> s = new Stack<>();
		s.push(root);
		
		Stack<TreeNode> t = new Stack<>();
		
		while (!s.isEmpty()) {
			TreeNode temp = s.pop();
			t.push(temp);
			
			if (temp.left != null) {
				s.push(temp.left);
			}
			if (temp.right != null) {
				s.push(temp.right);
			}
		}
		List<Integer> re = new ArrayList<>();
		while (!t.isEmpty()) {
			re.add(t.pop().val);
		}
		
		return re;
	}

	public static TreeNode prepareTree(int[] values) {
		TreeNode[] treeArray = new TreeNode[values.length];
		for (int i = 0; i < values.length; i++) {
			if (values[i] == -999) {
				treeArray[i] = null;
			} else {
				treeArray[i] = new TreeNode(values[i]);
			}
		}

		for (int i = 0; i < values.length; i++) {
			TreeNode node = treeArray[i];
			if (((2 * i) + 1 < values.length) && ((2 * i) + 2 < values.length)) {
				node.left = treeArray[(2 * i) + 1];
				node.right = treeArray[(2 * i) + 2];
			}
		}
		return treeArray[0];
	}

	public static void inOrder(TreeNode tree) {
		if (tree != null) {
			inOrder(tree.left);
			System.out.print(tree.val + " ");
			inOrder(tree.right);
		}
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

}
