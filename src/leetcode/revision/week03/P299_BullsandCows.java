package leetcode.revision.week03;

public class P299_BullsandCows {

	public static void main(String[] args) {
		System.out.println(getHint("1807", "7810").equals("1A3B"));
		System.out.println(getHint("1123", "0111").equals("1A1B"));
		System.out.println(getHint("1", "0").equals("0A0B"));
		System.out.println(getHint("1", "1").equals("1A0B"));
		System.out.println(getHint("1122", "1222").equals("3A0B"));
	}

	static public String getHint(String secret, String guess) {
		int[] digits = new int[10];
		int bullsCounter = 0, cowsCounter = 0;

		for (int i = 0; i < secret.length(); i++) {
			if (guess.charAt(i) == secret.charAt(i)) {
				bullsCounter++;
			} else {
				if (digits[secret.charAt(i) - '0']++ < 0) {
					cowsCounter++;
				}
				if (digits[guess.charAt(i) - '0']-- > 0) {
					cowsCounter++;
				}
			}
		}
		return bullsCounter + "A" + cowsCounter + "B";
	}

}
