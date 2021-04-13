package leetcode.medium;
import java.util.TreeMap;

public class Prob1705_MaximumNumberofEatenApples {

	public static void main(String[] args) {
		System.out.println(eatenApples(new int[] {1,2,3,5,2}, new int[] {3,2,1,4,2}));

	}
	static  public int eatenApples(int[] apples, int[] days) {
	       
			TreeMap<Integer, Integer> map = new TreeMap<>();
			int count = 0;
			for (int currDay = 0; currDay < apples.length || map.higherKey(currDay) != null; currDay++) {
				// calculate the expiry of apples received on currentDay and update map
				if (currDay < apples.length) {
					int currExp = currDay + days[currDay];
					map.put(currExp, map.getOrDefault(currExp, 0) + apples[currDay]);
				}

				// eat apple and update counts
				Integer latestExpiryDay = map.higherKey(currDay);
				if (latestExpiryDay != null) {
					count++;
					if (map.get(latestExpiryDay) > 1) {
						map.put(latestExpiryDay, map.get(latestExpiryDay) - 1);
					} else {
						map.remove(latestExpiryDay);
					}
				}
			}
			return count;
		 
	    }
}
