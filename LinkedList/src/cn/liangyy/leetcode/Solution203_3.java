package cn.liangyy.leetcode;

/**
 * 力扣203
 * 移除链表元素(递归实现)
 *
 * @Author: 梁歪歪 <1732178815@qq.com>
 * @Description: blog <liangyy.cn>
 * @Create 2021-04-28-10:21
 */
public class Solution203_3 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return null;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,6,3,8,4,56,2,4};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = new Solution203_3().removeElements(head, 2);
        System.out.println(res);
    }
}
