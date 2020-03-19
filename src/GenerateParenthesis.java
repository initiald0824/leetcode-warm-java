//给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
//
// 例如，给出 n = 3，生成结果为：
//
// [
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
//
// Related Topics 字符串 回溯算法
import java.util.ArrayList;
import java.util.List;

/**
 * @author initiald0824
 * @date 2020/3/1 10:52 下午
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        String s = "(";
        dfs(res, s, n);
        return res;
    }

    private void dfs(List<String> res, String s, int n) {
        if (s.length() == n * 2) {
            res.add(s);
            return;
        }
        String next = nextBracket(s, n);
        if ("left".equals(next)) {
            dfs(res, s + "(", n);
        } else if ("right".equals(next)) {
            dfs(res, s + ")", n);
        } else if ("any".equals(next)) {
            dfs(res, s + "(", n);
            dfs(res, s+ ")", n);
        }
    }

    private String nextBracket(String s, int n) {
        int cnt = 0, left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cnt++;
                left++;
            } else if (s.charAt(i) == ')') {
                cnt--;
            }
        }
        if (cnt == 0) {
            return "left";
        } else if (left == n) {
            return "right";
        } else {
            return "any";
        }
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis().generateParenthesis(3));
    }
}
