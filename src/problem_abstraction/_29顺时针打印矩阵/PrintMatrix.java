package problem_abstraction._29顺时针打印矩阵;

import java.util.ArrayList;

/**
 * Created by sunshine on 2018/8/4.
 */

/**
 * 题目：
 *  输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 *  例如，
 *  如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 *  则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 * 思路：
 *  使用一个boolean矩阵标识走过的位置。顺时针打印矩阵
 */
public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if (matrix == null) return arrayList;
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;
        int elementNumber = rowLength * columnLength;

        boolean [][] hasPrint = new boolean[rowLength][columnLength];
        int numberHasPrinted = 0;
        boolean goRight = true, goDown = false, goLeft = false, goUp = false;
        int i = 0, j = 0;

        while (numberHasPrinted < elementNumber) {
            arrayList.add(matrix[i][j]);
            numberHasPrinted++;
            hasPrint[i][j] = true;
            if (goRight) {
                if (j < columnLength - 1 && !hasPrint[i][j+1]) {
                    j++;
                } else {
                    i++;
                    goRight = false;
                    goDown = true;
                }
            } else if (goDown) {
                if (i < rowLength -1 && !hasPrint[i+1][j]) {
                    i++;
                } else {
                    j--;
                    goDown = false;
                    goLeft = true;
                }
            } else if (goLeft) {
                if (j > 0 && !hasPrint[i][j-1]) {
                    j--;
                } else {
                    i--;
                    goLeft = false;
                    goUp = true;
                }
            } else if (goUp) {
                if (i > 0 && !hasPrint[i-1][j]) {
                    i--;
                } else {
                    j++;
                    goUp = false;
                    goRight = true;
                }
            }
        }

        return arrayList;
    }
}
