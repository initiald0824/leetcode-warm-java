//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 示例 1:
//
// 输入: "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//

import java.util.HashMap;
import java.util.Map;

/**
 * @author initiald0824
 * @date 2020/1/1 7:38
 */


public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int start = 0, maxLength = 0;
        Map<Character, Integer> record = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (record.containsKey(c)) {
                start = Math.max(record.get(c) + 1, start);
            }
            maxLength = Math.max(i + 1 - start, maxLength);
            record.put(c, i);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abba";
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring(s));
    }
}



















