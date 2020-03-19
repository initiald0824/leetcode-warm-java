//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
//
//
// 注意空字符串可被认为是有效字符串。
//
// 示例 1:
//
// 输入: "()"
//输出: true
//
//
// 示例 2:
//
// 输入: "()[]{}"
//输出: true
//
//
// 示例 3:
//
// 输入: "(]"
//输出: false
//
//
// 示例 4:
//
// 输入: "([)]"
//输出: false
//
//
// 示例 5:
//
// 输入: "{[]}"
//输出: true
// Related Topics 栈 字符串

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author initiald0824
 * @date 2020/3/1 10:27 下午
 */
public class IsValidBracket {
    public boolean isValid(String s) {
        Map<String, String> validRecord = new HashMap<>(3);
        Stack<String> stack = new Stack<>();
        validRecord.put(")", "(");
        validRecord.put("}", "{");
        validRecord.put("]", "[");
        for (int i = 0; i < s.length(); i++) {
            String current = String.valueOf(s.charAt(i));
            if (validRecord.containsKey(current)) {
                if (stack.empty() || !stack.pop().equals(validRecord.get(current))) {
                    return false;
                }
            } else {
                stack.push(current);
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(new IsValidBracket().isValid("()"));
        System.out.println(new IsValidBracket().isValid("()[]{}"));
        System.out.println(new IsValidBracket().isValid("(]"));
        System.out.println(new IsValidBracket().isValid("([)]"));
        System.out.println(new IsValidBracket().isValid("({})"));
    }
}
