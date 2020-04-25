package leetcode.easy;

public class Prob1394_LuckyIntegerInArray {

	public static void main(String[] args) {
		System.out.println(findLucky(new int[] { 2, 2, 3, 4 }));
		System.out.println(findLucky(new int[] { 1, 2, 2, 3, 3, 3 }));
		System.out.println(findLucky(new int[] { 2, 2, 2, 3, 3 }));
		System.out.println(findLucky(new int[] { 5 }));
		System.out.println(findLucky(new int[] { 7, 7, 7, 7, 7, 7, 7 }));
	}

	public static int findLucky(int[] arr) {
		int[] temp = new int [501];
		for (int elem : arr) {
			temp[elem]++;
		}
		
		for (int i = 500; i >= 1; i--) {
			if (temp[i] == i) {
				return i;
			}
		}
		return -1;
		
	}
	public static int findLucky1(int[] arr) {
		java.util.Map<Integer, Integer> map = new java.util.TreeMap<Integer, Integer>();
		for (int a : arr) {
			map.put(a, map.getOrDefault(a, 0) + 1);
		}

		int maxKey = Integer.MIN_VALUE;
		java.util.Set<Integer> set = map.keySet();
		java.util.Iterator<Integer> itr = set.iterator();
		while (itr.hasNext()) {
			Integer key = itr.next();
			Integer val = map.get(key);
			if (key == val) {
				if (key > maxKey) {
					maxKey = key;
				}
			}
		}

		return maxKey == Integer.MIN_VALUE ? -1 : maxKey;
	}
}
