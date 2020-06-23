package leetcode.easy;

public class Prob441_ArrangingCoins {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(i + " -> " + arrangeCoins(i));
		}
	}

	static public int arrangeCoins(int n) {
		if (n == 0) {
			return 0;
		}

		int counter = 1;
		while (n > 0 && n - counter >= 0) {
			n = n - counter;
			counter++;
		}
		return counter - 1;
	}
}
