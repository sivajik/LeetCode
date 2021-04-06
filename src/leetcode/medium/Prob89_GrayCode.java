package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Prob89_GrayCode {

	public static void main(String[] args) {
		System.out.println(grayCode(4));

	}
/*
This problem is not complicated, we just need to find the regularity.
n = 1: (0, 1)-> (0,1);
n = 2: (00, 01, 11, 10)->(0, 1, 3, 2);
n = 3: (000, 001, 011, 010, 110, 111, 101, 100) -> (0, 1, 3, 2, 6, 7, 5, 4);

At first we compare n = 1 and n = 2. we find that :
0 appends (0,1) = (00, 01); 0 + 0 = 0, 0 + 1 = 1;
revese (0,1) -> (1, 0)
1 appends (1,0) = (11, 10); 2 + 1= 3, 2 + 0 = 2;

Then we compare n = 2 and n =3. we find that:
0 appends (00, 01, 11, 10) = (000, 001, 011, 010); 0 + 0 = 0, 0 + 1 = 1, 0 + 3 = 3, 0 + 2 = 2;
revese (00, 01, 11, 10) -> (10, 11, 01, 00)
1 appends (10, 11, 01, 00) = (110, 111, 101, 100); 4 + 2 = 6, 4 + 3 = 7, 4 + 1 = 5, 4 + 0 = 4;
The regularity is very obvious.
 
 */
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
