package leetcode.easy;

public class Prob657_RobotOrigin {

	public static void main(String[] args) {
		System.out.println(judgeCircle("UD"));
		System.out.println(judgeCircle("LL"));

	}

	public static boolean judgeCircle(String moves) {
		int hori = 0;
		int vert = 0;
		for (char c : moves.toCharArray()) {
			switch (c) {
			case 'L':
				hori = hori - 1;
				break;
			case 'R':
				hori = hori + 1;
				break;
			case 'U':
				vert = vert + 1;
				break;
			case 'D':
				vert = vert - 1;
				break;
			}
		}
		return hori == 0 && vert == 0;
	}
}
