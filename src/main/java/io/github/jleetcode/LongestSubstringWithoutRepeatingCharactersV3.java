package io.github.jleetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharactersV3 {
  static class Solution {
    public int find(char[] chars, int start, int end, int max) {
      if (end - start < max) {
        return max;
      }

      Set<Character> substring = new HashSet<>();

      for (int index = start; index <= end; index++) {
        if (substring.contains(chars[index])) {
          break;
        }

        substring.add(chars[index]);
      }

      if (substring.size() == (end - start + 1)) {
        return substring.size();
      }

      if (substring.size() > max) {
        max = substring.size();
      }

      int left = find(chars, start, end - 1, max);
      int right = find(chars, start + 1, end, max);

      return Math.max(left, right);
    }

    public int lengthOfLongestSubstring(String s) {
      if ("".equals(s)) {
        return 0;
      }

      char[] chars = s.toCharArray();
      int start = 0;
      int end = chars.length - 1;
      int max = 1;

      return find(chars, start, end, max);
    }
  }

  public static void main(String[] args) {
    long start = System.currentTimeMillis();

    String s = "kmzmtyyfgqzzrsadztlfuhfmo";

    Solution solution = new Solution();
    int result = solution.lengthOfLongestSubstring(s);

    long end = System.currentTimeMillis();

    System.out.println(result);

    System.out.println(end - start);
  }
}
