package kaito.done;

import java.util.Arrays;

/**
 * @author kaito
 * @date 2018/9/9 2:22 AM
 */
public class FlipAndInvertImage {
    public static void main(String[] args) {
//        int[][] ints = {
//                {1, 1, 0},
//                {1, 0, 1},
//                {0, 0, 0}
//        };
        int[][] ints = {
                {1, 1, 0, 0},
                {1, 0, 0, 1},
                {0, 1, 1, 1},
                {1, 0, 1, 0}
        };
        Arrays.stream(new FlipAndInvertImage().flipAndInvertImage(ints)).forEach(i -> System.out.println(Arrays.toString(i)));

    }

    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < (A[i].length + 1) / 2; j++) {
                int j2 = A[i].length - j - 1;
                if (j == j2) {
                    A[i][j] = A[i][j] ^ 1;
                } else {
                    int a = A[i][j];
                    int b = A[i][j2];
                    if ((a ^ b) == 1) {
                        continue;
                    }
                    A[i][j] = A[i][j] ^ 1;
                    A[i][j2] = A[i][j2] ^ 1;
                }
            }
        }
        return A;
    }
}
