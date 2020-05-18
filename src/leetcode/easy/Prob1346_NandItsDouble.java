package leetcode.easy;

public class Prob1346_NandItsDouble {

	public static void main(String[] args) {
		System.out.println(checkIfExist(new int[] { 10, 2, 5, 3 }));
		System.out.println(checkIfExist(new int[] { 7, 1, 14, 11 }));
		System.out.println(checkIfExist(new int[] { 3, 1, 7, 11 }));

	}

	public static boolean checkIfExist(int[] arr) {
		java.util.Map<Integer, Integer> map = new java.util.HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], i);
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i] * 2) && map.get(arr[i] * 2) != i) {
				return true;
			}
		}
		return false;
	}

	public static boolean checkIfExist1(int[] arr) {
		java.util.Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			int lookForDouble = java.util.Arrays.binarySearch(arr, 2 * arr[i]);
			if (lookForDouble >= 0 && lookForDouble != i) {
				return true;
			}
		}
		return false;
	}
}
