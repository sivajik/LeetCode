package leetcode.thirtydays.july21;

import java.util.ArrayList;
import java.util.List;

public class Day01_GrayCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static public List<Integer> grayCode(int n) {

		List<Integer> ans = new ArrayList<>();
		ans.add(0);
		for (int i = 0; i < n; i++) {
			for (int j = (int)Math.pow(2, i) - 1 /*ans.size()-1*/; j>=0 ;j--) {
				System.out.println(j + " , " + ans.get(j) + " , " +  (int) Math.pow(2, i));
				ans.add(ans.get(j) + (int) Math.pow(2, i));
			}
			System.out.println();
		}
		return ans;
	
	}
}
