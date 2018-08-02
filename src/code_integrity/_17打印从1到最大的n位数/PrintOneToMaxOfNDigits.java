package code_integrity._17打印从1到最大的n位数;

/**
 * Created By sunshine on 2018/8/2
 */

import java.util.Arrays;

/**
 * 题目：
 *  输入数字n，按顺序打印出从1到最大的n位十进制数。
 *  比如输入3，则打印1、2、3一直到999.
 *
 * 思路：
 * 1. 题目没有规定n的大小，因此不能使用int类型或者long类型来存放数字，需要使用字符数组
 * 2. 编写一个辅助函数，该函数实现字符串数字的递增操作
 * 3. 编写一个辅助函数，该函数实现数字的打印
 *
 * p.s: 还可以使用递归来实现
 */

public class PrintOneToMaxOfNDigits {
    public void printOneToMaxOfNDigits(int n) {
        if (n <= 0) return ;
        char[] num = new char[n];
        Arrays.fill(num, '0');
        while (!increment(num)) {
            printNumber(num);
        }
    }

    private boolean increment(char[] num) {
        boolean isOverflow = false; // 是否溢出，用于判断是否是最大值
        int takeOver = 0; // 进位
        for (int j = num.length - 1; j >= 0; j--) {
            int curSum = num[j] - '0' + takeOver;
            if (j == num.length - 1) {
                curSum++;
            }

            if (curSum >= 10) {
                if (j == 0) isOverflow = true;
                else {
                    takeOver = 1;
                    curSum -= 10;
                    num[j] = (char) ('0' + curSum);
                }
            } else {
                num[j] = (char) ('0' + curSum);
                break;
            }
        }
        return isOverflow;
    }

    private void printNumber(char[] num) {
        int i = 0;
        for (; i < num.length; i++) {
            if (num[i] != '0') break;
        }

        for (; i < num.length; i++) {
            System.out.print(num[i]);
        }
        System.out.print("\n");
    }
}
