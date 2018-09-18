package kaito.todo;

import java.util.Arrays;

/**
 * 偶数放到前面
 * 思路：一个标记位记录偶数的位置，通过循环遍历返现是偶数就和这个位置的数据进行交换
 * https://lingkou.com/problems/sort-array-by-parity/description/
 * @author kaito
 * @date 2018/9/18 10:59 AM
 */
public class SortArrayByParity {
    public static void main(String[] args) {
//        int a[] = {1,2,3,4,5,6};
        int a[] = {2,1,3,4,5,6};
        System.out.println(Arrays.toString(new SortArrayByParity().sortArrayByParity(a)));
    }
    public int[] sortArrayByParity(int[] A) {
        int oddSize =0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 ==0){
                int temp = A[i];
                A[i] = A[oddSize];
                A[oddSize] = temp;
                oddSize++;
            }

        }
        return A;
    }
}
