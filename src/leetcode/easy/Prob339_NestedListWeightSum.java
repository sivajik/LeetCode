package leetcode.easy;

import java.util.List;

public class Prob339_NestedListWeightSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static int sum = 0;

	static public int depthSum(List<NestedInteger> nestedList) {
		helper(nestedList, 1);
		return sum;
	}

	private static void helper(List<NestedInteger> nestedList, int level) {
		for (NestedInteger n : nestedList) {
			if (n.isInteger()) {
				sum += n.getInteger() * level;
			} else {
				helper(n.getList(), level + 1);
			}
		}
	}
}

class NestedInteger {
	// Constructor initializes an empty nested list.
	public NestedInteger() {

	}

	// Constructor initializes a single integer.
	public NestedInteger(int value) {

	}

	// @return true if this NestedInteger holds a single integer, rather than a
	// nested list.
	public boolean isInteger() {
		return false;
	}

	// @return the single integer that this NestedInteger holds, if it holds a
	// single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger() {
		return null;
	}

	// Set this NestedInteger to hold a single integer.
	public void setInteger(int value) {
	}

	// Set this NestedInteger to hold a nested list and adds a nested integer to it.
	public void add(NestedInteger ni) {
	}

	// @return the nested list that this NestedInteger holds, if it holds a nested
	// list
	// Return empty list if this NestedInteger holds a single integer
	public List<NestedInteger> getList() {
		return null;
	}
}