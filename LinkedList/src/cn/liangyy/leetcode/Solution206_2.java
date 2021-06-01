package cn.liangyy.leetcode;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。(递归实现)
 *
 * @Author: 梁歪歪 <1732178815@qq.com>
 * @Description: blog <liangyy.cn>
 * @Create 2021-05-31-14:23
 */
public class Solution206_2 {
    public class ListNode {
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

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode rev = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return rev;
    }
}
