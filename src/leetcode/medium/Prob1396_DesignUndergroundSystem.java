package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class Prob1396_DesignUndergroundSystem {

	public static void main(String[] args) {
		UndergroundSystem u = new UndergroundSystem();
		u.checkIn(45, "Leyton", 3);
		u.checkIn(32, "Paradise", 8);
		u.checkIn(27, "Leyton", 10);
		u.checkOut(45, "Waterloo", 15);
		u.checkOut(27, "Waterloo", 20);
		u.checkOut(32, "Cambridge", 22);
		u.getAverageTime("Paradise", "Cambridge");
		u.checkIn(10, "Leyton", 24);
		u.getAverageTime("Leyton", "Waterloo"); // return 11.00000
		u.checkOut(10, "Waterloo", 38);
		u.getAverageTime("Leyton", "Waterloo"); // return 12.00000

		System.out.println();

		UndergroundSystem undergroundSystem = new UndergroundSystem();
		undergroundSystem.checkIn(10, "Leyton", 3);
		undergroundSystem.checkOut(10, "Paradise", 8);
		undergroundSystem.getAverageTime("Leyton", "Paradise"); // return 5.00000
		undergroundSystem.checkIn(5, "Leyton", 10);
		undergroundSystem.checkOut(5, "Paradise", 16);
		undergroundSystem.getAverageTime("Leyton", "Paradise"); // return 5.50000
		undergroundSystem.checkIn(2, "Leyton", 21);
		undergroundSystem.checkOut(2, "Paradise", 30);
		undergroundSystem.getAverageTime("Leyton", "Paradise"); // return 6.66667
	}

}

class UndergroundSystem {
	Map<String, Map<Integer, Integer>> map = new HashMap<>();

	public UndergroundSystem() {
		//
	}

	public void checkIn(int id, String stationName, int t) {
		if (map.get(stationName) != null) {
			Map<Integer, Integer> innerMap = map.get(stationName);
			innerMap.put(id, t);
		} else {
			Map<Integer, Integer> innerMap = new HashMap<>();
			innerMap.put(id, t);
			map.put(stationName, innerMap);
		}
	}

	public void checkOut(int id, String stationName, int t) {
		if (map.get(stationName) != null) {
			Map<Integer, Integer> innerMap = map.get(stationName);
			innerMap.put(id, t);
		} else {
			Map<Integer, Integer> innerMap = new HashMap<>();
			innerMap.put(id, t);
			map.put(stationName, innerMap);
		}
	}

	public double getAverageTime(String startStation, String endStation) {
		Map<Integer, Integer> innerMap1 = map.get(startStation);
		Map<Integer, Integer> innerMap2 = map.get(endStation);

		long count = 0;
		long sum = 0;
		for (Map.Entry<Integer, Integer> entry : innerMap1.entrySet()) {
			int id = entry.getKey();
			int time = entry.getValue();

			if (innerMap2.containsKey(id) && innerMap2.get(id) > time) {
				count++;
				sum += (innerMap2.get(id) - time);
			}
		}
		System.out.println(((double) sum) / count);
		return ((double) sum) / count;
	}
}