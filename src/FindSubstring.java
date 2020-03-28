//给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
//
// 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
//
//
//
// 示例 1：
//
// 输入：
//  s = "barfoothefoobarman",
//  words = ["foo","bar"]
//输出：[0,9]
//解释：
//从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
//输出的顺序不重要, [9,0] 也是有效答案。
//
//
// 示例 2：
//
// 输入：
//  s = "wordgoodgoodgoodbestword",
//  words = ["word","good","best","word"]
//输出：[]
//
// Related Topics 哈希表 双指针 字符串

import java.util.*;

/**
 * @author initiald0824
 * @date 2020/3/15 6:05 下午
 */
public class FindSubstring {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int len = getWordsLength(words);
        if (s.length() < len || "".equals(s) || len == 0) {
            return res;
        }
        int wordLen = words[0].length();
        for (int i = 0; i <= s.length()-len; i++) {
            if (isMatch(s.substring(i, i+len), words, wordLen)) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean isMatch(String s, String[] words, int wordLen) {
        Map<String, Integer> record = new HashMap<>(words.length);
        int i = 0;
        while (i <= s.length()-wordLen) {
            String key = s.substring(i, i+wordLen);
            if (record.containsKey(key)) {
                record.put(key, record.get(key)+1);
            } else {
                record.put(key, 1);
            }
            i += wordLen;
        }
        for (String key: words) {
            if (record.containsKey(key)) {
                record.put(key, record.get(key)-1);
            } else {
                return false;
            }
        }
        for (Map.Entry<String, Integer> entry: record.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }

    private int getWordsLength(String[] words) {
        int len = 0;
        for (String word: words) {
            len += word.length();
        }
        return len;
    }


    public static void main(String[] args) {
        System.out.println(new FindSubstring().findSubstring("", new String[]{}));
    }
}
