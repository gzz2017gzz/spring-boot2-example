package com.gzz;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				return new int[] { map.get(nums[i]), i };
			}
			map.put(target - nums[i], i);
		}
		return null;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 2, 7, 11, 15, 8 };
		int target = 66;
		System.out.println(Solution.twoSum(nums, target));
	}
}
