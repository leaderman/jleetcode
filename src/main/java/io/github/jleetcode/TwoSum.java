package io.github.jleetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/two-sum/">两数之和</a>
 */
public class TwoSum {
  static class Solution {
    public int[] twoSum(int[] nums, int target) {
      // 被加数的下标
      int a = -1;
      // 加数的下标
      int b = -1;

      // 被加数
      for (a = 0; a <= nums.length - 2; a++) {
        // 加数
        for (b = a + 1; b <= nums.length - 1; b++) {
          if (nums[a] + nums[b] == target) {
            // 两数之后等于目标值，返回两个整数的下标
            return new int[] {a, b};
          }
        }
      }

      // 返回空
      return new int[] {};
    }
  }

  public static void main(String[] args) {
    int[] nums = {2, 7, 11, 15};
    int target = 9;

    Solution solution = new Solution();
    int[] results = solution.twoSum(nums, target);

    System.out.println(Arrays.toString(results));
  }
}
