package problem_abstraction._30包含min函数的栈;

/**
 * Created by sunshine on 2018/8/5.
 */

import java.util.Stack;

/**
 * 题目：
 *  定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 *
 * 思路：
 *  使用一个辅助栈，每次元素压栈， 同时在辅助栈中压入当前栈中最小的元素的值， 每次弹出元素时，也从辅助栈中弹出元素
 *  这样，辅助栈的栈顶元素永远保持为当前最小元素
 *
 */
public class MinStack {

    private Stack<Integer> minStack = new Stack<>();
    private Stack<Integer> stack = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (!minStack.isEmpty() && node > minStack.peek()) {
            minStack.push(minStack.peek());
        } else {
            minStack.push(node);
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
