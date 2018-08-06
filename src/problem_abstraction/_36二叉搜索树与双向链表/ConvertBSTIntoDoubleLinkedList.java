package problem_abstraction._36二叉搜索树与双向链表;

/**
 * Created by ehang at 18-8-6
 */

import sun.reflect.generics.tree.Tree;
import utils.TreeNode;

/**
 * 题目：
 *  输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 *  要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 * 思路：
 *  根据二叉搜索树的特点，根节点的左侧元素均小于根节点的值，右侧的元素均大于根节点的值，
 *  且左子树的最右节点maxL是左子树最大的值， 右子树的最左节点minR是右子树最小的值。
 *  并且二叉搜索树的中序序列正好是有序的， 因此可以中序遍历二叉搜索树来构建双向链表
 *
 */
public class ConvertBSTIntoDoubleLinkedList {
	TreeNode head = null;
	TreeNode realHead = null;

	public TreeNode Convert(TreeNode pRootOfTree) {
		helpConvert(pRootOfTree);
		return realHead;
	}

	private void helpConvert(TreeNode root) {
		if (root == null) return ;
		helpConvert(root.left);

		if (head == null) {
			head = root;
			realHead = head;
		} else {
			head.right = root;
			root.left = head;
			head = head.right;
		}

		helpConvert(root.right);
	}
}
