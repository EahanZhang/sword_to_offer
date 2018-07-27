package data_structure._07重建二叉树;

/**
 * Created By RebuildBinaryTree on 2018/7/27
 */

import utils.TreeNode;

import java.util.Arrays;

/**
 * 题目：
 *  输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 *  假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *  例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回根节点。
 *
 * 思路：
 *  * 前序遍历序列的第一个元素必为当前树的根节点，如前序遍历序列{1,2,4,7,3,5,6,8}中，1就是根节点元素
 *  * 中序遍历序列中，位于根节点元素左侧的元素为其左子树的元素，位于其右侧的元素为其右子树的元素，
 *    并且元素的顺序仍为中序遍历序列。
 *    如中序遍历序列{4,7,2,1,5,3,8,6}中，1左侧的元素{4,7,2}为其左子树的元素，并且{4,7,2}仍为1的左子树的中序遍历序列
 *  因此：
 *  1. 根据前序遍历序列的第一个元素获得当前树的根节点元素m
 *  2. 在中序遍历序列中找到根节点元素m的位置，其左侧的元素为其左子树，其右侧的元素为其右子树
 *  3. 当遍历序列为空时，返回null
 *  4. 对步骤1,2,3进行递归。
 */
public class RebuildBinaryTree {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || pre.length == 0 || in == null || in.length == 0) return null;

        int rootNodeVal = pre[0];
        int rootPosInIn = findPos(in, rootNodeVal);
        TreeNode root = new TreeNode(rootNodeVal);
        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, rootPosInIn+1), Arrays.copyOfRange(in,0, rootPosInIn));
        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, rootPosInIn+1, pre.length), Arrays.copyOfRange(in,rootPosInIn+1, in.length));
        return root;
    }

    private int findPos(int[] array, int target) {
        if (array == null || array.length == 0) return -1;

        for (int i = 0; i < array.length; i++) {
            if (target == array[i]) return i;
        }
        return -1;
    }


}
