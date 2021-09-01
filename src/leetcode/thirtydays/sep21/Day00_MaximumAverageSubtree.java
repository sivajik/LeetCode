package leetcode.thirtydays.sep21;

class NodeState {
	int count;
	int sum;
	double avg;

	public NodeState(int count, int sum, double avg) {
		super();
		this.count = count;
		this.sum = sum;
		this.avg = avg;
	}

}

public class Day00_MaximumAverageSubtree {

	public static void main(String[] args) {
		System.out.println(maximumAverageSubtree(prepareTree(new int[] { 5, 6, 1 })));
		System.out.println(maximumAverageSubtree(prepareTree(new int[] { 2, -999, 1 })));
	}

	static public double maximumAverageSubtree(TreeNode root) {
		return util(root).avg;
	}

	static public NodeState util(TreeNode root) {
		if (root == null) {
			return new NodeState(0, 0, 0);
		}

		NodeState le = util(root.left);
		NodeState ri = util(root.right);

		int count = le.count + ri.count + 1;
		int sum = le.sum + ri.sum + root.val;
		double avg = Math.max(((1.0) * sum) / count, Math.max(le.avg, ri.avg));
		return new NodeState(count, sum, avg);
	}

	// ======
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

	public static void inOrder(TreeNode root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.val + " ");
			inOrder(root.right);
		}
	}

	static class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;

		public TreeNode(int val) {
			super();
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}
}
