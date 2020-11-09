package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Prob1333_FilterRestaurants {

	public static void main(String[] args) {
		System.out.println(filterRestaurants(new int[][] { { 1, 4, 1, 40, 10 }, { 2, 8, 0, 50, 5 }, { 3, 8, 1, 30, 4 },
				{ 4, 10, 0, 10, 3 }, { 5, 1, 1, 15, 1 } }, 1, 50, 10));

		System.out.println(filterRestaurants(new int[][] { { 1, 4, 1, 40, 10 }, { 2, 8, 0, 50, 5 }, { 3, 8, 1, 30, 4 },
				{ 4, 10, 0, 10, 3 }, { 5, 1, 1, 15, 1 } }, 0, 50, 10));

		System.out.println(filterRestaurants(new int[][] { { 1, 4, 1, 40, 10 }, { 2, 8, 0, 50, 5 }, { 3, 8, 1, 30, 4 },
				{ 4, 10, 0, 10, 3 }, { 5, 1, 1, 15, 1 } }, 0, 30, 3));
	}

	static public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice,
			int maxDistance) {
		List<Integer> res = new ArrayList<>();

		List<Rest> r = new ArrayList<>();
		for (int[] eachRow : restaurants) {
			if (veganFriendly == 1) {
				if (eachRow[2] == 0) {
					continue;
				}
			}
			if (eachRow[3] <= maxPrice && eachRow[4] <= maxDistance) {
				r.add(new Rest(eachRow));
			}
		}

		Collections.sort(r, new Comparator<Rest>() {

			@Override
			public int compare(Rest o1, Rest o2) {
				if (o1.rating == o2.rating) {
					return -o1.id + o2.id;
				} else {
					return -o1.rating + o2.rating;
				}
			}
		});
		for (Rest rest : r) {
			res.add(rest.id);
		}
		return res;
	}

	static class Rest {
		int id;
		int rating;
		int vegan;
		int price;
		int dist;

		public Rest(int[] data) {
			super();
			this.id = data[0];
			this.rating = data[1];
			this.vegan = data[2];
			this.price = data[3];
			this.dist = data[4];
		}

	}
}
