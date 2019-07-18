package leetcode.easy;

public class Prob038_CountAndSay {

	public static void main(String[] args) {
		String start = "1";
		String[] tokens = start.split("[0-9]{");
		for (String token : tokens) {
			System.out.println(token);
		}

	}
    public static String countAndSay(int n) {
        int count = 0;
        String start = "1";
    	while (count < n) {
    		String[] tokens = start.split("[0-9]{1,*}"); 
    	}
    	
    	
    	return "";
    }
}
