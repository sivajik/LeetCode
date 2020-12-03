package leetcode.revision.week02;

import java.util.Map;
import java.util.TreeMap;

public class P1570_DotProductofTwoSparseVector {

	public static void main(String[] args) {
		SparseVector v1 = new SparseVector(new int[] {1,0,0,2,3});
		SparseVector v2 = new SparseVector(new int[] {0,3,0,4,0});
		System.out.println(v1.dotProduct(v2));
	}

}

class SparseVector {
	Map<Integer, Integer> map = new TreeMap<>();

	SparseVector(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				map.put(i, nums[i]);
			}
		}
	}

	public int dotProduct(SparseVector vec) {
		int res = 0;
		Map<Integer, Integer> tempMap = vec.map.size() > this.map.size() ? this.map : vec.map;
		for (Map.Entry<Integer, Integer> eSet : tempMap.entrySet()) {
			int index = eSet.getKey();
			if (vec.map.containsKey(index) && this.map.containsKey(index)) {
				res += (vec.map.get(index) * this.map.get(index));
			}
		}
		return res;
	}

}