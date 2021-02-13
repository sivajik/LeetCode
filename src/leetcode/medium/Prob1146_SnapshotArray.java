package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class Prob1146_SnapshotArray {

	public static void main(String[] args) {

		SnapshotArray obj = new SnapshotArray(3);
		obj.set(0, 5);

		int param_2 = obj.snap();
		System.out.println(param_2);
		int param_3 = obj.get(0, 0);
		System.out.println(param_3);
	}

}

class SnapshotArray {
	Map<Integer, Integer> map;
	Map<Integer, Integer>[] internalArray;

	int cnt = -1;

	public SnapshotArray(int length) {
		this.map = new HashMap<>();
		this.internalArray = new HashMap[length];
		for (int i = 0; i < length; i++) {
			this.internalArray[i] = new HashMap<>();
		}
	}

	public void set(int index, int val) {
		this.map.put(index, val);
	}

	public int snap() {
		cnt++;
		// set map values to internalArray
		for (Map.Entry<Integer, Integer> m : map.entrySet()) {
			internalArray[m.getKey()].put(cnt, m.getValue());
		}
		// clear our map
		map = new HashMap<>();
		return cnt;
	}

	public int get(int index, int snap_id) {
		while (snap_id >= 0) {
			if (internalArray[index].containsKey(snap_id)) {
				return internalArray[index].get(snap_id);
			}
			snap_id--;
		}
		return 0;
	}
}