package leetcode.medium;


public class Prob901_OnlineStockSpan {

	public static void main(String[] args) {
		StockSpanner s = new StockSpanner();
		System.out.println(s.next(100));
		System.out.println(s.next(80));
		System.out.println(s.next(60));
		System.out.println(s.next(70));
		System.out.println(s.next(60));
		System.out.println(s.next(75));
		System.out.println(s.next(85));
	}

}

class StockSpanner {
	class Pair {
		int price;
		int span;

		Pair(int price, int span) {
			this.price = price;
			this.span = span;
		}
	}

	java.util.Stack<Pair> stack = null;

	public StockSpanner() {
		stack = new java.util.Stack<Pair>();
	}

	public int next(int price) {
		int span = 1;
		while (!stack.isEmpty() && stack.peek().price <= price) {
			int topSpan = stack.pop().span;
			span += topSpan;
		}
		stack.push(new Pair(price, span));
		return span;
	}
}