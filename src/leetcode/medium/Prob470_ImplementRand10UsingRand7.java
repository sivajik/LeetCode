package leetcode.medium;

public class Prob470_ImplementRand10UsingRand7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static public int rand10() {
		int row, col, index;

		do {
			row = rand7(); // say 4
			col = rand7(); // say 3
			index = col + (row - 1) * 7;// index = 24
		} while (index > 40);

		// index is < 40;
		return (index - 1) % 10 + 1; // do -1 and +1 so that you start at 1 not ZERO
	}

	static public int rand7() {
		return -1;
	}
}
