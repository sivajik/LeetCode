package leetcode.easy;

public class Prob509_FibonanciNumber {

	public static void main(String[] args) {
		for (int i = 0; i <= 30; i++) {
			System.out.println(i + " => " + fib(i));
		}

	}
    public static int fib(int N) {
        if (N == 0) {
        	return 0;
        } else if (N == 1) {
        	return 1;
        } else {
        	int[] results = new int[N + 1];
        	results[0] = 0;
        	results[1] = 1;
        	for (int i = 2; i <= N; i++) {
        		results[i] = results[i-1] + results[i-2];
        	}
        	return results[N];
        }
    }
}
