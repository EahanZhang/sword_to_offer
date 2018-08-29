package optimize_time_and_space_efficiency._39数组中出现次数超过一半的数字;

/**
 * Created By sunshine on 2018/8/7
 */

/**
 * 题目：
 *  数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *  例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 *  由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 *  如果不存在则输出0。
 *
 * 思路：
 *  使用一个计数器count， 初始值为1，初始数字curNum为a[0]，
 *  从数组第二个元素开始，比较a[i]与a[0]的值， 若相等，则count++, 若不等, count--
 *  若count等于零， 则将curNum变为a[i], count变为1， 继续向后遍历， 最后的curNum即为所求
 */

public class MoreThanHalfNum {
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int curNum = array[0];
        int count = 1;

        for (int i = 1; i < array.length; i++) {
            if (count == 0) {
                curNum = array[i];
                count = 1;
            } else {
                if (array[i] == curNum) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        count = 0;
        for (int i = 0; i < array.length; i++)
            if (array[i] == curNum) count++;

        if (count << 1 <= array.length) return 0;
        else return curNum;

    }
}
