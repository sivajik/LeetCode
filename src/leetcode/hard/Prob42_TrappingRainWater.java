package leetcode.hard;

public class Prob42_TrappingRainWater {

	public static void main(String[] args) {
		System.out.println(trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
	}

	static public int trap(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		int[] mL = new int[height.length];
		int[] mR = new int[height.length];

		mL[0] = height[0];
		for (int i = 1; i < height.length; i++) {
			mL[i] = Math.max(mL[i - 1], height[i]);
		}

		mR[height.length - 1] = height[height.length - 1];
		for (int i = height.length - 2; i >= 0; i--) {
			mR[i] = Math.max(mR[i + 1], height[i]);
		}

		int res = 0;
		int[] wid = new int[height.length];
		for (int i = 0; i < height.length; i++) {
			wid[i] = Math.min(mL[i], mR[i]) - height[i];
			res += wid[i];
		}
		// System.out.println(Arrays.toString(wid));
		return res;
	}
}
