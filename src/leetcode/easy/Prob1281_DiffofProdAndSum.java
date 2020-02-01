package leetcode.easy;

public class Prob1281_DiffofProdAndSum {

	public static void main(String[] args) {
		System.out.println(subtractProductAndSum(234));
		System.out.println(subtractProductAndSum(4421));
	}

	public static int subtractProductAndSum(int n) {
		int sum = 0;
		int prod = 1;
		while (n > 0) {
			int digit =  n % 10;
			n = n / 10;
			
			prod *= digit;
			sum += digit;
		}
		return prod-sum;
	}
}
