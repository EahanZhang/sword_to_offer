package problem_abstraction._34二叉树中和为某一值的路径;

/**
 * Created by ehang at 18-8-6
 */

import utils.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 题目：
 *  输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 *  路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 *  (注意: 在返回值的list中，数组长度大的数组靠前)
 *
 * 思路：
 *  1. 需要遍历每一条可能的路径，然后找出匹配的路径。
 *  2. 使用回溯法。
 */
public class FindPathInBTWhereSumEqualsK {
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if (root == null) return res;

		ArrayList<Integer> tempArray = new ArrayList<>();
		findPathHelp(root, target, res, tempArray);
		res.sort(new Comparator<ArrayList<Integer>>() {
			@Override
			public int compare(ArrayList<Integer> integers, ArrayList<Integer> t1) {
				return integers.size() < t1.size() ? 1 : -1;
			}
		});
		return res;
	}

	private void findPathHelp(TreeNode root, int target, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> tempArray) {
		tempArray.add(root.val);
		if (root.val == target && root.left == null && root.right == null) {
			res.add(new ArrayList<>(tempArray));
		} else {

			if (root.left != null) {
				findPathHelp(root.left, target - root.val, res, tempArray);
			}

			if (root.right != null) {
				findPathHelp(root.right, target - root.val, res, tempArray);
			}
		}
		tempArray.remove(tempArray.size() - 1);
	}

}
