package leetcode.medium;

public class Prob1395_CountNumberOfTeams {

	public static void main(String[] args) {
		System.out.println(numTeams(new int[] { 2, 5, 3, 4, 1 }));
		System.out.println(numTeams(new int[] { 2, 1, 3 }));
		System.out.println(numTeams(new int[] { 1, 2, 3, 4 }));
	}

	static public int numTeams(int[] rating) {
		int c = 0;
		for (int i = 0; i < rating.length; i++) {
			for (int j = i + 1; j < rating.length; j++) {
				for (int k = j + 1; k < rating.length; k++) {
					if ((rating[i] < rating[j] && rating[j] < rating[k])
							|| (rating[i] > rating[j] && rating[j] > rating[k])) {
						// System.out.print(i + "," + j + "," + k + " => ");
						// System.out.println(rating[i] + "," + rating[j] + "," + rating[k]);
						c++;
					}
				}
			}
		}

		return c;
	}
}
