package optimize_time_and_space_efficiency._45把数组排成最小的数;

/**
 * Created By sunshine on 2018/8/7
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 题目：
 *  输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *  例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 *
 * 思路：
 *  将数组中的元素两两拼接成字符串并比较字符串大小， 小的放在前面， 大的放在后面。
 */
public class GetMinNumFromArrayArrangement {
    public String getMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) return null;

        ArrayList<Integer> list = new ArrayList<>();
        for (int i : numbers) list.add(i);

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1 + "" + o2;
                String s2 = o2 + "" + o1;
                return s1.compareTo(s2);
            }
        });

        StringBuffer res = new StringBuffer();
        for (int i : list) res.append(i);
        return res.toString();
    }
}
