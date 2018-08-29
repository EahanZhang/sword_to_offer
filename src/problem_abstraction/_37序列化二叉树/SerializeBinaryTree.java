package problem_abstraction._37序列化二叉树;

/**
 * Created By sunshine on 2018/8/7
 */

import utils.TreeNode;

/**
 * 题目：
 *  请实现两个函数，分别用来序列化和反序列化二叉树
 *
 * 思路：
 *  序列化二叉树，使用前序遍历二叉树， 遇到空指针则添加'$'符号。
 *  反序列化二叉树， 从左向右遍历， 第一个节点为树的根节点， 当一个节点后面连着两个'$'，说明该节点是叶子节点。
 */
public class SerializeBinaryTree {
//    char[] strArray = null;
    int index;

    public String Serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if (root == null) {
            sb.append("$,");
        } else {
            sb.append(root.val + ",");
            sb.append(Serialize(root.left));
            sb.append(Serialize(root.right));
        }
        return sb.toString();
    }

    public TreeNode Deserialize(String str) {
        if (str == null || str.length() == 0) return null;
        index = -1;
        String[] strArray = str.split(",");
        return helpDeserialize(strArray);
    }

    TreeNode helpDeserialize(String[] array) {

        index++;
        TreeNode treeNode = null;

        if (!array[index].equals("$")) {
            treeNode = new TreeNode(Integer.valueOf(array[index]));
            treeNode.left = helpDeserialize(array);
            treeNode.right = helpDeserialize(array);
        }

        return treeNode;
    }
}
