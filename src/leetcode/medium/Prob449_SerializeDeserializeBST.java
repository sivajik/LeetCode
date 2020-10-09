package leetcode.medium;

public class Prob449_SerializeDeserializeBST {

	public static void main(String[] args) {
		Codec ser = new Codec();
		Codec deser = new Codec();
		
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		
		String tree = ser.serialize(root);
		System.out.println(tree);
		
		TreeNode ans = deser.deserialize(tree);
		StringBuilder sbldr = new StringBuilder();
		deser.preOrder(root, sbldr);
		System.out.println(sbldr.toString());
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	static class Codec {

		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {
			if (root == null) {
				return new String();
			}
			StringBuilder sbldr = new StringBuilder();
			preOrder(root, sbldr);
			return sbldr.toString().trim();
		}

		public void preOrder(TreeNode root, StringBuilder sbldr) {
			if (root != null) {
				sbldr.append(root.val + " ");
				preOrder(root.left, sbldr);
				preOrder(root.right, sbldr);
			}
		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			if (data == null || data.length() == 0) {
				return null;
			}
			
			TreeNode root = null;
			String[] tokens = data.split(" ");
			for (int i = 0; i < tokens.length; i++) {
				int val = Integer.parseInt(tokens[i]);
				root = insertIntoBST(root, val);
			}
			return root;
		}

		private TreeNode insertIntoBST(TreeNode root, int val) {
			if (root == null) {
				return new TreeNode(val);
			} else {
				if (val < root.val) {
					root.left = insertIntoBST(root.left, val);
				} else {
					root.right = insertIntoBST(root.right, val);
				}
			}
			return root;

		}
	}
}
