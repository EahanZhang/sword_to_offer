package code_integrity._16数字的整数次方;

/**
 * Created By sunshine on 2018/7/30
 */

/**
 * 题目：给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * 思路：使用for循环，让base自乘exponent-1次。
 * 边界情况：
 *  base = 0，exponent > 0: 返回0
 *  base = 0, exponent = 0: 返回1
 *  base = 0, exponent < 0: 没有意义
 *  base != 0, exponent = 0, 返回1
 */

public class GetPower {
    public double Power(double base, int exponent) {
        if (base == 0) {
           if (exponent == 0) return 1.0;
           else if (exponent > 0) return 0.0;
           else return Double.NaN;
        } else {
            if (exponent == 0) return 1;
            else {
                boolean isNegative = false;
                if (exponent < 0) {
                    isNegative = true;
                    exponent = -exponent;
                }
                double res = base;
                for (int i = 1; i < exponent; i++) {
                    res *= base;
                }
                if (isNegative) return 1/res;
                else return res;
            }
        }
    }
}
