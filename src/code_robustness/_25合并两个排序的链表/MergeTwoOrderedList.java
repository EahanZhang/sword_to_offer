package code_robustness._25合并两个排序的链表;

import utils.ListNode;

/**
 * Created by ehang at 18-8-3
 */

/**
 * 题目：
 *  输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *
 * 思路：
 *  1.首先新建一个节点newHead，用于当作合并后链表的头节点，并新建一个指针mergePos指向newHead
 *  2.使用两个指针posList1和posList2分别指向两个链表
 *  3.比较两个指针指向的节点的值的大小， 将值小的节点接到merge后， 并且mergePos和指向值较小的节点均向后移
 *  4. 重复3直到两个指针中至少有一个指向null
 *  5. 判断哪个指针为null, 将另外一个指针接到mergePos后
 *  6. 返回newHead.next
 */

public class MergeTwoOrderedList {
	public ListNode Merge(ListNode list1, ListNode list2) {
		if (list1 == null) {
			return list2;
		} else if (list2 == null) {
			return list1;
		}

		ListNode newHead = new ListNode(-1);
		ListNode mergePos = newHead;
		ListNode posList1 = list1, posList2 = list2;
		while (posList1 != null && posList2 != null) {
			if (posList1.val < posList2.val) {
				mergePos.next = posList1;
				posList1 = posList1.next;
			} else {
				mergePos.next = posList2;
				posList2 = posList2.next;
			}
			mergePos = mergePos.next;
		}

		if (posList1 == null) {
			mergePos.next = posList2;
		} else {
			mergePos.next = posList1;
		}

		return newHead.next;
	}


}
