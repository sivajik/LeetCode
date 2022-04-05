package leetcode.g5.easy;

public class Prob2103_RingsAndRods {

	public static void main(String[] args) {
		System.out.println(countPoints("B0B6G0R6R0R6G9"));
		System.out.println(countPoints("B0R0G0R9R0B0G0"));
		System.out.println(countPoints("G4"));
		System.out.println(countPoints("B7R5B3G5B1R2B8"));
	}

	static public int countPoints(String rings) {
		int[][] res = new int[10][3]; // 10 rods, 3 colors (RGB)
		char[] tkns = rings.toCharArray();
		for (int i = 0; i < tkns.length; i += 2) {
			int colorIndex = tkns[i] == 'R' ? 0 : (tkns[i] == 'G' ? 1 : 2);
			int rodNumber = (int) (tkns[i + 1] - '0');
			res[rodNumber][colorIndex]++;
		}
		int total = 0;
		for (int[] eachRod : res) {
			if (eachRod[0] > 0 && eachRod[1] > 0 && eachRod[2] > 0) {
				total++;
			}
		}
		return total;
	}
}
