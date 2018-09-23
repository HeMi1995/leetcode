package kaito.done;

/**
 * https://leetcode.com/problems/jewels-and-stones/description/
 * 771
 *
 * @author kaito
 * @date 2018/9/23 2:09 PM
 */
public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        final char[] stone = S.toCharArray();
        final char[] jewel = J.toCharArray();
        for (int i = 0; i < stone.length; i++) {
            for (int j = 0; j < jewel.length; j++) {
            if (stone[i] == jewel[j]){
                count++;
            }
            }
        }
        return count;

    }

}
