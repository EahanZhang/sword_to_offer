package code_robustness._26树的子结构;

import utils.TreeNode;

/**
 * Created by ehang at 18-8-3
 */

/**
 * 题目：
 *  输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *
 * 思路：
 *  1. 为了判断root1中是否有子树root2， 必须要遍历root1。
 *  2. 当root1.val 等于root2.val， 则需要判断root2余下的节点是否与root1一致
 */
public class HasSubtree {
	public boolean hasSubTree(TreeNode root1, TreeNode root2) {
		boolean result = false;

		if (root1 != null && root2 != null) {
			if (root1.val == root2.val) {
				result = doesTree1HasTree2(root1, root2);
			}
			if (!result) {
				result = hasSubTree(root1.left, root2);
			}

			if (!result) {
				result = hasSubTree(root1.right, root2);
			}
		}
		return result;
	}

	private boolean doesTree1HasTree2(TreeNode root1, TreeNode root2) {
		if (root2 == null) return true; // root2最后一个节点匹配结束

		if (root1 == null) return false; // root2还没被匹配完，root1为空，不匹配，返回false

		if (root1.val != root2.val) return false; // 节点值不匹配，返回false;

		// 若当前节点匹配，则继续匹配下一个对应节点
		return doesTree1HasTree2(root1.left, root2.left) && doesTree1HasTree2(root1.right, root2.right);
	}
}
