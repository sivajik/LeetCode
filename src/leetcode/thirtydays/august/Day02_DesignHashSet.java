package leetcode.thirtydays.august;

public class Day02_DesignHashSet {

	public static void main(String[] args) {
		MyHashSet hashSet = new MyHashSet();
		hashSet.add(1);         
		hashSet.add(2);         
		System.out.println(hashSet.contains(1) == true);    // returns true
		System.out.println(hashSet.contains(3) ==false);    // returns false (not found)
		hashSet.add(2);          
		System.out.println(hashSet.contains(2) == true);    // returns true
		hashSet.remove(2);          
		System.out.println(hashSet.contains(2) == false);    // returns false (already removed)
	}

}

class MyHashSet {
	private final int EMPTY = -9999;
	private int[] data;

	public MyHashSet() {
		this.data = new int[1000000];
		java.util.Arrays.fill(this.data, EMPTY);
	}

	public void add(int key) {
		this.data[key] = key;
	}

	public void remove(int key) {
		if (contains(key)) {
			this.data[key] = EMPTY;
		}
	}

	public boolean contains(int key) {
		return this.data[key] != EMPTY && this.data[key] == key;
	}
}