package code_integrity._18删除链表中重复的节点;

/**
 * Created By sunshine on 2018/8/2
 */

import utils.ListNode;

/**
 * 题目：
 *  在一个排序的链表中，存在重复的结点，
 *  请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 *  例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 * 思路：
 *  1. 因为链表是有序的，所以可以判断当前节点和其下一个节点是否重复。
 *   1.1 若当前节点与下一个节点重复，则继续往下一直找到与当前节点不重复的节点
 *   1.2 若不重复，当前节点向下一个节点挪动
 */

public class DeleteDuplicatedNode {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) return pHead;

        ListNode curHead = new ListNode(-1);
        curHead.next = pHead;
        ListNode p = pHead;
        ListNode preP = curHead;
        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                int val = p.val;
                ListNode q = p.next.next;
                while (q != null) {
                    if (q.val != val) break;
                    q = q.next;
                }
                p = q;
                preP.next = p;
            } else {
                preP = p;
                p = p.next;
            }
        }
        return curHead.next;
    }
}
