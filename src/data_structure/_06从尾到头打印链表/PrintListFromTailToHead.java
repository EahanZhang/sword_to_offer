package data_structure._06从尾到头打印链表;

/**
 * Created By PrintListFromTailToHead on 2018/7/27
 */


import utils.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 题目：
 *  输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 *
 * 思路1：遍历链表，并使用ArrayList.add(index, value)方法
 * 思路2：使用栈存储遍历的元素，然后依次输出
 */
public class PrintListFromTailToHead {
    // 思路1 代码实现
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        while (listNode != null) {
            res.add(0, listNode.val);
            listNode = listNode.next;
        }
        return res;
    }

    // 思路2 代码实现
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }
}
