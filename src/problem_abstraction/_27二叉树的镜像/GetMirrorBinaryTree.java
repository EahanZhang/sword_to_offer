package problem_abstraction._27二叉树的镜像;

/**
 * Created by sunshine on 2018/8/4.
 */

import utils.TreeNode;

/**
 * 题目：
 *  操作给定的二叉树，将其变换为源二叉树的镜像。
 *
 * 思路：
 *  遍历二叉树，若其左右子节点均存在，交换两个节点， 继续遍历其左子树和右子树， 直至遍历完所有子节点。
 *
 *
 */
public class GetMirrorBinaryTree {

    public void Mirror(TreeNode root) {
        if (root == null) return ;
        if (root.left == null && root.right == null) return ;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if (root.left != null) Mirror(root.left);
        if (root.right != null) Mirror(root.right);
    }
}
