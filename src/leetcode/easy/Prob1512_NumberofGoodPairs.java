package leetcode.easy;

public class Prob1512_NumberofGoodPairs {

	public static void main(String[] args) {
		System.out.println(numIdenticalPairs(new int[] { 1, 2, 3, 1, 1, 3 }));
		System.out.println(numIdenticalPairs(new int[] { 1, 1, 1, 1 }));
		System.out.println(numIdenticalPairs(new int[] { 1, 2, 3 }));
	}

	static public int numIdenticalPairs(int[] nums) {
		int sum = 0;
		java.util.Map<Integer, Integer> map = new java.util.HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		for (int key : map.keySet()) {
			if (map.get(key) > 1) {
				int freq = map.get(key);
				sum += ((freq) * (freq - 1)) / 2;
			}
		}
		return sum;
	}
}
