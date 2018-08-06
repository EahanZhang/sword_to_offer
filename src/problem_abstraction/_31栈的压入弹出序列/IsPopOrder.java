package problem_abstraction._31栈的压入弹出序列;

/**
 * Created by sunshine on 2018/8/5.
 */

import java.util.Stack;

/**
 * 题目：
 *  输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 *  假设压入栈的所有数字均不相等。
 *  例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 *  但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 *
 * 思路：
 *  使用堆栈来处理这个问题。
 *  1. 若堆栈不为空且栈顶元素等于当前指针指向的第二个序列的元素， 弹出栈顶元素，指针后移
 *      否则，压入第一个序列的元素。
 *  2. 若第一个序列的元素全部压完， 不断判断栈顶元素与第二个序列的元素是否匹配，若不匹配返回false， 若全匹配，返回true.
 *
 */
public class IsPopOrder {
    public boolean isPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null || pushA.length != popA.length) return false;
        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0;
        while (i < pushA.length) {
            if (!stack.isEmpty() && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            } else {
                stack.push(pushA[i++]);
            }
        }

        while (j < popA.length) {
            if (popA[j] == stack.peek()) {
                stack.pop();
                j++;
            } else {
                return false;
            }
        }

        return true;
    }
}
