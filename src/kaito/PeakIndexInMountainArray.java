package kaito;

/**
 * @author kaito
 * @date 2018/9/9 2:51 AM
 */
public class PeakIndexInMountainArray {
    public static void main(String[] args) {
        int[] ints = {0, 2, 1, 0};
        new PeakIndexInMountainArray().peakIndexInMountainArray(ints);
    }

    public int peakIndexInMountainArray(int[] A) {
        int tempMaxIndex = 1;
        boolean leftOver = false;
        if (A[0] > A[1]) {
            return 0;
        }
        for (int i = 1; i < A.length; i++) {
            if (!leftOver) {
                //正常操作-左峰
                if (A[i - 1] < A[i]) {
                    //更新山顶
                    if (A[i] > A[tempMaxIndex]) {
                        tempMaxIndex = i;
                    }
                    //切换为右峰
                } else {
                    leftOver = true;
                }
            } else {
                if (A[i - 1] <= A[i]) {
                    return 0;
                }
            }
        }
        return tempMaxIndex;
    }
}
