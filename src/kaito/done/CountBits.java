package kaito.done;

import java.util.Arrays;

/**
 * For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 * Example:
 * For num = 5 you should return [0,1,1,2,1,2].
 * Require : O(n)
 *
 * @author kaito
 * @date 2018/9/4 11:46 AM
 */
public class CountBits {

    public static void main(String[] args) {
        int[] ints = new CountBits().countBits(10);
        System.out.println(Arrays.toString(ints));
    }
    /**
     * 那么得到的规律就是，对于偶数，它和它的一半的数的1是相等的。对于奇数，它的1的个数比它的一半的1的个数多1。所以，代码如下：
     */
    public int[] countBits(int num) {
        int[] ints = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            if (i % 2 == 0) {
                ints[i] = ints[i / 2];
            } else {
                ints[i] = ints[i / 2] + 1;

            }
        }
        return ints;
    }
}
