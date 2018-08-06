package code_integrity._19正则表达式匹配;

/**
 * Created by sunshine on 2018/8/2.
 */

/**
 * 题目：
 *  请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 *  模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 *  在本题中，匹配是指字符串的所有字符匹配整个模式。
 *  例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配。
 *
 * 思路：
 *  1. 当第二个字符不为'*', 若第一个字符与被匹配字符匹配，则均向后移
 *  2. 当第二个字符为'*'，有三种情况：
 *   2.1 模式字符串往后挪两个位置，匹配字符串不变。即匹配零个(a*被忽略)
 *   2.2 模式字符串往后挪两个位置，匹配字符串往后挪动一个位置。（匹配一个）
 *   2.3 模式字符串不动，匹配字符串往后挪动一位。（*匹配多个）
 */
public class RegexMatch {
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) return false;
        return matchCore(str, 0, pattern, 0);
    }

    private boolean matchCore(char[] str, int posStr, char[] pattern, int posPattern) {
        // 同时到达尾部，匹配成功
        if (posStr == str.length && posPattern == pattern.length) return true;

        // pattern先结束，匹配失败
        if (posStr < str.length && posPattern == pattern.length) return false;

        // pattern[posPattern+1]存在且为*，且str[posStr]与pattern[posPattern]匹配，分三种匹配模式；如不匹配，模式后移
        if (posPattern < pattern.length - 1 && pattern[posPattern+1] == '*') {
            if (posStr != str.length && (pattern[posPattern] == str[posStr] || pattern[posPattern] == '.')) {
                return matchCore(str, posStr, pattern, posPattern + 2)
                        | matchCore(str, posStr + 1, pattern, posPattern + 2)
                        | matchCore(str, posStr + 1, pattern, posPattern);
            } else {
                return matchCore(str, posStr, pattern, posPattern + 2);
            }
        }

        // pattern[posPattern+1]存在且不为'*'， 若str[posStr]与pattern[posPattern]匹配，posStr++,posPattern++,
        if (posStr < str.length && (str[posStr] == pattern[posPattern] || pattern[posPattern] == '.')) {
            return matchCore(str, posStr + 1, pattern, posPattern + 1);
        }
        return false;
    }
}
