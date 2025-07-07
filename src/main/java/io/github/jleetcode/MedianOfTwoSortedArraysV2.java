package io.github.jleetcode;

/**
 * <a href="https://leetcode.cn/problems/median-of-two-sorted-arrays/description/">寻找两个正序数组的中位数</a>
 */
public class MedianOfTwoSortedArraysV2 {
  static class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      int[] nums = new int[nums1.length + nums2.length];
      int m = (int) Math.floor(nums.length / 2.0);

      int i = 0;
      int j = 0;
      int k = 0;

      while (k <= m && (i < nums1.length || j < nums2.length)) {
        int a = i < nums1.length ? nums1[i] : Integer.MAX_VALUE;
        int b = j < nums2.length ? nums2[j] : Integer.MAX_VALUE;

        if (a < b) {
          nums[k] = a;
          i++;
        } else {
          nums[k] = b;
          j++;
        }

        k++;
      }

      int r = nums.length % 2;

      return r == 0 ? (nums[m - 1] + nums[m]) / 2.0 : nums[m];
    }
  }

  public static void main(String[] args) {
    int[] nums1 = new int[] {1, 3};
    int[] nums2 = new int[] {2};

    Solution solution = new Solution();
    double result = solution.findMedianSortedArrays(nums1, nums2);

    System.out.println(result);
  }
}
