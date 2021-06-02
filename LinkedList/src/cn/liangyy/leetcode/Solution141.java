package cn.liangyy.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 链表成环
 * <p>
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * <p>
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 *
 * @Author: 梁歪歪 <1732178815@qq.com>
 * @Description: blog <liangyy.cn>
 * @Create 2021-06-02-15:46
 */
public class Solution141 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 方法一：循环遍历节点 遍历一个标记一个，遍历过程中判断是否被标记，若已被标记则表示有环
     * 方法说明： 头指针移动，若到达之前到达过的位置则表示有环，若无环则会走到链表末端
     * @param head
     * @return
     */
    public boolean hasCycle1(ListNode head) {
        // 声明一个set存放已遍历的节点，即为标记节点（Set中不允许重复元素）
        Set<ListNode> set = new HashSet<>();
        while (head != null){
            if (set.contains(head)){
                return true;
            }else {
                set.add(head);
                head = head.next;
            }
        }
        return false;
    }

    /**
     * 方法二： 声明两个指针 一个指针走一次经过两个节点（快指针quick），另一个走一次经过一个节点（慢指针slow）
     * 方法说明： 快指针走的比较快，若链表有环，则一定会追上慢指针，若无环，则会走到链表末端
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        // 声明两个指针从头开始遍历节点
        ListNode quick = head;
        ListNode slow = head;
        // 当快指针能够走到头，表示无环
        while (quick != null  && quick.next != null){
            quick = quick.next.next;
            slow = slow.next;
            if (quick == slow){
                return true;
            }
        }
        return false;
    }
}
