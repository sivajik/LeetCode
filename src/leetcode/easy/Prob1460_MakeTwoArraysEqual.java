package leetcode.easy;

public class Prob1460_MakeTwoArraysEqual {

	public static void main(String[] args) {
		System.out.println(canBeEqual(new int[] { 1, 2, 3, 4 }, new int[] { 2, 4, 1, 3 }));

	}

	static public boolean canBeEqual1(int[] target, int[] arr) {
		java.util.Arrays.sort(target);
		java.util.Arrays.sort(arr);
		return java.util.Arrays.equals(target, arr);
	}
	
	
	static public boolean canBeEqual(int[] target, int[] arr) {
		if (target.length != arr.length) {
			return false;
		}
		
		int[] X = new int[1001]; // 1000 is max
		
		for (int i = 0; i < target.length; i++) {
			X[target[i]]++;
			X[arr[i]]--;
		}
		for (int x : X) {
			if (x != 0) {
				return false;
			}
		}
		return true;
	}
}
