package data_structure._05替换空格;

/**
 * Created By ReplaceSpaces on 2018/7/27
 */

/**
 * 题目：
 *  请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 *  例如，当字符串为We Are Happy.
 *  则经过替换之后的字符串为We%20Are%20Happy。
 */

/**
 * 思路：
 *  1. 若传入的str为空， 返回空
 *  2. 将str转换为char数组并遍历该char数组，用StringBuffer对象存储遍历结果
 *   2.1 若ch[i]为空格，StringBuffer.append("%20");
 *   2.2 若ch[i]不为空格，StringBuffer.append(ch[i]);
 */

public class ReplaceSpaces {
    public String replaceSpace(StringBuffer str) {
        if (str == null) return null;

        StringBuffer resStr = new StringBuffer();
        char[] ch = str.toString().toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == ' ') resStr.append("%20");
            else resStr.append(ch[i]);
        }
        return resStr.toString();
    }
}
