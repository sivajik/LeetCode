package leetcode.thirtydays.sep;

public class Day13_LenOfLastWord {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.lengthOfLastWord("a"));
	}

}


class Solution {
    public int lengthOfLastWord(String s) {
    	s = s.trim();
    	if (s.indexOf(" ") != -1) {
    		int count = 0;
        	int i = s.length()-1;
        	for (; i >0; i--) {
        		if (s.charAt(i) != ' ') {
        			count++;
        		} else {
        			break;
        		}
        	}
        	return count;
    	} else {
    		return s.length();
    	}
    }
}