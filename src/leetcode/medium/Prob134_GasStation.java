package leetcode.medium;

public class Prob134_GasStation {

	public static void main(String[] args) {
		System.out.println(canCompleteCircuit(new int[] { 1, 2, 3, 4, 5 }, new int[] { 3, 4, 5, 1, 2 }));

	}

	static public int canCompleteCircuit(int[] gas, int[] cost) {
		int currGain = 0;
		int totalGain = 0;
		int candidate = 0;
		for (int i = 0; i < gas.length; i++) {
			currGain += gas[i] - cost[i];
			totalGain += gas[i] - cost[i];
			if (currGain < 0) {
				currGain = 0;
				candidate = i + 1;
			}
		}

		return totalGain >= 0 ? candidate : -1;
	}
}
