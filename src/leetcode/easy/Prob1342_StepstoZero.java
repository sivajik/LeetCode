package leetcode.easy;

public class Prob1342_StepstoZero {

	public static void main(String[] args) {
		System.out.println(numberOfSteps(14));
		System.out.println(numberOfSteps(8));
	}

    public static int numberOfSteps (int num) {
        int counter = 0;
        
        while (num != 0) {
        	if (num % 2 == 1) {
        		num--;
        	} else {
        		num = num / 2;
        	}
    		counter++;        	
        }
    	return counter;
    }
}
