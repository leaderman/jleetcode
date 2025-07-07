package io.github.jleetcode;

/**
 * <a href="https://leetcode.cn/problems/longest-palindromic-substring/description/">最长回文子串</a>
 */
public class LongestPalindromicSubstring {
  static class Solution {
    public boolean isPalindrome(String str, int start, int end) {
      if (start >= end) {
        return true;
      }

      return str.charAt(start) == str.charAt(end) && isPalindrome(str, start + 1, end - 1);
    }

    public String find(String str, int start, int end) {
      if (start > end) {
        return "";
      }

      if (isPalindrome(str, start, end)) {
        return str.substring(start, end + 1);
      }

      String left = find(str, start, end - 1);
      String right = find(str, start + 1, end);

      return left.length() >= right.length() ? left : right;
    }

    public String longestPalindrome(String s) {
      return find(s, 0, s.length() - 1);
    }
  }

  public static void main(String[] args) {
    String s = "abbcccbbbcaaccbababcbcabca";

    Solution solution = new Solution();
    String result = solution.longestPalindrome(s);

    System.out.println(result);
  }
}
