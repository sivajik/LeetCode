package leetcode.medium;

public class Prob863_AllNodesDistanceKInBinaryTree {

	public static void main(String[] args) {
		TreeNode root = prepareTree(new int[] { 3, 5, 1, 6, 2, 10, 8, 13, 19, 18, 14, 12, 16, 30, 33 });
		TreeNode target = null;

		buildGraph(root, null);

		for (java.util.Map.Entry<TreeNode, java.util.List<TreeNode>> entry : map.entrySet()) {
			if (5 == entry.getKey().val) {
				target = entry.getKey();
				break;
			}
		}

		System.out.println("=== Distance 0 ===");
		for (Integer i : distanceK(root, target, 0)) {
			System.out.print(i + " , ");
		}
		System.out.println("\n======");
		
		System.out.println("=== Distance 1 ===");
		for (Integer i : distanceK(root, target, 1)) {
			System.out.print(i + " , ");
		}
		System.out.println("\n======");		
		
		System.out.println("=== Distance 2 ===");
		for (Integer i : distanceK(root, target, 2)) {
			System.out.print(i + " , ");
		}
		System.out.println("\n======");
		
		System.out.println("=== Distance 3 ===");
		for (Integer i : distanceK(root, target, 3)) {
			System.out.print(i + " , ");
		}
		System.out.println("\n======");
		
		System.out.println("=== Distance 4 ===");
		for (Integer i : distanceK(root, target, 4)) {
			System.out.print(i + " , ");
		}
		System.out.println("\n======");
		
		System.out.println("=== Distance 5 ===");
		for (Integer i : distanceK(root, target, 5)) {
			System.out.print(i + " , ");
		}
		System.out.println("\n======");
	}

	static public java.util.List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
		map = new java.util.HashMap<>();

		java.util.List<Integer> l = new java.util.ArrayList<>();
		if (root == null) {
			return l;
		}

		if (K == 0 && target != null) {
			l.add(target.val);
			return l;
		}

		buildGraph(root, null);
		
		java.util.Queue<TreeNode> q = new java.util.LinkedList<>();
		q.add(target);

		java.util.Set<TreeNode> visited = new java.util.HashSet<>();
		visited.add(target);
		while (K > 0) {
			K--;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode temp = q.poll();
				for (TreeNode t : map.get(temp)) {
					if (t != target && !visited.contains(t)) {
						q.add(t);
						visited.add(t);
					}
				}
			}

			if (K == 0) {
				while (!q.isEmpty()) {
					l.add(q.poll().val);
				}
			}
		}
		return l;
	}

	static java.util.Map<TreeNode, java.util.List<TreeNode>> map = new java.util.HashMap<>();

	public static void buildGraph(TreeNode cur, TreeNode parent) {
		if (cur == null) {
			return;
		}
		if (map.containsKey(cur)) {
			return;
		} else {
			map.put(cur, new java.util.ArrayList<>());
		}

		if (parent != null) {
			map.get(cur).add(parent);
			map.get(parent).add(cur);
		}

		buildGraph(cur.left, cur);
		buildGraph(cur.right, cur);
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