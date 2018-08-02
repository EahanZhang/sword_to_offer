package algorithm_and_data_operation._13机器人的运动范围;

/**
 * Created By TheRangeRobotCanMove on 2018/7/30
 */

/**
 * 题目：
 *  地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 *  每一次只能向左，右，上，下四个方向移动一格，
 *  但是不能进入行坐标和列坐标的数位之和大于k的格子。
 *  例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 *  但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 *  请问该机器人能够达到多少个格子？
 *
 *  思路：
 *   1. 使用boolean二维数组记录当前位置是否经历过。
 *   1. 判断当前位置是否是合法的，
 *    1.1 如果合法，则用递归判断其上下左右的位置是否有效，返回累加值再加1
 *    1.2 如果不合法，则返回0
 */

public class TheRangeRobotCanMove {
    public int movingCount(int threshold, int rows, int cols) {
        if (rows <= 0 || cols <= 0 || threshold < 0) return 0;
        boolean[][] hasPassed = new boolean[rows][cols];
        return movingCountHelp(threshold, rows, cols, 0, 0, hasPassed);
    }

    private int movingCountHelp(int threshold, int rows, int cols, int curRows, int curCols, boolean[][] hasPassed) {
        if (curRows >= 0 && curRows < rows && curCols >= 0 && curCols < cols &&
                getSum(curRows) + getSum(curCols) <= threshold
                && !hasPassed[curRows][curCols]) {
            hasPassed[curRows][curCols] = true;
            return 1 + movingCountHelp(threshold, rows, cols, curRows + 1, curCols, hasPassed)
                    + movingCountHelp(threshold, rows, cols, curRows - 1, curCols, hasPassed)
                    + movingCountHelp(threshold, rows, cols, curRows, curCols + 1, hasPassed)
                    + movingCountHelp(threshold, rows, cols, curRows, curCols - 1, hasPassed);
        } else {
            return 0;
        }
    }

    private int getSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
