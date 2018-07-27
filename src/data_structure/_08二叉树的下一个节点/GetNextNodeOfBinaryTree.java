package data_structure._08二叉树的下一个节点;

/**
 * Created By GetNextNodeOfBinaryTree on 2018/7/27
 */

import utils.TreeLinkNode;

/**
 * 题目：
 *  给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 *  注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 * 思路：
 *  中序遍历序列中当前节点p的下一个节点有三种情况：
 *  1. 若p有右子树， 则下一个节点为右子树的最左节点
 *  2. 若p没有右子树，且有父节点
 *   2.1 若p为其父节点的右子树， 则从节点p开始一直向上查找，直到找到一个是其父节点左子节点的节点，该节点的父节点即为要找的节点；
 *   2.1 若p为其父节点的左子树， 则下一个节点为父节点；
 *  3. 若p没有右子树且没有父节点，则下一个节点为null
 */

public class GetNextNodeOfBinaryTree {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) return null;
        if (pNode.right != null) { // 有右子树
            TreeLinkNode rightChild = pNode.right;
            while (rightChild.left != null) rightChild = rightChild.left;
            return rightChild;
        } else { // 没有右子树
            if (pNode.next == null) return null; // 没有父节点，返回null
            else { // 有父节点
                if (pNode.next.left == pNode) { // pNode为其父节点的左子树
                    return pNode.next;
                } else { // pNode为其父节点的右子树
                    TreeLinkNode p = pNode;
                    while (p.next != null && p.next.right == p) p = p.next; // 一直向上找，直到不为右子树
                    return p.next;
                }
            }
        }
    }
}
