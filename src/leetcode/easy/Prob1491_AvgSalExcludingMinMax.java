package leetcode.easy;

public class Prob1491_AvgSalExcludingMinMax {

	public static void main(String[] args) {
		System.out.println(average(new int[] {4000,3000,1000,2000}));
		System.out.println(average(new int[] {1000,2000,3000}));
		System.out.println(average(new int[] {6000,5000,4000,3000,2000,1000}));
		System.out.println(average(new int[] {8000,9000,2000,3000,6000,1000}));
	}
	// 28%
	static public double average1(int[] salary) {
		double avg = 0;
		java.util.Arrays.sort(salary);

		for (int i = 1; i < salary.length - 1; i++) {
			avg += salary[i];
		}
		return avg / (salary.length - 2);
	}
	// 100%
	static public double average(int[] salary) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		double avg = 0;
		for (int sal : salary) {
			if (sal < min) {
				min = sal;
			}
			if (sal > max) {
				max = sal;
			}
			avg += sal;
		}
		return (avg-min-max) / (salary.length - 2);
	}
}
