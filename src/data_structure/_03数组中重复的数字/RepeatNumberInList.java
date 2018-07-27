package data_structure._03数组中重复的数字;

/**
 * Created By RepeatNumberInList on 2018/7/27
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 思路：
 *  注意到，数组的长度为n，且所有元素的大小皆在[0, n-1]中。
 *  因此，可以根据数组下标来排序数组， 排序后,数字i将出现在下标为i的位置上。
 *  1. 从左到右遍历数组，判断当前元素m是否等于当前数组下标i
 *   1.1 如果m等于i，则i++，扫描下一个数字
 *   1.2 如果m不等于i，则将m和numbers[m]进行比较
 *    1.2.1 如果m等于numbers[m]，则表示该数字重复（在numbers[i]和numbers[m]中均出现过）
 *    1.2.2 如果m不等于numbers[m]， 则将numbers[m]与numbers[i]交换
 *  2. 重复步骤1的比较过程，直到遍历结束。
 *
 */
public class RepeatNumberInList {
    public boolean duplicate(int numbers[],int length, int [] duplication) {
        if (numbers == null || length == 0) return false;

        for (int i = 0; i < length; ) {
            if (numbers[i] == i) i++;
            else {
                if (numbers[i] == numbers[numbers[i]]) { // 找到重复数字
                        duplication[0] = numbers[i];
                        return true;
                } else {
                    int t = numbers[numbers[i]];
                    numbers[numbers[i]] = numbers[i];
                    numbers[i] = t;
                }
            }
        }
        return false;
    }
}
