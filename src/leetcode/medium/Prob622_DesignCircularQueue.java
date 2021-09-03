package leetcode.medium;

public class Prob622_DesignCircularQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static class Node {
		public int value;
		public Node nextNode;

		public Node(int value) {
			this.value = value;
			this.nextNode = null;
		}
	}

	static class MyCircularQueue {

		private Node head, tail;
		private int count;
		private int capacity;

		public MyCircularQueue(int k) {
			this.capacity = k;
		}

		public boolean enQueue(int value) {
			if (this.count == this.capacity)
				return false;

			Node newNode = new Node(value);
			if (this.count == 0) {
				head = tail = newNode;
			} else {
				tail.nextNode = newNode;
				tail = newNode;
			}
			this.count += 1;
			return true;
		}

		public boolean deQueue() {
			if (this.count == 0)
				return false;
			this.head = this.head.nextNode;
			this.count -= 1;
			return true;
		}

		public int Front() {
			if (this.count == 0)
				return -1;
			else
				return this.head.value;
		}

		public int Rear() {
			if (this.count == 0)
				return -1;
			else
				return this.tail.value;
		}

		public boolean isEmpty() {
			return (this.count == 0);
		}

		public boolean isFull() {
			return (this.count == this.capacity);
		}
	}
}
