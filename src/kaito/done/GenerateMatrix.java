package kaito.done;


import java.util.Arrays;

/**
 * Input:Input: 3
 * 3
 * Output:Output:
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 *
 * @author kaito
 * @date 2018/9/4 2:09 PM
 */
public class GenerateMatrix {
    public static void main(String[] args) {
        int[][] ints = new GenerateMatrix().generateMatrix(3);
        Arrays.stream(ints).forEach(i -> System.out.println(Arrays.toString(i)));
    }
    public int[][] generateMatrix(int n) {
        int[][] ints = new int[n][n];
        boolean down = true;
        boolean right = true;
        boolean currentRight = true;
        int x = 0, y = 0;
        int init = 1;
        ints[x][y] = init++;
        while (true) {
            /**
             * 判断是否需要拐弯了：
             * 1、当前下一个就越界了
             * 2、下一个的位置上的元素不为 0
             */
            int x1 = x, y1 = y;
            if (!currentRight) {
                x1 = right ? x + 1 : x - 1;
                //边缘
                if (inMargin(x1, n) || ints[x1][y] != 0) {
                    x1 = x;
                    right =!right;
                    int y2 = down ? y + 1 : y - 1;
                    if (inMargin(y2, n) || ints[x1][y2] != 0) {
                        break;
                    }
                    currentRight = !currentRight;
                    continue;
                }
            } else {
                y1 = down ? y + 1 : y - 1;
                if (inMargin(y1, n) || ints[x][y1] != 0) {
                    y1 = y;
                    down =!down;
                    int x2 = right ? x + 1 : x - 1;
                    if (inMargin(x2, n) || ints[x2][y1] != 0) {
                        break;
                    }
                    currentRight = !currentRight;
                    continue;
                }
            }
            ints[x1][y1] = init++;
            x = x1;
            y = y1;
        }




        return ints;
    }

    private boolean inMargin(int x, int n) {
        return x >= n || x < 0;
    }
}
