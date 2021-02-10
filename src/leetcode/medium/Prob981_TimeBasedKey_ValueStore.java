package leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Prob981_TimeBasedKey_ValueStore {

	public static void main(String[] args) {
		// ["TimeMap","get","get","get","get","get"]
		// [[],,]
		TimeMap t = new TimeMap();
		t.set("love", "high", 10);
		t.set("love", "low", 20);

		System.out.println(t.get("love", 5));
		System.out.println(t.get("love", 10));
		System.out.println(t.get("love", 15));
		System.out.println(t.get("love", 20));
		System.out.println(t.get("love", 25));
	}

	static class TimeMap {
		Map<String, TreeMap<Integer, String>> map = null;

		public TimeMap() {
			this.map = new HashMap<>();
		}

		public void set(String key, String value, int timestamp) {
			if (!map.containsKey(key)) {
				map.put(key, new TreeMap<>());
			}
			map.get(key).put(timestamp, value);
		}

		public String get(String key, int timestamp) {
			if (!map.containsKey(key)) {
				return "";
			}
			TreeMap<Integer, String> tree = map.get(key);
			// out of all get the max timestamp.
			Integer tStamp = tree.floorKey(timestamp);
			if (tStamp != null) {
				return tree.get(tStamp);
			} else {
				return "";
			}
		}
	}
}
