package optimize_time_and_space_efficiency._44数字序列中某一位的数字;

/**
 * Created By sunshine on 2018/8/7
 */

/**
 * 题目：
 *  数字以0123456789101112131415...的格式序列化到一个字符序列中。 在这个序列中，第五位(从0开始计数)是5，第13位是1等等。
 *  请写一个函数，求任意第n位对应的数字。
 *
 * 思路：
 *  1. 首先定位第n位对应的数字的所在的区间（即是几位数）
 *  2. 再定位到所在的数字
 *  3. 再定位到在数字的第几位
 */

public class GetNumberOfNumberString {
    public int getIndex(int index) {
        if (index < 0) return -1;

        int digits = 1;
        while (true) {
            int numbers = countOfInteger(digits);
            if (index < numbers * digits) {
                // 定位数字
                return 0;
            }

            index -= numbers * digits;
            digits++;
        }
    }

    // 返回n位数的个数， 如2位数为90个，3位数为900个
    private int countOfInteger(int n) {
        if (n == 1) return 10;

        return (int) (9 * Math.pow(10, n - 1));
    }

    private int digitsAtIndex(int index, int digits) {
        int base = 0;
        if (digits != 1) base = (int) Math.pow(10, digits - 1);
        int bit = index % digits;
        int number = index / digits + base;
        int indexFromRight = digits - bit;
        for (int i = 1; i < indexFromRight; i++) {
            number /= 10;
        }

        return number % 10;
    }
}
