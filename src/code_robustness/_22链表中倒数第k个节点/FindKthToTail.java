package code_robustness._22链表中倒数第k个节点;

/**
 * Created by ehang at 18-8-3
 */

import utils.ListNode;

/**
 * 题目：
 *  输入一个链表， 输出该链表中倒数第k个节点。
 *
 * 思路：
 *  使用fast和tail两个指针，tail指针先向后移动K个位置，
 *  然后fast和tail同时向后移动， 当tail指向空时，fast指向的节点就是倒数第k个节点
 */
public class FindKthToTail {
	public ListNode findKthToTail(ListNode head, int k) {
		if (head == null) return null;

		ListNode fast = head, slow = head;
		for (int i = 0; i < k; i++) {
			if (slow != null) {
				slow = slow.next;
			} else {
				// 链表长度小于K
				return null;
			}
		}

		while (slow != null) {
			fast = fast.next;
			slow = slow.next;
		}
		return fast;
	}

}
