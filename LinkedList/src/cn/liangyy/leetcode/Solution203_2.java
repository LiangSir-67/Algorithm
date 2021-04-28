package cn.liangyy.leetcode;

/**
 * 力扣203
 * 移除链表元素
 *
 * @Author: 梁歪歪 <1732178815@qq.com>
 * @Description: blog <liangyy.cn>
 * @Create 2021-04-28-9:23
 */
public class Solution203_2 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while (prev.next != null){
            if (prev.next.val == val){
                prev.next = prev.next.next;
            }else{
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,6,3,8,4,56,2,4};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = new Solution203_2().removeElements(head, 2);
        System.out.println(res);
    }
}
