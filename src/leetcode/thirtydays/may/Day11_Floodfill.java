package leetcode.thirtydays.may;

public class Day11_Floodfill {

	public static void main(String[] args) {
		int[][] image = new int[][] { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		print(image);
		Day11_Floodfill.floodFill(image, 1, 1, 2);
		print(image);
		System.out.println("=========");

		image = new int[][] { { 0, 0, 1 }, { 0, 1, 1 } };
		print(image);
		Day11_Floodfill.floodFill(image, 1, 1, 1);
		print(image);
		System.out.println("=========");

	}

	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		floodFill1(image, sr, sc, newColor, image[sr][sc]);
		return image;
	}

	public static void floodFill1(int[][] image, int sr, int sc, int newColor, int currColor) {
		System.out.println("Processing: " + sr + "," + sc);
		if (image[sr][sc] != newColor) {
			image[sr][sc] = newColor;

			if (sc + 1 < image[0].length && image[sr][sc + 1] == currColor) {
				floodFill1(image, sr, sc + 1, newColor, image[sr][sc + 1]);
			}
			if (sc - 1 >= 0 && image[sr][sc - 1] == currColor) {
				floodFill1(image, sr, sc - 1, newColor, image[sr][sc - 1]);
			}
			if (sr - 1 >= 0 && image[sr - 1][sc] == currColor) {
				floodFill1(image, sr - 1, sc, newColor, image[sr - 1][sc]);
			}
			if (sr + 1 < image.length && image[sr + 1][sc] == currColor) {
				floodFill1(image, sr + 1, sc, newColor, image[sr + 1][sc]);
			}
		}
	}

	private static void print(int[][] image) {
		for (int[] a : image) {
			for (int elem : a) {
				System.out.print(elem + " ");
			}
			System.out.println();
		}
		System.out.println("---------");
	}
}
