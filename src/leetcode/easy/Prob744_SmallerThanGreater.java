package leetcode.easy;

public class Prob744_SmallerThanGreater {

	public static void main(String[] args) {
		System.out.println(nextGreatestLetter(new char[] { 'c', 'f', 'j' }, 'a'));
		System.out.println(nextGreatestLetter(new char[] { 'c', 'f', 'j' }, 'c'));
		System.out.println(nextGreatestLetter(new char[] { 'c', 'f', 'j' }, 'd'));
		System.out.println(nextGreatestLetter(new char[] { 'c', 'f', 'j' }, 'g'));
		System.out.println(nextGreatestLetter(new char[] { 'c', 'f', 'j' }, 'j'));
		System.out.println(nextGreatestLetter(new char[] { 'c', 'f', 'j' }, 'k'));
		System.out.println(nextGreatestLetter(new char[] { 'e', 'e', 'e', 'e', 'e', 'e', 'n', 'n', 'n', 'n', }, 'e'));
	}

	public static char nextGreatestLetter(char[] letters, char target) {
		int left = 0;
		int right = letters.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (letters[mid] == target) {
				left = mid + 1;
			} else if (target < letters[mid]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		if (right == letters.length - 1) {
			return letters[0];
		}

		if (left > right) {
			return letters[left];
		}
		return '*';
	}
}
