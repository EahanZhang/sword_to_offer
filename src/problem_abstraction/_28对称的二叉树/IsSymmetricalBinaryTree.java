package problem_abstraction._28对称的二叉树;

import utils.TreeNode;

/**
 * Created by sunshine on 2018/8/4.
 */

/**
 * 题目：
 *  请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 *
 * 思路：
 *  通过画图可知， 对称二叉树需满足：
 *   1. root.left = root.right
 *   2. root.left.left = root.right.right
 *   3. root.left.right = root.right.left
 *  因此，可以使用递归， 比较root的两个子节点， 并递归比较其左子节点的左子节点与右子节点的右子节点的值以及其左子节点的右子节点与右子节点的左子节点的值。
 *
 * p.s. 可以通过比较LSR 和 RSL序列是否相同来判断是否对称。
 */
public class IsSymmetricalBinaryTree {
    public boolean isSysmmetricalBinaryTree(TreeNode root) {
        return help(root, root);
    }

    private boolean help(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;

        if (node1 == null || node2 == null) return false;

        if (node1.val != node2.val) return false;

        return help(node1.left, node2.right) && help(node1.right, node2.left);
    }

}
