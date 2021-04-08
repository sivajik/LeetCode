package leetcode.medium;

public class Prob702_SearchinaSortedArrayofUnknownSize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static public int search(ArrayReader reader, int target) {
		if (reader.get(0) == target) {
			return 0;
		}

		int left = 0;
		int right = 1;
		while (reader.get(right) < target) {
			left = right; // very important to keep left updated
			right = right * 2; // move right twice the speed.
		}

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (reader.get(mid) == target) {
				return mid;
			} else if (reader.get(mid) < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}

	static interface ArrayReader {
		public int get(int index);
	}
}
