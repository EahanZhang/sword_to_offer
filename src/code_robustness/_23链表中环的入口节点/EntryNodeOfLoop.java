package code_robustness._23链表中环的入口节点;

import utils.ListNode;

/**
 * Created by ehang at 18-8-3
 */

/**
 * 题目：
 *  给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 *
 * 思路：
 *  使用两个指针fast和slow，fast每次移动两格， slow只移动一格，
 *  当fast和slow再次相遇时，其位置pos1必定在环内。 否则， 链表中不存在环。
 *  从pos1开始fast再次移动，这次一次移动一格， 并记录移动次数，
 *  当fast再次与slow相遇时，移动次数即为环的长度l
 *  根据长度l，再将fast和slow从head开始向后移动， fast先向移动l距离， 然后slow和fast同时向前移
 *  当slow和fast相遇时， 所在的位置即为环的入口.
 *   （解释：
 *   	假设相遇时挪动了x次，则相遇时slow移动的距离为x， fast移动的距离为x + l
 *      此时， 由于环的长度为l且两个节点相遇，因此fast比slow夺走了l的距离， 刚好一个环的长度，因此slow所在的位置即为环的入口
 *      )
 *
 *
 */
public class EntryNodeOfLoop {
	public ListNode entryNodeOfLoop(ListNode pHead) {
		// 单个节点不能成环; 第二个节点的下一个节点为空， 也不成环
		if (pHead == null || pHead.next == null || pHead.next.next == null) {
			return null;
		}

		ListNode fast = pHead.next.next, slow = pHead.next;
		while (fast != slow) {
			if (fast.next != null && fast.next.next != null) {
				fast = fast.next.next;
				slow = slow.next;
			} else { // 不成环
				return null;
			}
		}

		// 能结束while循环说明存在环
		// 寻找环的长度
		fast = fast.next;
		int loopLength = 1;
		while (fast != slow) {
			loopLength++;
			fast = fast.next;
		}

		// 根据length寻找环的入口
		fast = pHead;
		slow = pHead;
		for (int i = 0; i < loopLength - 1; i++) {
			fast = fast.next;
		}

		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}

		return slow;
	}
}
