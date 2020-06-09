package leetcode.medium;

import java.util.List;

public class Prob1104_ZigzagPath {

	public static void main(String[] args) {
		for (int i = 1; i < 15; i++) {
			System.out.println(pathInZigZagTree(i));
		}
	}

	static public List<Integer> pathInZigZagTree(int label) {
		java.util.List<Integer> list = new java.util.ArrayList<>();

		int totalLevels = 0;
		while (label > 0) {
			list.add(label);
			label /= 2;
			totalLevels++;
		}

		for (int i = 1; i < list.size(); i += 2) {
			list.set(i, getMirrorOf(list.get(i), totalLevels - i));
		}

		java.util.List<Integer> list1 = new java.util.ArrayList<>();
		for (int i : list) {
			list1.add(0, i);
		}
		return list1;
	}

	static private Integer getMirrorOf(Integer i, int level) {
		if (i == 1) {
			return 1;
		}

		int low = (int) Math.pow(2, level - 1);
		int high = (int) (Math.pow(2, level) - 1);
		int diff = Math.abs(i - low);
		return high - diff;
	}
}
