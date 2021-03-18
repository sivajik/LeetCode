package leetcode.hard;

import java.util.Stack;

public class Prob297_SerializeandDeserializeBinaryTree {

	public static void main(String[] args) {
		Codec c = new Codec();

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		System.out.println(c.serialize(root));
		c.preOrder(c.deserialize("(1(2()())(3()()))"));

	}

	static class Codec {

		public String serialize(TreeNode root) {
			StringBuilder sbr = new StringBuilder();
			serHelper(root, sbr);
			return sbr.toString();
		}

		private void serHelper(TreeNode root, StringBuilder sbr) {
			sbr.append("(");
			if (root != null) {
				sbr.append(root.val);
				serHelper(root.left, sbr);
				serHelper(root.right, sbr);
			}
			sbr.append(")");
		}

		public TreeNode deserialize(String data) {
			int[] matchingBraces = new int[data.length()];
			Stack<Integer> openingIdxs = new Stack<>();
			for (int i = 0; i < data.length(); i++) {
				if (data.charAt(i) == '(') {
					openingIdxs.push(i);
				} else if (data.charAt(i) == ')') {
					matchingBraces[openingIdxs.pop()] = i;
				}
			}
			return deserializeHelper(data.toCharArray(), matchingBraces, 0, data.toCharArray().length - 1);
		}

		private TreeNode deserializeHelper(char[] tree, int[] matchingBraces, int lo, int hi) {

			if (hi - lo == 1) {
				return null; // important step
			}

			int val = 0;
			boolean isNegative = false;
			if (tree[lo + 1] == '-') {
				isNegative = true;
				lo = lo + 1;
			}

			while (tree[++lo] != '(') {
				val *= 10;
				val += tree[lo] - '0';
			}

			if (isNegative) {
				val = val * -1;
			}

			int leftEnd = matchingBraces[lo];
			TreeNode root = new TreeNode(val);
			root.left = deserializeHelper(tree, matchingBraces, lo, leftEnd);
			root.right = deserializeHelper(tree, matchingBraces, leftEnd + 1, hi - 1);
			return root;
		}

		public void preOrder(TreeNode root) {
			if (root != null) {
				System.out.print(root.val + " ");
				preOrder(root.left);
				preOrder(root.right);
			}
		}
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
