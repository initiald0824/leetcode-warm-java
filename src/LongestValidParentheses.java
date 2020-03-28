//给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
//
// 示例 1:
//
// 输入: "(()"
//输出: 2
//解释: 最长有效括号子串为 "()"
//
//
// 示例 2:
//
// 输入: ")()())"
//输出: 4
//解释: 最长有效括号子串为 "()()"
//
// Related Topics 字符串 动态规划

import java.util.Stack;

/**
 * @author initiald0824
 * @date 2020/3/24 3:07 下午
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int maxLen = 0;
        int len = s.length();
        int[] record = new int[len];
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i-1) == '(') {
                    record[i] += (i - 2 >= 0 ? record[i-2] : 0) + 2;
                } else {
                    if (i-1-record[i-1] >= 0 && s.charAt(i-1-record[i-1]) == '(') {
                        record[i] += record[i-1] + 2 + (i-1-record[i-1]-1>=0 ? record[i-1-record[i-1]-1] : 0);
                    }
                }
                maxLen = Math.max(maxLen, record[i]);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses().longestValidParentheses(")()())"));
    }
}
