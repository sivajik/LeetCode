package leetcode.medium;

public class Prob846_HandofStraights {

	public static void main(String[] args) {
		System.out.println(isNStraightHand(new int[] { 1, 2, 3, 6, 2, 3, 4, 7, 8 }, 3));
		System.out.println(isNStraightHand(new int[] { 1, 2, 3, 4, 5 }, 4));
	}

	static public boolean isNStraightHand(int[] hand, int W) {
		if (hand.length % W != 0) {
			return false;
		}

		java.util.TreeMap<Integer, Integer> map = new java.util.TreeMap<>();
		for (int val : hand) {
			if (!map.containsKey(val)) {
				map.put(val, 1);
			} else {
				map.replace(val, 1 + map.get(val));
			}
		}

		while (!map.isEmpty()) {
			int lowestKey = map.firstKey();
			for (int i = lowestKey; i < lowestKey + W; i++) {
				if (!map.containsKey(i)) {
					return false;
				} else {
					if (map.get(i) == 1) {
						map.remove(i);
					} else {
						map.replace(i, map.get(i) - 1);
					}
				}
			}
		}
		return true;
	}
}
