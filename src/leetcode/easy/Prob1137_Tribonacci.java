package leetcode.easy;

public class Prob1137_Tribonacci {

	public static void main(String[] args) {
		System.out.println(tribonacci(25));
	}

	static java.util.Map<Integer, Integer> map = new java.util.HashMap<>();

	public static int tribonacci(int n) {
		if (n == 0) {
			map.put(0, 0);
			return 0;
		}
		if (n == 1 || n == 2) {
			map.put(n, 1);
			return 1;
		} else {
			if (map.containsKey(n)) {
				return map.get(n);
			} else {
				int res = tribonacci(n - 3) + tribonacci(n - 2) + tribonacci(n - 1);
				map.put(n, res);
			}
			return map.get(n);
		}
	}
}
