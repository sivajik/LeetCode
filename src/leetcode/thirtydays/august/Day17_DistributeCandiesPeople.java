package leetcode.thirtydays.august;

import java.util.Arrays;

public class Day17_DistributeCandiesPeople {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(distributeCandies(7, 4)));
		System.out.println(Arrays.toString(distributeCandies(10, 3)));
		System.out.println(Arrays.toString(distributeCandies(1, 4)));
	}

	static public int[] distributeCandies(int candies, int num_people) {
		int[] r = new int[num_people];
		int index = 0;
		int counter = 1;
		while (candies > 0) {
			r[index] += Math.min(counter, candies);
			index = (index + 1) % num_people;
			candies = candies - counter;
			counter++;
		}

		return r;
	}
}
