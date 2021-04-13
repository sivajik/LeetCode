package leetcode.hard;

import java.util.HashMap;

public class Prob460_LFUCache {

	public static void main(String[] args) {
		LFUCache lfu = new LFUCache(2);
		lfu.put(1, 1); // cache=[1,_], cnt(1)=1
		lfu.put(2, 2); // cache=[2,1], cnt(2)=1, cnt(1)=1
		lfu.get(1); // return 1
					// cache=[1,2], cnt(2)=1, cnt(1)=2
		lfu.put(3, 3); // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
						// cache=[3,1], cnt(3)=1, cnt(1)=2
		lfu.get(2); // return -1 (not found)
		lfu.get(3); // return 3
					// cache=[3,1], cnt(3)=2, cnt(1)=2
		lfu.put(4, 4); // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
						// cache=[4,3], cnt(4)=1, cnt(3)=2
		lfu.get(1); // return -1 (not found)
		lfu.get(3); // return 3
					// cache=[3,4], cnt(4)=1, cnt(3)=3
		lfu.get(4); // return 4
					// cache=[3,4], cnt(4)=2, cnt(3)=3

	}

	static class LFUCache {

		int capacity;
		HashMap<Integer, Node> keyNodeMap = new HashMap<>();
		HashMap<Integer, NodeDLinkedList> freqNodeDLLMap = new HashMap<>();
		int minumumFrequency = 1;

		public LFUCache(int capacity) {
			this.capacity = capacity;
		}

		public int get(int key) {
			Node node = keyNodeMap.get(key);
			if (node != null) {
				incrementFrequency(node); // since element is used, increase its frequency.
				return node.value;
			} else {
				return -1;
			}
		}

		public void put(int key, int value) {
			if (capacity <= 0)
				return;

			if (keyNodeMap.containsKey(key)) {
				Node node = keyNodeMap.get(key);
				node.value = value;
				incrementFrequency(node); // since element is used, increase its frequency.
				keyNodeMap.put(key, node);
			} else {
				Node node = new Node(key, value);
				if (keyNodeMap.size() == capacity) {
					// Remove LFU node from removedLastNode
					Node removedLastNode = freqNodeDLLMap.get(minumumFrequency).removeLastNode();
					keyNodeMap.remove(removedLastNode.key);
				}

				incrementFrequency(node);
				keyNodeMap.put(key, node);

				// Since new node is having frequency as 1, update minumumFrequency to be 1
				minumumFrequency = 1;
			}
		}

		private void incrementFrequency(Node node) {
			int oldFrequency = node.frequency;

			if (freqNodeDLLMap.containsKey(oldFrequency)) { // Frequency already exists
				NodeDLinkedList oldNodeDLinkedList = freqNodeDLLMap.get(oldFrequency);
				oldNodeDLinkedList.remove(node); // Remove current node
				if (node.frequency == minumumFrequency && // If this frequency was the minumum freq.
						oldNodeDLinkedList.length == 0) { // and no node is having this freq anymore
					minumumFrequency++; // Increment minimum frequency
				}
			}

			int newFrequency = oldFrequency + 1; // Increment frequency
			node.frequency = newFrequency;
			NodeDLinkedList newNodeDLinkedList = freqNodeDLLMap.getOrDefault(newFrequency, new NodeDLinkedList());
			newNodeDLinkedList.add(node);
			freqNodeDLLMap.put(newFrequency, newNodeDLinkedList);
		}

		private class Node {
			int key;
			int value;
			Node prev;
			Node next;
			int frequency;

			Node(int key, int value) {
				this.key = key;
				this.value = value;
			}
		}

		private class NodeDLinkedList {
			Node head, tail;
			int length;

			void add(Node node) {
				node.prev = null;
				node.next = null;

				if (head == null) {
					head = node;
					tail = node;
				} else {
					node.next = head;
					head.prev = node;
					head = node;
				}
				length++;
			}

			void remove(Node node) {
				if (node == head) {
					if (node == tail) {
						tail = null;
					}
					head = head.next;
				} else {
					node.prev.next = node.next;

					if (node == tail) {
						tail = node.prev;
					} else {
						node.next.prev = node.prev;
					}
				}
				length--;
			}

			Node removeLastNode() {
				Node tailNode = tail;
				if (tailNode != null) {
					remove(tailNode);
				}
				return tailNode;
			}
		}

	}
}
