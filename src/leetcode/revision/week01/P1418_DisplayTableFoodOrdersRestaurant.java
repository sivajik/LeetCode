package leetcode.revision.week01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class P1418_DisplayTableFoodOrdersRestaurant {

	public static void main(String[] args) {
		List<List<String>> f = new ArrayList<>();

		String[][] ip = new String[][] { { "David", "3", "Ceviche" }, { "Corina", "10", "Beef Burrito" },
				{ "David", "3", "Fried Chicken" }, { "Carla", "5", "Water" }, { "Carla", "5", "Ceviche" },
				{ "Rous", "3", "Ceviche" } };

		for (String[] a : ip) {
			List<String> row = new ArrayList<>();
			row.add(a[0]);
			row.add(a[1]);
			row.add(a[2]);
			f.add(row);
		}

		for (List<String> l : displayTable(f)) {
			System.out.println(l);
		}
	}

	static public List<List<String>> displayTable(List<List<String>> orders) {
		if (orders == null || orders.size() == 0) {
			new ArrayList<>();
		}
		Set<String> allDishes = new TreeSet<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		});

		Map<Integer, Map<String, Integer>> map = new TreeMap<>();

		for (List<String> eachOrder : orders) {
			String tableNumStr = eachOrder.get(1);
			Integer tableNum = Integer.parseInt(tableNumStr);
			String dishName = eachOrder.get(2);

			allDishes.add(dishName);

			if (!map.containsKey(tableNum)) {
				Map<String, Integer> items = new HashMap<>();
				items.put(dishName, 1);
				map.put(tableNum, items);
			} else {
				Map<String, Integer> items = map.get(tableNum);
				if (items.containsKey(dishName)) {
					items.put(dishName, 1 + items.get(dishName));
				} else {
					items.put(dishName, 1);
				}
			}
		}

		List<List<String>> res = new ArrayList<>();

		List<String> header = new ArrayList<>();
		int i = 0;
		header.add(i++, "Table");
		for (String eachDishName : allDishes) {
			header.add(i++, eachDishName);
		}
		res.add(header);

		i = 1;
		for (Map.Entry<Integer, Map<String, Integer>> entry : map.entrySet()) {
			Integer tableNum = entry.getKey();
			Map<String, Integer> disAndCount = map.get(tableNum);

			List<String> eachRow = new ArrayList<>();
			int colIndex = 0;
			eachRow.add(colIndex++, tableNum.toString());

			for (String eachDishName : allDishes) {
				if (disAndCount.get(eachDishName) != null) {
					eachRow.add(colIndex++, disAndCount.get(eachDishName).toString());
				} else {
					eachRow.add(colIndex++, new String("0"));
				}
			}
			res.add(i++, eachRow);
		}
		return res;
	}
}
