package kaito;

/**
 * 思路：
 * 1\转成字符串然后按位匹配，但感觉不对，肯定有数学的方法 （x 直接 toBinString 不会补全0
 * 2\取最低位做位运算
 *
 * @author kaito
 * @date 2018/9/9 2:13 AM
 */
public class HammingDistance {
    public static void main(String[] args) {
        System.out.println(new HammingDistance().hammingDistance(1, 4));
    }
    public int hammingDistance(int x, int y) {
        int dis = 0;
        while (!(x == 0 && y == 0)) {
            if (((x & 1) ^ (y & 1)) == 1) {
                dis++;
            }
            x = x >> 1;
            y = y >> 1;
        }
        return dis;
    }
}
