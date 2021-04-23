package cn.liangyy.leetcode;

import java.util.Stack;

/**
 * 力扣20题-有效的括号
 *
 * @Author: 梁歪歪 <1732178815@qq.com>
 * @Description: blog <liangyy.cn>
 * @Create 2021-04-23-10:26
 */
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '(' || c == '['){
                stack.push(c);
            }else {
                if (stack.isEmpty()){
                    return false;
                }
                char topChar = stack.pop();
                if (c == ')' && topChar != '('){
                    return false;
                }
                if (c == ']' && topChar != '['){
                    return false;
                }
                if (c == '}' && topChar != '{'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("{([])}"));
        System.out.println(new Solution().isValid("{([)]}"));
    }
}
