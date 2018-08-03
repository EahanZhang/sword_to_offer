package code_robustness._24反转链表;

/**
 * Created by ehang at 18-8-3
 */

import utils.ListNode;

/**
 * 题目：
 *  输入一个链表，反转链表后，输出新链表的表头。
 *
 * 思路：
 *  因为链表为单向链表， 不能直接反转。
 *  1. 新建一个节点， 用于帮助反转
 *  2. 遍历传入的链表，改变链表next指针的指向
 *
 */
public class ReverseList {
	public ListNode reverseList(ListNode head) {
		// 链表为空或只有一个元素，无需反转
		if (head == null || head.next == null) return head;

		ListNode helpHead = new ListNode(-1);
		ListNode node = head;
		while (node != null) {
			node.next = helpHead.next;
			helpHead.next = node;
		}

		return helpHead.next;
	}
}
