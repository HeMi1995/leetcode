package kaito;

/**
 * 思路：
 * 递归思想递归计算二叉树的两个二叉，两两比较
 *
 * @author kaito
 * @date 2018/9/9 3:09 AM
 */
public class MaxDepth {

    int maxDepth = 1;
    public int maxDepth(MergeTrees.TreeNode root) {
        if (root == null) {
            return 0;
        }


        return maxDepth;
    }

    public void circle(MergeTrees.TreeNode root) {

        circleLeft(root);
        circleRight(root);
        maxDepth = Math.max(left, right);
        left = 0; right = 0;
        
    }

    int left = 0;
    public void circleLeft(MergeTrees.TreeNode root) {
        if (root.left == null) {
            return;
        }
        left++;
        circleLeft(root.left);
    }
    int right = 0;
    public void circleRight(MergeTrees.TreeNode root) {
        if (root.right == null) {
            return;
        }
        right++;
        circleRight(root.right);
    }
}
