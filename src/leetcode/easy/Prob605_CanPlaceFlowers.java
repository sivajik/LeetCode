package leetcode.easy;

public class Prob605_CanPlaceFlowers {

	public static void main(String[] args) {
		/*System.out.println(canPlaceFlowers(new int[] { 1, 0, 0, 0, 1 }, 1) == true);
		System.out.println(canPlaceFlowers(new int[] { 1, 0, 0, 0, 1 }, 2) == false);
		System.out.println(canPlaceFlowers(new int[] { 1, 0, 1, 0, 1, 0, 1 }, 1) == false);
		System.out.println(canPlaceFlowers(new int[] { 0, 0, 1, 0, 1 }, 1) == true);
		System.out.println(canPlaceFlowers(new int[] { 0, 1, 0 }, 1) == false);*/
		System.out.println(canPlaceFlowers(new int[] { 0, 0 }, 2) == false);
	}

	static public boolean canPlaceFlowers(int[] flowerbed, int n) {
		int validCellCount = 0;
		if (flowerbed.length == 1) {
			if (flowerbed[0] == 0) {
				validCellCount = 1;
			} else {
				validCellCount = 0;
			}
		} else {
			for (int i = 0; i < flowerbed.length; i++) {
				if (flowerbed[i] == 0) {
					if (i == 0) {
						if (flowerbed[1] == 0) {
							flowerbed[i] = 1;
							validCellCount++;
						}
					} else if (i == flowerbed.length - 1) {
						if (flowerbed[i - 1] == 0) {
							flowerbed[i] = 1;
							validCellCount++;
						}
					} else {
						if (flowerbed[i - 1] == 1 || flowerbed[i + 1] == 1) {
							// don't use it.
						} else {
							flowerbed[i] = 1;
							validCellCount++;
						}
					}
				}
			}
		}
		return n <= validCellCount;
	}
}
