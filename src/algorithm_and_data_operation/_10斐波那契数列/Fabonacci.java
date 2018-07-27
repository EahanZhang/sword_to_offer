package algorithm_and_data_operation._10斐波那契数列;

/**
 * Created By _10斐波那契数列 on 2018/7/27
 */

/**
 * 题目：
 *  大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 *  n<=39
 *
 * 思路1：使用递归， 缺点是重复计算太多
 * 思路2：使用for循环
 */

public class Fabonacci {
    public int FibonacciUseRecursive(int n) {
        if (n <= 0) return 0;
        else if (n == 1) return 1;
        else return FibonacciUseRecursive(n-1) + FibonacciUseRecursive(n-2);
    }

    public int FibonacciUseForCircle(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;
        else {
            int res = 0;
            int minOne = 0, maxOne = 1;
            for (int i = 2; i <= n; i++) {
                res = minOne + maxOne;
                minOne = maxOne;
                maxOne = res;
            }
            return res;
        }
    }
}
