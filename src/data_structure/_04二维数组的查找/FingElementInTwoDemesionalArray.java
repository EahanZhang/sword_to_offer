package data_structure._04二维数组的查找;

/**
 * Created by sunshine on 2018/7/27.
 */

/**
 * 题目：
 *  在一个二维数组中（每个一维数组的长度相同），
 *  每一行都按照从左到右递增的顺序排序，
 *  每一列都按照从上到下递增的顺序排序。
 *  请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */

/**
 * 思路：
 *    1. 由于二维数组的每一行，每一列都是递增排序，因此每一行最后一个元素一定是当前行最大的元素，并且每一列的第一个元素一定是当前列最小的元素。
 *    2. 所以可以从二维数组右上角的元素开始遍历：
 *      2.1 若当前元素等于target，则返回true
 *      2.2 若当前元素小于target，说明，当前元素所在行的所有元素均小于target，舍去该行（即rows++）
 *      2.3 若当前元素大于target，说明，当前元素所在列的所有元素均大于target，舍去该列（即columns--）
 *      2.4 若rows == array.length || columns == -1，说明数组中不存在值为target的元素，return false
 *
 */
public class FingElementInTwoDemesionalArray {
    public boolean find(int target, int [][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) return false;

        int rows = 0, columns = array[0].length - 1;
        while (rows < array.length && columns >= 0) {
            if (array[rows][columns] == target) return true;
            else if (array[rows][columns] > target) columns--;
            else rows++;
        }
        return false;
    }
}
