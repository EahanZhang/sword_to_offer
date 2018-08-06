package problem_abstraction._35复杂链表的复制;

import utils.RandomListNode;

import java.util.Random;

/**
 * Created by ehang at 18-8-6
 */

/**
 * 题目：
 *  输入一个复杂链表
 *  （每个节点中有节点值，以及两个指针，
 *    一个指向下一个节点，另一个特殊指针指向任意一个节点），
 *    返回结果为复制后复杂链表的head。
 *  （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 * 思路：
 *  1. 复制链表的普通部分
 *   1.1 复制链表的每一个节点，并将复制得到的节点放在被复制节点之后， 即node.next = cloneNode
 *  2. 复制特殊指针
 *   2.1 由于被复制节点和复制节点相邻，所以被复制节点的特殊指针指向的节点的next就是复制节点特殊指针应该指向的节点
 *  3. 拆分链表
 *   3.1 偶数个节点为复制得到的节点
 */

public class ComplexListNodeClone {
	public RandomListNode clone(RandomListNode pHead) {
		if (pHead == null) return pHead;

		if (pHead == null) return null;
		RandomListNode curNode = pHead;

		// 复制节点A为A1，并将A1放在A后面
		while (curNode != null) {
			RandomListNode newNode = new RandomListNode(curNode.label);
			newNode.next = curNode.next;
			curNode.next = newNode;

			curNode = curNode.next.next;
		}

		// 确定random指针的指向
		curNode = pHead;
		while (curNode != null && curNode.next != null) {
			if (curNode.random == null) {
				curNode.next.random = null;
			} else {
				curNode.next.random = curNode.random.next;
			}

			curNode = curNode.next.next;
		}

		// 将新得到的链表拆分出目标链表
		RandomListNode head = pHead.next;
		RandomListNode rstNode = head;
		curNode = pHead;

		while (curNode != null) {
			curNode.next = curNode.next.next;
			if (rstNode.next != null) {
				rstNode.next =rstNode.next.next;
			}
			curNode = curNode.next;
			rstNode = rstNode.next;
		}

		return head;
	}
}
