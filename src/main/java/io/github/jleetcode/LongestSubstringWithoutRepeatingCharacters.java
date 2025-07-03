package io.github.jleetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
  static class Solution {
    public int lengthOfLongestSubstring(String s) {
      // 子串集合
      Set<Character> substring = new HashSet<>();
      // 最长子串长度
      int max = 0;

      char[] chars = s.toCharArray();

      // 从第 i 个字符开始构建子串
      for (int i = 0; i < chars.length; i++) {
        // 清空子串集合
        substring.clear();

        // 构建子串
        for (int j = i; j < chars.length; j++) {
          if (substring.contains(chars[j])) {
            // 子串已含有该字符，终止构建
            break;
          }

          // 子串不含有该字符，添加集合
          substring.add(chars[j]);
        }

        // 子串终止构建或者已到字符串末尾，检查子串长度
        int length = substring.size();
        if (length > max) {
          // 更新最长子串长度
          max = length;
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
