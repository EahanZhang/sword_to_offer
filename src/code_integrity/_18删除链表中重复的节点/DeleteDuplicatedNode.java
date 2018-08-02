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
 */

public class DeleteDuplicatedNode {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) return pHead;

        ListNode curHead = new ListNode(Integer.MIN_VALUE);
        curHead.next = pHead;
        ListNode fast = pHead, slow = pHead.next;
        ListNode preFast = curHead, preSlow = pHead;
        boolean isDuplicated = false;
        while (fast != null) {
            while (slow != null) {
                if (fast.val == slow.val) {
                    slow = slow.next;
                    preSlow.next = slow;
                    isDuplicated = true;
                } else {
                    preSlow.next = slow;
                    slow = slow.next;
                }
            }

            if (isDuplicated) {
                fast = fast.next;
                preFast.next = fast;
                isDuplicated = false;
            } else {
                preFast = fast;
                fast = fast.next;
            }
        }
        return curHead.next;
    }

}
