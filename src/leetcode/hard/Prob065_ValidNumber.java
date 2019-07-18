package leetcode.hard;

public class Prob065_ValidNumber {

	public static void main(String[] args) {
		System.out.println(isNumber("959440.94f"));
		System.out.println(isNumber("11"));

	}
    public static boolean isNumber(String s) {
    	s = s.trim();
        try {
            if (s.indexOf(".") != -1) {
            	double value = Double.parseDouble(s);
            } else {
            	if (s.indexOf("e") != -1 && s.indexOf("e") == s.lastIndexOf("e")) {
            		String[] tokens = s.split("e");
            		if (tokens.length == 2) {
            			String left = tokens[0];
            			String right = tokens[1];
            			if (right.indexOf(".") != -1) {
            				return false;
            			} else {
                			Long leftLong = Long.parseLong(left);
                			Long rightLong = Long.parseLong(right);
            			}
            		} else {
            			return false;
            		}
            	} else {
                	long value = Long.parseLong(s);
            	}
            }
            return true;
        } catch (NumberFormatException nfe) {
        	return false;
        }
    }
}
