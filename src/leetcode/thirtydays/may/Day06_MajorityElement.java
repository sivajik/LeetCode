package leetcode.thirtydays.may;

public class Day06_MajorityElement {

	public static void main(String[] args) {
		System.out.println(majorityElement(new int[] { 3, 2, 3 }));
		System.out.println(majorityElement(new int[] { 2, 2, 1, 1, 1, 2, 2 }));
		
		System.out.println(majorityElement2(new int[] { -1,1,1,1,2,1 }));
		System.out.println(majorityElement(new int[] { -1,1,1,1,2,1}));

	}

	public static int majorityElement(int[] nums) {
		java.util.Map<Integer, Integer> map = new java.util.HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				map.put(nums[i], 1 + map.get(nums[i]));
			} else {
				map.put(nums[i], 1);
			}
		}

		int maxCount = Integer.MIN_VALUE;
		int maxCountsKey = -1;

		for (java.util.Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() >= maxCount) {
				maxCount = entry.getValue();
				maxCountsKey = entry.getKey();
			}
		}
		if (maxCount > nums.length / 2) {
			return maxCountsKey;
		}
		return -1;
	}

	public static int majorityElement2(int[] nums) {
		java.util.Arrays.sort(nums);
		if (nums[nums.length - 1] == nums[nums.length / 2]) {
			return nums[nums.length - 1];
		} else if (nums[0] == nums[nums.length/2]) {
			return nums[0];
		}
		return -1;
	}
}
