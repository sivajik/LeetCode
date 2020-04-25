package leetcode.medium;

public class Prob146_LRUCacheImpl {

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2 /* capacity */ );

		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1)); // returns 1
		cache.put(3, 3); // evicts key 2
		System.out.println(cache.get(2)); // returns -1 (not found)
		cache.put(4, 4); // evicts key 1
		System.out.println(cache.get(1)); // returns -1 (not found)
		System.out.println(cache.get(3)); // returns 3
		System.out.println(cache.get(4)); // returns 4

	}

}

class LRUCache {

	private int capacity;
	private DListNode head;
	private DListNode tail;

	private int count = 0;

	private java.util.Map<Integer, DListNode> cache;

	LRUCache(int capacity) {
		this.capacity = capacity;
		this.cache = new java.util.HashMap<Integer, DListNode>();
		head = new DListNode();
		tail = new DListNode();
		
		head.next = tail;
		tail.prev = head;
		
		
		this.count = 0;
	}

	public int get(int key) {
		DListNode node = cache.get(key);
		if (node == null) {
			return -1;
		}

		moveNodeToHead(node);
		return node.value;
	}

	public void put(int key, int value) {
		DListNode node = cache.get(key);

		if (node == null) {
			DListNode newNode = new DListNode();
			newNode.key = key;
			newNode.value = value;
			
			cache.put(key, newNode);
			addToHead(newNode);
			count++;

			if (count > capacity) {
				// remove the tail
				DListNode lastNode = deleteTailNode();
				cache.remove(lastNode.key);
				count--;
			}
		} else {
			node.value = value;
			moveNodeToHead(node);
		}
	}

	public void moveNodeToHead(DListNode node) {
		removeNode(node);
		addToHead(node);
	}

	private void addToHead(DListNode node) {
		node.next = head.next;
		node.prev = head;

		head.next.prev = node;
		head.next = node;
	}

	private DListNode deleteTailNode() {
		DListNode lastNode = tail.prev;
		removeNode(lastNode);
		return lastNode;
	}

	private void removeNode(DListNode node) {
		DListNode prev = node.prev;
		DListNode next = node.next;

		prev.next = next;
		next.prev = prev;
	}
}

class DListNode {
	int key;
	int value;
	DListNode next;
	DListNode prev;

//	DListNode(int key, int value) {
//		this.key = key;
//		this.value = value;
//		this.next = null;
//		this.prev = null;
//	}
}