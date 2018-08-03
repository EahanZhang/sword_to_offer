package code_integrity._21调整数组顺序使奇数位于偶数前面;

/**
 * Created by ehang at 18-8-3
 */

/**
 * 题目：
 *  输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 *  使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分。
 *
 * 思路：
 *  1. 使用两个指针head, tail，分别指向数组的头和尾
 *  2. 当head指向偶数且tail指向奇数是，交换两者的值
 */
public class ReOrderArray {
	public void reOrderArray(int[] array) {
		if (array == null || array.length <= 1) return ;
		int head = 0, tail = array.length - 1;
		while (head < tail) {
			while (!isEven(array[head])) head++;
			while (isEven(array[tail])) tail--;

			if (head < tail) {
				int temp = array[head];
				array[head] = array[tail];
				array[tail] = temp;
			}
		}
	}

	private boolean isEven(int n) {
		return (n & 1) == 0;
	}
}
