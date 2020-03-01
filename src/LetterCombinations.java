//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//
//
// 示例:
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//
//
// 说明:
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
// Related Topics 字符串 回溯算法

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author initiald0824
 * @date 2020/2/27 10:29 下午
 */
public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> mapRecord = new HashMap<>(8);
        mapRecord.put('2', "abc");
        mapRecord.put('3', "def");
        mapRecord.put('4', "ghi");
        mapRecord.put('5', "jkl");
        mapRecord.put('6', "mno");
        mapRecord.put('7', "pqrs");
        mapRecord.put('8', "tuv");
        mapRecord.put('9', "wxyz");
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        dfs(mapRecord, res, "", digits);
        return res;
    }

    private void dfs(Map<Character, String> record, List<String> res, String pre, String digits) {
        if (digits.length() == 1) {
            String strs = record.get(digits.charAt(0));
            for (int i = 0; i < strs.length(); i++) {
                res.add(pre + strs.charAt(i));
            }
        } else {
            String strs = record.get(digits.charAt(0));
            for (int i = 0; i < strs.length(); i++) {
                dfs(record, res, pre + strs.charAt(i), digits.substring(1));
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new LetterCombinations().letterCombinations(""));
    }
}



