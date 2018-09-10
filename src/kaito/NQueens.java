package kaito;

import java.util.Arrays;

/**
 * n 个皇后棋子放在 n*n 的棋盘上
 * 皇后棋子可横直斜走，且格数不限
 * 有几种初始摆法。
 *
 * @author kaito
 * @date 2018/8/20 上午1:15
 */
public class NQueens {
    private static final int QUEEN = 1;
    private static final int EMPTY = 0;
    private static final int UNABLE = -1;

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        int i4 = nQueens.totalNQueens(2);
        System.out.println(i4);
    }

    public int totalNQueens(int n) {
        int[][] totalBlock = new int[n][n];
        iterArray(totalBlock, n);
        return total;
    }
    int total = 0;

    /**
     * 说明：
     * 正方形的棋盘，同一个下棋方案可以分别拓展4个方向的，需要避免重复计算
     */
    private void iterArray(int[][] totalBlock, int queueCount) {
        for (int i = 0; i < totalBlock.length; i++) {
            for (int j = 0; j < (i == 0 ? (totalBlock.length + 2) / 2 : totalBlock[i].length); j++) {
                //一直遍历到可以下棋的位置
                if (totalBlock[i][j] == EMPTY) {
                    int[][] totalBlockCopy = copyArrary(totalBlock);
                    pressQueen(totalBlock, i, j);
                    queueCount--;
                    if (queueCount == 0) {
                        print(totalBlock);
//                        System.out.println("success");
                        total++;
                        //回退
                        totalBlock = totalBlockCopy;
                        totalBlock[i][j] = UNABLE;
                        queueCount++;
                    }
                    iterArray(totalBlock, queueCount);
                    //失败，回退这一步
                    //遍历不到可以下棋的地方了，回退一步
                    totalBlock = totalBlockCopy;
                    queueCount++;
                    totalBlock[i][j] = UNABLE;
//                    System.out.println("back");
//                    print(totalBlock);
                }
            }
        }
    }
    private int[][] copyArrary(int[][] totalBlock) {
        int[][] ints = new int[totalBlock.length][totalBlock.length];
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                ints[i][j] = totalBlock[i][j];
            }
        }
        return ints;
    }

    private void pressQueen(int[][] totalBlock, int i1, int j1) {
        for (int i = 0; i < totalBlock.length; i++) {
            totalBlock[i1][i] = UNABLE;
        }
        for (int i = 0; i < totalBlock.length; i++) {
            totalBlock[i][j1] = UNABLE;
        }
        //斜的
        for (int i = 1; i1 - i > 0 && j1 - i > 0; i++) {
            totalBlock[i1 - i][j1 - i] = UNABLE;
        }
        for (int i = 1; i1 + i < totalBlock.length && j1 + i < totalBlock.length; i++) {
            totalBlock[i1 + i][j1 + i] = UNABLE;
        }
        //斜的有两个方向
        for (int i = 1; i1 - i > 0 && j1 + i < totalBlock.length; i++) {
            totalBlock[i1 - i][j1 + i] = UNABLE;
        } for (int i = 1; i1 + i < totalBlock.length && j1 - i > 0; i++) {
            totalBlock[i1 + i][j1 - i] = UNABLE;
        }
        totalBlock[j1][i1] = UNABLE;
        totalBlock[i1][j1] = QUEEN;
    }
    private void print(int[][] totalBlock) {
        for (int[] ints : totalBlock) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();
    }
}
