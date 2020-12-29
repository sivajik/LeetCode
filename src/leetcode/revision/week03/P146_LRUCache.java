package leetcode.revision.week03;

import java.util.HashMap;
import java.util.Map;

public class P146_LRUCache {

	public static void main(String[] args) {
		LRUCache lRUCache = new LRUCache(2);
		lRUCache.put(1, 1); // cache is {1=1}
		lRUCache.put(2, 2); // cache is {1=1, 2=2}
		System.out.println(lRUCache.get(1) == 1); // return 1
		lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
		System.out.println(lRUCache.get(2) == -1); // returns -1 (not found)
		lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
		System.out.println(lRUCache.get(1) == -1); // return -1 (not found)
		System.out.println(lRUCache.get(3) == 3); // return 3
		System.out.println(lRUCache.get(4) == 4); // return 4
		
		
		LRUCache lRUCache1 = new LRUCache(1);
		lRUCache1.put(2, 1); // cache is {1=1}
		System.out.println(lRUCache1.get(2) == 1); // return 1
		
		
		LRUCache lRUCache2 = new LRUCache(1);
		lRUCache2.put(2, 1); // cache is {1=1}
		System.out.println(lRUCache2.get(2) ); // return 1
		lRUCache2.put(3,2); // cache is {1=1}
		System.out.println(lRUCache2.get(2) ); // return 1
		System.out.println(lRUCache2.get(3) ); // return 1
		
		LRUCache lRUCache3 = new LRUCache(2);
		lRUCache3.put(2, 1);
		lRUCache3.put(1, 1);
		lRUCache3.put(2, 3);
		lRUCache3.put(4, 1);
		System.out.println(-1 == lRUCache3.get(1));
		System.out.println(3 == lRUCache3.get(2));
				
	}

}

class LRUCache {
	Map<Integer, DListNode> map = new HashMap<>();
	int capacity;

	DListNode head;
	DListNode tail;

	public LRUCache(int capacity) {
		this.capacity = capacity;

		this.head = new DListNode(-1, -1);
		this.tail = new DListNode(-1, -1);

		this.head.next = this.tail;
		this.tail.prev = this.head;
	}

	public int get(int key) {
		if (map.get(key) == null) {
			return -1;
		}

		// else key found so move it to front.
		DListNode node = map.get(key);
		int returnVal = node.val;

		// move to head.
		moveNodeToHead(node);

		return returnVal;
	}

	
	private void moveNodeToHead(DListNode node) {
		deleteNode(node);
		moveToHead(node);
	}

	private void moveToHead(DListNode node) {
		DListNode nextNode = head.next;

		this.head.next = node;
		node.prev = this.head;

		node.next = nextNode;
		nextNode.prev = node;
	}

	private void deleteNode(DListNode node) {
		DListNode next = node.next;
		DListNode prev = node.prev;

		next.prev = prev;
		prev.next = next;
		
		node.next = null;
		node.prev = null;
	}

	private int deleteTailNode() {
		DListNode lastNode = tail.prev;
		deleteNode(lastNode);
		return lastNode.key;
	}

	public void put(int key, int value) {
		if (map.get(key) == null) {
			// insert to map
			DListNode newNode = new DListNode(key, value);
			map.put(key, newNode);

			// move to head, as it is recently used.
			moveToHead(newNode);

			// if size is > capacity then evict last node.
			if (map.size() > capacity) {
				int dltdNodeKey = deleteTailNode();
				map.remove(dltdNodeKey);
			}
		} else {
			DListNode node = map.get(key);
			node.val = value;
			moveNodeToHead(node);
		}
	}

}

class DListNode {
	int key;
	int val;
	DListNode next;
	DListNode prev;

	DListNode(int key, int val) {
		this.key = key;
		this.val = val;
		this.next = null;
		this.prev = null;
	}
}