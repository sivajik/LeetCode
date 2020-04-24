package leetcode.medium;

public class Prob201_BitwiseAnd {

	public static void main(String[] args) {
		System.out.println(rangeBitwiseAnd(5, 7));
		System.out.println(rangeBitwiseAnd(0, 1));
	}
    public static int rangeBitwiseAnd(int m, int n) {
        while(n>m)
           n = n & n-1;
        return m&n;
	
    }
}
