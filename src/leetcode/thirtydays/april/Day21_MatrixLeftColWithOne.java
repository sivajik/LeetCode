package leetcode.thirtydays.april;

public class Day21_MatrixLeftColWithOne {

	public static void main(String[] args) {
		MyBinaryMatrix m = new MyBinaryMatrix(new int[][] { 
			{ 0, 0, 0, 1 }, 
			{ 0, 0, 1, 1 }, 
			{ 0, 0, 1, 1 },
			{ 1, 1, 1, 1 }
		});
		System.out.println(leftMostColumnWithOne(m));
	}

	public static int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
		int result = Integer.MAX_VALUE;
		boolean foundMinIndexLoca = false;
		java.util.List<Integer> dims = binaryMatrix.dimensions();

		int rows = dims.get(0);
		int cols = dims.get(1);

		java.util.List<Integer> indices = new java.util.ArrayList<Integer>();
		
		for (int i = 0; i < rows; i++) {
			int left = 0;
			int right = cols-1;
			int mid = -1;
			int foundIndex = -1;
			boolean found = false;
			while (left <= right) {
				mid = left + (right - left) / 2;
				int currElem = binaryMatrix.get(i, mid);
				if (currElem == 0) {
					left = mid + 1;
				} else if (currElem == 1) {
					found = true;
					foundIndex = mid;
					right = mid - 1;
				}
			}
			
			if (!found) {
				indices.add(-1);
			} else {
				if (foundIndex < result) {
					result = foundIndex;
					foundMinIndexLoca = true;
				}
			}
		}
		return foundMinIndexLoca ? result : -1;
	}
}

interface BinaryMatrix {
	public int get(int x, int y);

	public java.util.List<Integer> dimensions();
};

class MyBinaryMatrix implements BinaryMatrix {
	private int[][] input;

	MyBinaryMatrix(int[][] ip) {
		this.input = new int[ip.length][ip[0].length];
		for (int i = 0; i < ip.length; i++) {
			this.input[i] = new int[ip[i].length];
			for (int j = 0; j < ip[i].length; j++) {
				this.input[i][j] = ip[i][j];
			}
		}
	}

	@Override
	public int get(int x, int y) {
		return this.input[x][y];
	}

	@Override
	public java.util.List<Integer> dimensions() {
		java.util.List<Integer> l = new java.util.ArrayList<Integer>();
		l.add(input.length);
		l.add(input[0].length);
		return l;
	}

}
