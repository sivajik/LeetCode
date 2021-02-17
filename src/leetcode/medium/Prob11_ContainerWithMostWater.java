package leetcode.medium;

public class Prob11_ContainerWithMostWater {

	public static void main(String[] args) {
		System.out.println(maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));

	}

	static public int maxArea(int[] height) {
		// brute force
/*		int maxArea = 0;
		for (int i = 0; i < height.length; i++) {
			for (int j = i + 1; j < height.length; j++) {
				maxArea = Math.max(maxArea, (j - i) * Math.min(height[i], height[j]));
			}
		}
		return maxArea;
*/
		// 2 pointer
		int maxArea = 0;
		int l = 0;
		int r = height.length-1;
		while (l < r) {
			maxArea = Math.max(maxArea, (r-l) * Math.min(height[l], height[r]));
			if (height[l] < height[r]) {
				l++;
			} else {
				r--;
			}
		}
		return maxArea;
	}
}
