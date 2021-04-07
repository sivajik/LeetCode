package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class Prob1188_DesignBoundedBlockingQueue {

	public static void main(String[] args) {

	}
	// keep putting 'synchronized' keyword to all methods or else it fails..
	static class BoundedBlockingQueue {
		Queue<Integer> q = new LinkedList<>();
		int size;

		public BoundedBlockingQueue(int capacity) {
			this.size = capacity;
		}

		public synchronized void enqueue(int element) throws InterruptedException {
			while (q.size() == size) {
				wait();
			}
			q.add(element);
			notifyAll();
		}

		public synchronized int dequeue() throws InterruptedException {
			while (q.size() == 0) {
				wait();
			}
			int item = q.poll();
			notifyAll();
			return item;
		}

		public synchronized int size() {
			return q.size();
		}
	}
}
