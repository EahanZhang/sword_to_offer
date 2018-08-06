package problem_abstraction._33二叉搜索树的后序遍历序列;

/**
 * Created by ehang at 18-8-6
 */

/**
 * 题目：
 *  输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 *  如果是则输出Yes,否则输出No。
 *  假设输入的数组的任意两个数字都互不相同。
 *
 * 思路：
 *  1. 二叉搜索树的特点是， 左子树的所有元素均小于当前节点的值， 右子树的所有元素均大于当前节点的值
 *  2. 二叉搜索树的后序遍历序列的特点是，序列最后一个节点为根节点。 所有左子树的节点均小于根节点的值且连续。
 *  3. 如果不连续， 说明不是后续遍历序列， return false;
 */
public class VerifySquenceOfBST {

	public boolean verifySquenceOfBST(int[] sequence) {
		if (sequence == null || sequence.length == 0) return false;

		return verifyHelp(sequence, 0, sequence.length - 1);
	}

	private boolean verifyHelp(int[] sequence, int from, int to) {
		if (from == to) return true;

		int curRootValue = sequence[to];

		int curIndex = findLeftChildTreeIndex(sequence, from, to);

		// 如果在右子树序列中存在小于根节点的值，说明不是有效的后序序列，return false;
		for (int i = curIndex; i < to; i++) {
			if (sequence[i] < curRootValue) return false;
		}

		// 判断左子树是不是二叉搜索树
		boolean left = true;
		if (curIndex > 0)
			left = verifyHelp(sequence, from, curIndex - 1);

		boolean right = true;
		if (curIndex < to) {
			left = verifyHelp(sequence, curIndex, to - 1);
		}

		return left && right;
	}

	private int findLeftChildTreeIndex(int[] sequence, int from, int to) {
		int val = sequence[to];
		int index = from;
		while (index < to && sequence[index] < val) {
			index++;
		}
		return index;
	}
}
