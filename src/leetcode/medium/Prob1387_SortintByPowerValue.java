package leetcode.medium;

public class Prob1387_SortintByPowerValue {

	public static void main(String[] args) {
		// System.out.println(getKth(12, 15, 2));
		// System.out.println(getKth(1, 1, 1));
		// System.out.println(getKth(7, 11, 4));
		// System.out.println(getKth(10, 20, 5));
		System.out.println(getKth(1, 1000, 777));
	}

	static public int getKth(int lo, int hi, int k) {
		java.util.List<Pair> l = new java.util.ArrayList<Pair>();
		for (int i = lo; i <= hi; i++) {
			l.add(new Pair(i, power(i)));
		}
		java.util.Collections.sort(l, new java.util.Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				if (o1.power == o2.power) {
					return o1.number - o2.number;
				}
				return o1.power - o2.power;
			}
		});
		System.out.println(l);
		return l.get(k - 1).number;
	}

	private static int power(int lo) {
		if (map.containsKey(lo)) {
			return map.get(lo);
		}

		if (lo == 1) {
			return 0;
		}
		if (lo % 2 == 0) {
			map.put(lo, 1 + power(lo / 2));
		}
		if (lo % 2 != 0) {
			map.put(lo, 1 + power((3 * lo) + 1));
		}
		return map.get(lo);
	}

	static java.util.Map<Integer, Integer> map = new java.util.HashMap<>();

	static class Pair {
		int number;
		int power;

		Pair(int number, int power) {
			this.number = number;
			this.power = power;
		}

		@Override
		public String toString() {
			return "Pair [number=" + number + ", power=" + power + "]";
		}

	}
}
