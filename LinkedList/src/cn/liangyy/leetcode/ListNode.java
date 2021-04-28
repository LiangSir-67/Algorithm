package cn.liangyy.leetcode;

/**
 * @Author: 梁歪歪 <1732178815@qq.com>
 * @Description: blog <liangyy.cn>
 * @Create 2021-04-28-9:14
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    // 为了方便调试 下面新增一些方法

    /**
     * 链表节点的构造函数
     * 使用arr为参数，创建一个链表，当前的ListNode为链表头节点
     *
     * @param arr
     */
    public ListNode(int[] arr){
        if (arr == null || arr.length == 0){
            throw new IllegalArgumentException("arr can not be empty.");
        }
        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    /**
     * 以当前节点为头节点的链表信息字符串
     *
     * @return
     */
    @Override
    public String toString() {
       StringBuilder res = new StringBuilder();
       ListNode cur = this;
       while (cur != null){
           res.append(cur.val + " -> ");
           cur = cur.next;
       }
       res.append("NULL");
       return res.toString();
    }
}