package leetcode.thirtydays;

public class Day28_FirstUniqueNumber {

	public static void main(String[] args) {
		FirstUnique firstUnique = new FirstUnique(new int[] {2, 3, 5});
		firstUnique.showFirstUnique(); // return 2
		firstUnique.add(5);            // the queue is now [2,3,5,5]
		firstUnique.showFirstUnique(); // return 2
		firstUnique.add(2);            // the queue is now [2,3,5,5,2]
		firstUnique.showFirstUnique(); // return 3
		firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
		firstUnique.showFirstUnique(); // return -1
	}

}

class FirstUnique {
	java.util.Set<Integer> unique = new java.util.LinkedHashSet<>();
	java.util.Set<Integer> all = new java.util.HashSet<>();

	public FirstUnique(int[] nums) {
		for (int num : nums) {
			add(num);
		}
	}

	public int showFirstUnique() {
		if (unique.isEmpty()) {
			System.out.println(-1);
			return -1;
		} else {
			int i = unique.iterator().next();
			System.out.println(i);
			return i;
		}
	}

	public void add(int value) {
		boolean added = all.add(value);
		if (added) {
			unique.add(value);
		} else {
			unique.remove(value);
		}
	}
}