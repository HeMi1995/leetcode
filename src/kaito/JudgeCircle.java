package kaito;

/**
 * @author kaito
 * @date 2018/9/9 2:42 AM
 */
public class JudgeCircle {

    public static void main(String[] args) {
        System.out.println(new JudgeCircle().judgeCircle("UD"));
        System.out.println(new JudgeCircle().judgeCircle("LL"));
    }

    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        char[] chars = moves.toCharArray();
        for (char aChar : chars) {
            switch (aChar) {
                case 'L': {
                    x--;
                    break;
                }
                case 'R': {
                    x++;
                    break;
                }
                case 'U': {
                    y++;
                    break;
                }
                case 'D': {
                    y--;
                    break;
                }
                default:
            }
        }
        return x == 0 && y == 0;
    }
}
