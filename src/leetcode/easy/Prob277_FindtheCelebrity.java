package leetcode.easy;

public class Prob277_FindtheCelebrity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static  public int findCelebrity(int n) {
		int possibleCelebrityCandidate = 0;
		for (int i = 0; i < n; i++) {
			if (knows(possibleCelebrityCandidate, i)) {
				possibleCelebrityCandidate = i;
			}
		}
		
		if (isCelebrity(possibleCelebrityCandidate, n)) {
			return possibleCelebrityCandidate;
		}
		return -1;
    }

	private static boolean isCelebrity(int celebrity, int n) {
		for (int eachPerson = 0; eachPerson < n; eachPerson++) {
			if (eachPerson == celebrity) {
				continue;
			}
			if ( knows (celebrity, eachPerson) || ! knows(eachPerson, celebrity) ) {
				return false;
			}
		}
		return true;
	}
	
	static boolean knows(int a, int b) {
		return false;
	}
}
