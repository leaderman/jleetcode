package io.github.jleetcode;

/**
 * <a href="https://leetcode.cn/problems/longest-palindromic-substring/description/">最长回文子串</a>
 */
public class LongestPalindromicSubstringV2 {
  static class Solution {

    public String longestPalindrome(String str) {
      int max = 0;
      int start = 0;
      int end = 0;

      boolean[][] isPalindrome = new boolean[str.length()][str.length()];

      for (int len = 1; len <= str.length(); len++) {
        for (int i = 0; i <= str.length() - len; i++) {
          int j = i + len - 1;

          if (i == j) {
            isPalindrome[i][j] = true;
          } else if (i + 1 == j) {
            isPalindrome[i][j] = str.charAt(i) == str.charAt(j);
          } else {
            isPalindrome[i][j] = str.charAt(i) == str.charAt(j) && isPalindrome[i + 1][j - 1];
          }

          if (isPalindrome[i][j] && len > max) {
            max = len;
            start = i;
            end = j;
          }
        }
      }

      return str.substring(start, end + 1);
    }
  }

  public static void main(String[] args) {
    String s = "abbcccbbbcaaccbababcbcabca";

    Solution solution = new Solution();
    String result = solution.longestPalindrome(s);

    System.out.println(result);
  }
}
