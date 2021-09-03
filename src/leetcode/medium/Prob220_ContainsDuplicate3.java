package leetcode.medium;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.*;

public class Prob220_ContainsDuplicate3 {

	public static void main(String[] args) {
		System.out.println(containsNearbyAlmostDuplicate(new int[] {1,2,3,1}, 3, 0));
		System.out.println(containsNearbyAlmostDuplicate(new int[] {1,0,1,1}, 1, 2));
		System.out.println(containsNearbyAlmostDuplicate(new int[] { 1, 5, 9, 1, 5, 9 }, 2, 3));
		System.out.println(containsNearbyAlmostDuplicate(new int[] { -1, 2147483647 }, 1, 2147483647));
	}

	static public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums.length <= 1 || t < 0 || k < 1) {
			return false;
		}

		TreeMap<Long, Long> map = new TreeMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put((long) i, (long) nums[i]);
		}

		for (Entry<Long, Long> entry : map.entrySet()) {
			Long currValue = entry.getValue();
			SortedMap<Long, Long> subMap = map.subMap(entry.getKey(), entry.getKey() + k + 1);

			for (Entry<Long, Long> eachSubMapEntry : subMap.entrySet()) {
				if (entry.getKey() != eachSubMapEntry.getKey()
						&& Math.abs(currValue - eachSubMapEntry.getValue()) <= t) {
					return true;
				}
			}
		}
		return false;
	}
}
