package leetcode.revision.week01;

import java.util.HashMap;
import java.util.Map;

public class P106_PostorderInroder_BST {

	public static void main(String[] args) {
		TreeNode t = buildTree(new int[] { 9, 3, 15, 20, 7 }, new int[] { 9, 15, 7, 20, 3 });
		// TreeNode t = buildTree(new int[] { 1,2,3 }, new int[] { 3,2,1});
		inorder(t);
		System.out.println();
		postOrder(t);
	}

	private static void inorder(TreeNode t) {
		if (t != null) {
			inorder(t.left);
			System.out.print(t.val + " , ");
			inorder(t.right);
		}
	}

	private static void postOrder(TreeNode t) {
		if (t != null) {
			postOrder(t.left);
			postOrder(t.right);
			System.out.print(t.val + " , ");
		}
	}

	static public TreeNode buildTree(int[] inorder, int[] postOrder) {
		if (inorder == null || inorder.length == 0) {
			return null;
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}

		return helper(inorder, 0, inorder.length - 1, postOrder, 0, postOrder.length - 1, map);
	}

	private static TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postOder, int postStart, int postEnd,
			Map<Integer, Integer> map) {
		if (inStart > inEnd || postStart > postEnd) {
			return null;
		}

		int rootValue = postOder[postEnd];
		int rootIndex = map.get(rootValue);

		int leftInStart = inStart;
		int leftInEnd = rootIndex - 1;
		int leftPostStart = postStart;
		int leftPostEnd = leftPostStart + leftInEnd - leftInStart; // jst get this right.

		int rightInStart = rootIndex + 1;
		int rightInEnd = inEnd;
		int rightPostStart = leftPostEnd + 1; // will get this right automatically.
		int rightPostEnd = postEnd - 1;

		TreeNode root = new TreeNode(rootValue);

		root.left = helper(inorder, leftInStart, leftInEnd, postOder, leftPostStart, leftPostEnd, map);
		root.right = helper(inorder, rightInStart, rightInEnd, postOder, rightPostStart, rightPostEnd, map);

		return root;
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