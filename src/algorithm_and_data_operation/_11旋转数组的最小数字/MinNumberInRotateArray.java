package algorithm_and_data_operation._11旋转数组的最小数字;

/**
 * Created By MinNumberInRotateArray on 2018/7/27
 */

/**
 * 题目：
 *  把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *  输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 *  例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 *  NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * 思路：
 *  根据题目所给出的特性， 输入的数组在一定意义下仍是有序的（两个有序的数组拼在一起）
 *  所以可以使用二分法查找。取i,j分别指向数组的头和尾，取中间的元素mid来与之判断大小
 *  1. 若a[mid] > a[i] 说明a[mid]必定在前一个非递减数组内，最小数必然在mid和j之间。令i = mid+1
 *  2. 若a[mid] < a[j] 说明a[min]必定在后一个非递减数组内，最小数必然在i和mid之间。令j = mid-1
 *  3. 若a[i] = a[mid] = a[j], 则需要使用顺序查找
 *  4. 若a[i] < a[j] 说明整个数组是非递减排序的，a[i]即为最小数
 */
public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int [] array) {
        if (array == null || array.length == 0) return 0;
        int i = 0, j = array.length - 1, mid = (i + j) / 2;
        if (array[i] == array[j] && array[i] == array[mid]) {
            int min = Integer.MAX_VALUE;
            for (int k = 0; k < array.length; k++) {
                if (array[k] < min) min = array[k];
            }
            return min;
        }
        if (array[i] < array[j]) return array[i];

        while (i < j - 1) {
            if (array[mid] > array[i]) {
                i = mid;
            }
            if (array[mid] < array[j]) {
                j = mid;
            }
            mid = (i + j) / 2;
        }
        return array[j];
    }
}
