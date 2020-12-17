package leetcode.revision.week01;

import java.util.HashMap;
import java.util.Map;

public class P105_PreorderInroder_BST {

	public static void main(String[] args) {
		// TreeNode t = buildTree(new int[] { 3, 9, 20, 15, 7 }, new int[] { 9, 3, 15, 20, 7 });
		TreeNode t = buildTree(new int[] { 1,2,3 }, new int[] { 3,2,1});
		preorder(t);
		System.out.println();
		inorder(t);
		
	}

	private static void inorder(TreeNode t) {
		if (t != null) {
			inorder(t.left);
			System.out.print(t.val + " , ");
			inorder(t.right);
		}
	}

	private static void preorder(TreeNode t) {
		if (t != null) {
			System.out.print(t.val + " , ");
			preorder(t.left);
			preorder(t.right);
		}
	}

	static public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (inorder == null || inorder.length == 0) {
			return null;
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}

		return helper(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1, map);
	}

	private static TreeNode helper(int[] inorder, int inStart, int inEnd, int[] preorder, int preStart, int preEnd,
			Map<Integer, Integer> map) {
		if (inStart > inEnd || preStart > preEnd) {
			return null;
		}

		int rootValue = preorder[preStart];
		int rootIndex = map.get(rootValue);

		int leftInStart = inStart;
		int leftInEnd = rootIndex - 1;
		int leftPreStart = preStart + 1;
		int leftPreEnd = leftPreStart + leftInEnd - leftInStart; // jst get this right.

		int rightInStart = rootIndex + 1;
		int rightInEnd = inEnd;
		int rightPreStart = leftPreEnd + 1; // will get this right automatically.
		int rightPreEnd = preEnd;

		TreeNode root = new TreeNode(rootValue);

		root.left = helper(inorder, leftInStart, leftInEnd, preorder, leftPreStart, leftPreEnd, map);
		root.right = helper(inorder, rightInStart, rightInEnd, preorder, rightPreStart, rightPreEnd, map);

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