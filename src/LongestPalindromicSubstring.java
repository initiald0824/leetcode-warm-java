//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
// 示例 1：
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
//
//
// 示例 2：
//
// 输入: "cbbd"
//输出: "bb"
//
// Related Topics 字符串 动态规划

/**
 * @author initiald0824
 * @date 2020/1/1 18:58
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        return centralSymmetry(s);
    }

    /**
     * 中心对称法
     * @param s
     * @return 结果
     */
    public String centralSymmetry(String s) {
        int len = s.length() * 2 - 1;
        String maxStr = "";
        for (int i = 0; i < len; i++) {
            String res;
            if (i % 2 == 1) {
                res = centralSymmetryFunc(s, "", (i-1)/2, (i+1)/2);
            } else {
                res = centralSymmetryFunc(s, String.valueOf(s.charAt(i/2)), i/2-1, i/2+1);
            }
            maxStr = maxStr.length() > res.length() ? maxStr : res;
        }
        return maxStr;
    }

    private String centralSymmetryFunc(String src, String center, int left, int right) {
        String res = "";
        while (left >= 0 && right < src.length()) {
            if (src.charAt(left) == src.charAt(right)) {
                res = src.substring(left, right+1);
                left--;
                right++;
            } else {
                break;
            }
        }
        res = res.length() > center.length() ? res : center;
        return res;
    }


    /**
     * 动态规划法
     * @param s
     * @return
     */
    public String dynamicPlan(String s) {
        int len = s.length();
        String res = "";
        boolean record[][] = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            record[i][i] = true;
            res = res.length() > s.substring(i, i+1).length() ? res : s.substring(i, i+1);
            if (i < len -1 && s.charAt(i) == s.charAt(i+1)) {
                record[i][i+1] = true;
                res = res.length() > s.substring(i, i+2).length() ? res : s.substring(i, i+2);
            }
        }

        for (int step = 2; step < len; step++) {
            for (int i = 0; i < len-step; i++) {
                int j = i + step;
                if (s.charAt(i) == s.charAt(j) && record[i+1][j-1]) {
                    record[i][j] = true;
                    res = res.length() > s.substring(i, j+1).length() ? res : s.substring(i, j+1);
                } else {
                    record[i][j] = false;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().dynamicPlan("abcba"));
    }
}
