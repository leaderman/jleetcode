package io.github.jleetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharactersV2 {
  static class Solution {
    public int lengthOfLongestSubstring(String s) {
      char[] chars = s.toCharArray();

      // 子串集合
      Set<Character> substring = new HashSet<>();

      // 最长子串长度
      int max = 0;

      while (max < chars.length) {
        for (int start = 0; start < chars.length; start++) {
          // 子串长度 = 最长子串长度 + 1
          int end = start + max;
          if (end >= chars.length) {
            return max;
          }

          substring.clear();

          for (int index = start; index <= end; index++) {
            if (substring.contains(chars[index])) {
              break;
            }

            substring.add(chars[index]);
          }

          // 找到长度为 最长子串长度 + 1 的子串
          if (substring.size() == max + 1) {
            // 更新最长子串长度
            max++;
            break;
          }
        }
      }

      // 返回最长子串长度
      return max;
    }
  }

  public static void main(String[] args) {
    String s = "abcabcbb";

    Solution solution = new Solution();
    int result = solution.lengthOfLongestSubstring(s);

    System.out.println(result);
  }
}
