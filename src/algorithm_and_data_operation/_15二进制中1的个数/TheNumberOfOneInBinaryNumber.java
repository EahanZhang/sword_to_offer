package algorithm_and_data_operation._15二进制中1的个数;

/**
 * Created By TheNumberOfOneInBinaryNumber on 2018/7/30
 */

/**
 * 题目：输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 * 思路1：首先将数字1与n做与运算，若结果为1，计数器加一，然后将1左移，将得到的数2再与n做与运算，直到数字变为0位置，运算结束，返回个数
 *
 * 思路2：把一个整数减去一1，再与原整数做与运算，会把该整数最右边的1变为0。
 */

public class TheNumberOfOneInBinaryNumber {
    public int numberOfOne1(int n) {
        int flag = 1;
        int count = 0;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag <<= 1;
        }
        return count;
    }

    public int numberOfOne2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }
}
