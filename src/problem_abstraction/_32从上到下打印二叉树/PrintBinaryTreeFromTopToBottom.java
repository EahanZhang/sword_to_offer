package problem_abstraction._32从上到下打印二叉树;

/**
 * Created by sunshine on 2018/8/5.
 */

import sun.reflect.generics.tree.Tree;
import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * 题目：
 *  从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 * 思路：
 *  即广度遍历二叉树。 使用队列来处理该问题。
 *  没经过一个节点，将其左右子节点（若存在）放入队尾， 并从队首取出下一个节点。 直到队列为空。
 */
public class PrintBinaryTreeFromTopToBottom {
    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            list.add(curNode.val);
            if (curNode.left != null) queue.add(curNode.left);
            if (curNode.right != null) queue.add(curNode.right);
        }

        return list;
    }
}
