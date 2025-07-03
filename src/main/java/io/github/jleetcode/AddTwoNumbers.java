package io.github.jleetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/add-two-numbers/description/">两数相加</a>
 */
public class AddTwoNumbers {
  static class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }


  static class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      // 链表的第一个节点
      ListNode first = null;
      // 链表的前一个节点
      ListNode pre = null;

      // 进位
      int carry = 0;

      while (l1 != null || l2 != null || carry != 0) {
        // 被加数
        int a = l1 != null ? l1.val : 0;
        // 加数
        int b = l2 != null ? l2.val : 0;

        // 和
        int sum = a + b + carry;

        if (sum >= 10) {
          sum = sum % 10;
          // 进位
          carry = 1;
        } else {
          // 无进位
          carry = 0;
        }

        // 创建节点
        ListNode node = new ListNode(sum);

        if (first == null) {
          // 第一个节点
          first = node;
        } else {
          // 链接节点
          pre.next = node;
        }

        // 更新前一个节点
        pre = node;

        // 下一个节点
        l1 = l1 != null ? l1.next : null;
        l2 = l2 != null ? l2.next : null;
      }

      // 返回链表的第一个结点
      return first;
    }
  }

  static ListNode convertArrayToList(int[] nums) {
    ListNode first = null;
    ListNode pre = null;

    for (int num : nums) {
      ListNode node = new ListNode(num);

      if (first == null) {
        first = node;
      } else {
        pre.next = node;
      }

      pre = node;
    }

    return first;
  }

  static int[] convertListToArray(ListNode l) {
    List<Integer> nums = new ArrayList<>();

    ListNode next = l;

    while (next != null) {
      nums.add(next.val);

      next = next.next;
    }

    return nums.stream().mapToInt(Integer::intValue).toArray();
  }

  public static void main(String[] args) {
    ListNode l1 = convertArrayToList(new int[] {2, 4, 3});
    ListNode l2 = convertArrayToList(new int[] {5, 6, 4});

    Solution solution = new Solution();
    ListNode result = solution.addTwoNumbers(l1, l2);

    int[] nums = convertListToArray(result);
    System.out.println(Arrays.toString(nums));
  }
}
