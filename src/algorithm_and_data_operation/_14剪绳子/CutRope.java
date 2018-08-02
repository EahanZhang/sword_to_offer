package algorithm_and_data_operation._14剪绳子;

/**
 * Created By CutRope on 2018/7/30
 */

/**
 * 题目：
 *  给你一根长度为n的绳子，请把绳子剪成m段（m、n都是整数，n>1且m>1）,
 *  每段绳子的长度记为k[0],k[1],···,k[m]。 请问k[0]*k[1]*k[2]*...*k[m]可能的最大乘积是多少？
 *  例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 思路：
 *  使用贪婪算法，当n>=5时，尽可能多地剪长度为3的绳子；当剩下的长度为4时，把绳子剪成长度为2的绳子。因为 3*1 < 2*2
 *  n >= 5 -> n + n >= n + 5 -> 2n - 5 >= n -> 2n - 4 > n -> 2(n-2) > n
 *  n >= 5 -> 2n >= 10 -> 3n >= 10 + n -> 3(n - 3.33) >= n -> 3(n-3) > n
 *  并且因为n >= 5, 所以3(n-3) >= 2(n-2)
 *
 */

public class CutRope {
    public int getMaxMutilpleResult(int length) {
        if (length < 2) return 0;
        else if (length == 2) return 1;
        else if (length == 3) return 2;

        // 尽可能多地剪去长度为3的绳子
        int timesOfThree = length / 3;

        // 当绳子最后剩下的长度为4的时候，不能再减去长度为3的绳子段。
        if (length - timesOfThree * 3 == 1) timesOfThree--;

        int timesOf2 = (length - timesOfThree * 3) / 2;

        return (int) (Math.pow(3, timesOfThree) * Math.pow(2, timesOf2));
    }
}
