package cn.liangyy.leetcode;

/**
 * 力扣203
 * 移除链表元素(递归实现)
 * 自定义测试（打印输出）
 *
 * @Author: 梁歪歪 <1732178815@qq.com>
 * @Description: blog <liangyy.cn>
 * @Create 2021-04-28-10:21
 */
public class Solution203_3_1 {
    public ListNode removeElements(ListNode head, int val, int depth) {
        String depthString = generateDepthString(depth);
        System.out.print(depthString);
        System.out.println("Call: remove " + val + " in " + head);
        if (head == null){
            System.out.print(depthString);
            System.out.println("Return: " + head);
            return head;
        }
        //head.next = removeElements(head.next, val, depth + 1);
        ListNode res = removeElements(head.next, val, depth + 1);
        System.out.print(depthString);
        System.out.println("After remove " + val + ": " + res);

        ListNode ret;
        if (head.val == val){
            ret = res;
        }else{
            head.next = res;
            ret = head;
        }
        System.out.print(depthString);
        System.out.println("Return: " + ret);
        return ret;

        //return head.val == val ? head.next : head;
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append(" -- ");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        int[] nums = {1,2,6,3,8,4,56,2,4};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = new Solution203_3_1().removeElements(head, 2, 0);
        System.out.println(res);
    }
}
