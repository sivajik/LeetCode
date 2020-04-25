package leetcode.thirtydays;

public class Day24_LRUCache {

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2 /* capacity */ );

		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1)); // returns 1
		cache.put(3, 3); // evicts key 2
		System.out.println(cache.get(2)); // returns -1 (not found)
		cache.put(4, 4); // evicts key 1
		System.out.println(cache.get(1)); // returns -1 (not found)
		System.out.println(cache.get(3)); // returns 3
		System.out.println(cache.get(4)); // returns 4
	}

}

class LRUCache {
	private java.util.LinkedHashMap<Integer, Integer> map;
	private int capacity;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.map = new java.util.LinkedHashMap<Integer, Integer>(this.capacity, 0.75f, true) {
			private static final long serialVersionUID = 1L;

			@Override
			protected boolean removeEldestEntry(java.util.Map.Entry eldest) {
				return size() > capacity;
			}
		};
	}

	public int get(int key) {
		return map.get(key) == null ? -1 : map.get(key);
	}

	public void put(int key, int value) {
		map.put(key, value);
	}
}