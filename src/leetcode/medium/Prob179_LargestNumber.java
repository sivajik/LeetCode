package leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

public class Prob179_LargestNumber {

	public static void main(String[] args) {
		System.out.println(largestNumber(new int[] { 10, 2 }));
		System.out.println(largestNumber(new int[] { 3, 5, 9, 30, 34 }));
		System.out.println(largestNumber(new int[] { 0,0 }));
	}

	static public String largestNumber(int[] nums) {
		String[] arr = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			arr[i] = String.valueOf(nums[i]);
		}

		Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String order1 = o1 + o2;
				String order2 = o2 + o1;
				return order2.compareTo(order1);
			}
		});

        if (arr[0].equals("0")) {
            return "0";
        }
        
		StringBuilder sbr = new StringBuilder();
		for (String s : arr) {
			sbr.append(s);
		}
		return sbr.toString();
	}
}
