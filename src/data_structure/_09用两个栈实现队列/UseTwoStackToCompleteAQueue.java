package data_structure._09用两个栈实现队列;

/**
 * Created By UseTwoStackToCompleteAQuque on 2018/7/27
 */

import java.util.Stack;

/**
 * 题目：用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 * 思路：
 * 假设两个栈的名字分别为a和b
 * 1. push元素时，将元素添加到stack1中
 * 2. pop元素时
 *  2.1 若stack2不为空，则直接弹出栈顶元素
 *  2.2 若stack2为空，则将stack1中所有元素出栈并压入stack2中，并弹出栈顶元素
 */
public class UseTwoStackToCompleteAQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
