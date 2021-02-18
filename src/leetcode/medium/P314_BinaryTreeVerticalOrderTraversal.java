package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class P314_BinaryTreeVerticalOrderTraversal {

	public static void main(String[] args) {
		for (List<Integer> l : verticalOrder(prepareTree(new int[] { 3, 9, 8, 4, 0, 1, 7 }))) {
			System.out.println(l);
		}

	}

	static class MyNode {
        TreeNode node;
        int col;
        
        public MyNode(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }
    
    public static List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<MyNode> q = new LinkedList<>();
        q.add(new MyNode(root, 0));
        
        while (!q.isEmpty()) {
            MyNode nd = q.poll();
            map.putIfAbsent(nd.col, new ArrayList());
            map.get(nd.col).add(nd.node.val);

            if (nd.node.left != null) {
                q.add(new MyNode(nd.node.left, nd.col - 1));
            }
            if (nd.node.right != null) {
                q.add(new MyNode(nd.node.right, nd.col + 1));
            }
        }

        return new ArrayList<>(map.values());
    }
    /*
	static public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> l = new ArrayList<>();

		if (root == null) {
			return l;
		}
		TreeMap<Integer, List<Integer>> m = new TreeMap<>();
		preOrder(root, m, 0);
		for (List<Integer> ll : m.values()) {
			l.add(ll);
		}
		return l;
	}

	private static void preOrder(TreeNode root, TreeMap<Integer, List<Integer>> m, int col) {
		if (root != null) {
			if (!m.containsKey(col)) {
				m.put(col, new ArrayList<>());
			}
			m.get(col).add(root.val);
			preOrder(root.left, m, col - 1);
			preOrder(root.right, m, col + 1);
		}
	}*/

	// --
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
