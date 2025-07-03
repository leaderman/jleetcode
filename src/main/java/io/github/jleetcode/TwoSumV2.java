package io.github.jleetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/two-sum/">两数之和</a>
 */
public class TwoSumV2 {
  static class Solution {
    public int[] twoSum(int[] nums, int target) {
      // 整数和下标的映射
      Map<Integer, Integer> valueToIndex = new HashMap<>(nums.length);

      // 填充映射
      for (int index = 0; index < nums.length; index++) {
        valueToIndex.put(nums[index], index);
      }

      // 第一个整数的下标
      for (int a = 0; a < nums.length; a++) {
        // 第二个整数
        int value = target - nums[a];

        // 获取第二个整数的下标
        Integer b = valueToIndex.get(value);
        if (b != null && b != a) {
          // 第二个整数的下标存在，返回两个整数的下标
          return new int[] {a, b};
        }
      }

      // 返回空
      return new int[] {};
    }
  }

  public static void main(String[] args) {
    int[] nums = {3, 2, 4};
    int target = 6;

    Solution solution = new Solution();
    int[] result = solution.twoSum(nums, target);

    System.out.println(Arrays.toString(result));
  }
}
