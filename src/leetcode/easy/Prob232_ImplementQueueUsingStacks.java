package leetcode.easy;

import java.util.Stack;

public class Prob232_ImplementQueueUsingStacks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static class MyQueue {
		int front;
		Stack<Integer> s1 = new Stack<>(); // THE main stack.
		Stack<Integer> s2 = new Stack<>(); // dummy placeholder stack - used for transfers.

		/** Initialize your data structure here. */
		public MyQueue() {

		}

		/** Push element x to the back of queue. */
		public void push(int x) {
			// first push all s1 to s2
			// 1 2 <now adding 3> -> 1 should be on the top/peek and 3 shd be in bottom.
			while (!s1.isEmpty()) {
				s2.push(s1.pop());
			}
			//s2 -> 2 then 1
			s2.push(x);
			
			//s2 -> 3 -> 2 -> 1
			while (!s2.isEmpty()) {
				s1.push(s2.pop());
			}
			
			// s1 -> 1 -> 2 -> 3
			if (!s1.isEmpty()) {
				front = s1.peek();
			}
		}

		/** Removes the element from in front of queue and returns that element. */
		public int pop() {
			if (!s1.isEmpty()) {
				int temp = s1.pop();
				if (!s1.isEmpty()) {
					front = s1.peek();
				}
				return temp;
			} else {
				return -1;
			}
		}

		/** Get the front element. */
		public int peek() {
			return front;
		}

		/** Returns whether the queue is empty. */
		public boolean empty() {
			return s1.isEmpty();
		}
	}

}
