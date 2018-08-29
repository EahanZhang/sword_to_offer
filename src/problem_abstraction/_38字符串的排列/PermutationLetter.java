package problem_abstraction._38字符串的排列;

/**
 * Created By sunshine on 2018/8/7
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 题目：
 *  输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 *  例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * 思路：
 *  1. 求出所有可能出现在第一个位置的字符，即把第一个字符和后面的所有字符交换。
 *  2. 固定第一个字符， 求后面所有字符的排列。 这时， 又可以看做 求第二个位置的字符的所有可能， 然后固定第二个字符， 求后面的排列。
 *  因此， 可以使用递归
 */
public class PermutationLetter {

    public ArrayList<String> permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() <= 0) return res;

        // 防止有重复字母导致有重复字符串
        HashSet<String> set = new HashSet<>();
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        help(set, 0, ch);
        for (String s : set) {
            res.add(s);
        }
        return res;
    }

    private void help(HashSet<String> set, int index, char[] ch) {
        if (index == ch.length - 1) { // 若index等于字符串长度，说明遍历结束，添加字符串
            set.add(String.valueOf(ch));
        } else {
            for (int i = index; i < ch.length; i++) {
                if (i != index && ch[i] == ch[index]) continue; // 重复字符， 下一次循环
                swap(ch, i, index); // 转换i和index的字符
                help(set, index + 1, ch); // 固定当前字符， 寻找下一个位置可能的字母
                swap(ch, i, index); // 转换回来， 保持ch不变
            }
        }
    }

    private void swap(char[] ch, int i, int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
}
