package leetcode.revision.week01;

public class P1476_SubrectangleQueries {

	public static void main(String[] args) {
		SubrectangleQueries s = new SubrectangleQueries(new int[][] { { 1, 1, 1 }, { 2, 2, 2 }, { 3, 3, 3 } });
		System.out.println(s.getValue(0, 0) == 1);
		s.updateSubrectangle(0, 0, 2, 2, 100);
		System.out.println(s.getValue(2, 2) == 100);
		s.updateSubrectangle(1, 1, 2, 2, 20);
		System.out.println(s.getValue(2, 2) == 20);
	}

}

class SubrectangleQueries {
	int[][] rect;

	public SubrectangleQueries(int[][] rectangle) {
		this.rect = rectangle;
	}

	public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
		for (int i = row1; i <= row2; i++) {
			for (int j = col1; j <= col2; j++) {
				this.rect[i][j] = newValue;
			}
		}
	}

	public int getValue(int row, int col) {
		return this.rect[row][col];
	}
}