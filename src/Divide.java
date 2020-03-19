//给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
//
// 返回被除数 dividend 除以除数 divisor 得到的商。
//
// 示例 1:
//
// 输入: dividend = 10, divisor = 3
//输出: 3
//
// 示例 2:
//
// 输入: dividend = 7, divisor = -3
//输出: -2
//
// 说明:
//
//
// 被除数和除数均为 32 位有符号整数。
// 除数不为 0。
// 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
//
// Related Topics 数学 二分查找

import java.util.HashMap;
import java.util.Map;

/**
 * @author initiald0824
 * @date 2020/3/12 2:47 下午
 */
public class Divide {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        } else if (dividend == Integer.MIN_VALUE && divisor == 1) {
            return Integer.MIN_VALUE;
        } else if (dividend == Integer.MAX_VALUE && divisor == 1) {
            return Integer.MAX_VALUE;
        } else if (dividend == Integer.MAX_VALUE && divisor == -1) {
            return Integer.MIN_VALUE;
        }
        int negativeDividend = dividend > 0 ? -dividend : dividend;
        int negativeDivisor = divisor > 0 ? -divisor : divisor;
        int quotient = 0, remainder = negativeDividend;
        while (remainder <= negativeDivisor) {
            Map<String, Integer> res = getDivideRes(remainder, negativeDivisor);
            quotient += res.get("quotient");
            remainder = res.get("remainder");
        }
        if ((dividend ^ divisor) >> 31 ==0) {
            return quotient;
        } else {
            return -quotient;
        }
    }

    private Map<String, Integer> getDivideRes(int negativeDividend, int negativeDivisor) {
        int quotient = 1;
        Map<String, Integer> res = new HashMap<>(2);
        int minusNum = negativeDivisor * quotient;
        while (negativeDividend <= minusNum) {
            quotient = quotient << 1;
            minusNum = negativeDivisor * quotient;
            if (minusNum >= 0 || minusNum == Integer.MIN_VALUE) {
                break;
            }
        }
        quotient = quotient >> 1;
        minusNum = negativeDivisor * quotient;
        res.put("quotient", quotient);
        res.put("remainder", negativeDividend - minusNum);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Divide().divide(-2147483648,2));
    }
}
