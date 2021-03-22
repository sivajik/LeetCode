package leetcode.medium;

import java.util.Arrays;

public class Prob1198_FindSmallestCommonElementInAllRows {

	public static void main(String[] args) {

		System.out.println(smallestCommonElement(
				new int[][] { { 1, 2, 3, 4, 5 }, { 2, 4, 5, 8, 10 }, { 3, 5, 7, 9, 11 }, { 1, 3, 5, 7, 9 } }));
		System.out.println(smallestCommonElement(new int[][] { { 1, 2, 3 }, { 2, 3, 4 }, { 2, 3, 5 } }));

		System.out.println(
				smallestCommonElement(new int[][] { { 10, 2075, 2700, 3884, 5017, 6177, 6829, 8294, 8695, 9263 },
						{ 262, 889, 1873, 2700, 5413, 6039, 6491, 6501, 7525, 8294 },
						{ 1348, 1504, 2950, 6107, 6747, 7003, 8294, 8355, 8601, 9412 },
						{ 2616, 4624, 5788, 6115, 7401, 7461, 7525, 7840, 7886, 8294 },
						{ 1739, 2002, 4239, 5151, 5238, 6190, 6848, 7238, 7722, 8294 },
						{ 4118, 4551, 5470, 6114, 7672, 7975, 8294, 8971, 9080, 9656 },
						{ 195, 2418, 5963, 6151, 7720, 7865, 8294, 8417, 8729, 9852 },
						{ 1195, 2657, 3608, 4285, 5154, 5299, 5497, 6960, 8125, 8294 },
						{ 511, 934, 3065, 3227, 3290, 3988, 4969, 7846, 8294, 9228 },
						{ 641, 1489, 2888, 3727, 4453, 5527, 6146, 6459, 8294, 9567 } }));
	}

	static public int smallestCommonElement(int[][] mat) {
		int min = -1;
		int foundCount = 1;
		for (int i = 0; i < mat[0].length; i++) {
			min = mat[0][i];
			int nextRow = 1;
			foundCount = 1;
			while (nextRow < mat.length) {
				int index = Arrays.binarySearch(mat[nextRow], min);
				if (index >= 0) {
					// min = mat[nextRow][index];
					nextRow++;
					foundCount++;
				} else {
					break;
				}
			}

			if (foundCount == mat.length) {
				return min;
			}
		}
		return -1;
	}
}
