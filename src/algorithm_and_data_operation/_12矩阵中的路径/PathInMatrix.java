package algorithm_and_data_operation._12矩阵中的路径;

/**
 * Created By PathInMatrix on 2018/7/27
 */

/**
 * 题目：
 *  请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 *  路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 *  如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 *  例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，
 *  但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 *
 * 思路：
 *  这是一个典型的用回溯法解决的问题。
 *  1. 首先找到矩阵中与字符串首个字符匹配的位置
 *  2. 判断该位置上下左右的字符是否与下一个字符匹配
 *   2.1 如果匹配，则对下下个字符重复步骤2， 如果下个字符为最后一个字符，则表示匹配成功，返回true
 *   2.2 如果均不匹配，返回false
 */
public class PathInMatrix {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || matrix.length == 0
                || str == null || str.length == 0
                || matrix.length != rows * cols
                || matrix.length < str.length)
            return false;

        char[][] curMatrix = new char[rows][cols];
        boolean[][] hasUsed = new boolean[rows][cols];
        boolean hasPath = false;
        for (int i = 0; i < matrix.length; i++) {
            int curRows = i / cols;
            int curCols = i % cols;
            curMatrix[curRows][curCols] = matrix[i];
            hasUsed[curRows][curCols] = false;
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] == str[0]) {
                int curRows = i / cols;
                int curCols = i % cols;
                hasUsed[curRows][curCols] = true;
                hasPath |= hasPathCore(curMatrix, rows, cols, curRows, curCols, hasUsed, str, 1);
                hasUsed[curRows][curCols] = false;
            }
        }

        return hasPath;
    }

    private boolean hasPathCore(char[][] matrix, int rows, int cols, int curRows, int curCols, boolean[][] hasUsed, char[] str, int strPos) {
        boolean toRight = false, toLeft = false, toUp = false, toDown = false;
        if (strPos == str.length) return true;
        // toDown
        if (curRows < rows - 1
                && !hasUsed[curRows + 1][curCols]
                && matrix[curRows + 1][curCols] == str[strPos]) {
            hasUsed[curRows + 1][curCols] = true;
            toDown = hasPathCore(matrix, rows, cols, curRows + 1, curCols, hasUsed, str, strPos+1);
            hasUsed[curRows + 1][curCols] = false;
        }
        // toUp
        if (curRows > 0
                && !hasUsed[curRows - 1][curCols]
                && matrix[curRows - 1][curCols] == str[strPos]) {
            hasUsed[curRows - 1][curCols] = true;
            toUp = hasPathCore(matrix, rows, cols, curRows - 1, curCols, hasUsed, str, strPos+1);
            hasUsed[curRows - 1][curCols] = false;
        }
        // toRight
        if (curCols < cols - 1
                && !hasUsed[curRows][curCols + 1]
                && matrix[curRows][curCols + 1] == str[strPos]) {
            hasUsed[curRows][curCols + 1] = true;
            toRight = hasPathCore(matrix, rows, cols, curRows, curCols + 1, hasUsed, str, strPos+1);
            hasUsed[curRows][curCols + 1] = false;
        }
        // toLeft
        if (curCols > 0
                && !hasUsed[curRows][curCols - 1]
                && matrix[curRows][curCols - 1] == str[strPos]) {
            hasUsed[curRows][curCols - 1] = true;
            toLeft = hasPathCore(matrix, rows, cols, curRows, curCols - 1, hasUsed, str, strPos+1);
            hasUsed[curRows][curCols - 1] = false;
        }

        return toDown | toLeft | toRight | toUp;
    }
}
