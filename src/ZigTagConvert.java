//将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
//
// 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
//
// L   C   I   R
//E T O E S I I G
//E   D   H   N
//
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
//
// 请你实现这个将字符串进行指定行数变换的函数：
//
// string convert(string s, int numRows);
//
// 示例 1:
//
// 输入: s = "LEETCODEISHIRING", numRows = 3
//输出: "LCIRETOESIIGEDHN"
//
//
// 示例 2:
//
// 输入: s = "LEETCODEISHIRING", numRows = 4
//输出: "LDREOEIIECIHNTSG"
//解释:
//
//L     D     R
//E   O E   I I
//E C   I H   N
//T     S     G
// Related Topics 字符串

import java.util.LinkedList;
import java.util.List;

/**
 * @author initiald0824
 * @date 2020/1/21 17:20
 */
public class ZigTagConvert {
    /**
     * 获取计算公式
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        StringBuilder res = new StringBuilder();
        if (numRows == 1) {
            return s;
        }
        for (int i = 0; i < numRows; i++) {
            int index = i;
            while (index < s.length()) {
                if (i == 0 || i == numRows-1) {
                    res.append(s.charAt(index));
                    index += 2 * (numRows - 1);
                } else {
                    res.append(s.charAt(index));
                    int mid = index + 2 * (numRows - i - 1);
                    if (mid >= s.length()) {
                        break;
                    }
                    res.append(s.charAt(mid));
                    index += 2 * (numRows - 1);
                }
            }
        }
        return String.valueOf(res);
    }

    /**
     * 根据规则生成字符串list
     * @param s
     * @param numRows
     * @return
     */
    public String convert2(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> record = new LinkedList<>();
        for (int i = 0; i < numRows; i++) {
            record.add(new StringBuilder());
        }
        boolean down = false;
        int curRow = 0;
        for (int i = 0; i < s.length(); i++) {
            record.get(curRow).append(s.charAt(i));
            if (curRow == 0 || curRow == numRows - 1) {
                down = !down;
            }
            curRow += down ? 1 : -1;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb: record) {
            res.append(sb);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String str = "PAYPALISHIRING";
        System.out.println(new ZigTagConvert().convert2(str, 3));
    }
}
