package leetcode.thirtydays.june;

public class Day10_InsDelGetrandom {

	public static void main(String[] args) {
		RandomizedSet obj = new RandomizedSet();

		boolean param_1 = obj.insert(0);
		System.out.println(param_1);

		int param_3 = obj.getRandom();
		System.out.println(param_3);

		boolean param_2 = obj.remove(0);
		System.out.println(param_2);

		boolean param_4 = obj.insert(0);
		System.out.println(param_4);
	}

}

class RandomizedSet {
	java.util.Map<Integer, Integer> map;
	java.util.List<Integer> list;
	java.util.Random rand;

	/** Initialize your data structure here. */
	public RandomizedSet() {
		this.map = new java.util.HashMap<>();
		this.list = new java.util.ArrayList<>();
		this.rand = new java.util.Random();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already contain
	 * the specified element.
	 */
	public boolean insert(int val) {
		if (map.containsKey(val)) {
			return false;
		}
		map.put(val, list.size()); // first element goes as 0
		list.add(val);
		return true;
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the specified
	 * element.
	 */
	public boolean remove(int val) {
		if (!map.containsKey(val)) {
			return false;
		}

        int index = map.get(val);
        int lastElement = list.get(list.size() - 1);
        list.set(index, lastElement);
        map.put(lastElement, index);
        list.remove(list.size() - 1);
        map.remove(val);
		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		if (list.size() > 0) {
			return list.get(rand.nextInt(list.size()));
		}
		return -1;
	}
}