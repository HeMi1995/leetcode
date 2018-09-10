package kaito.todo;

import kaito.common.TreeNode;

/**
 * @author kaito
 * @date 2018/9/9 3:02 AM
 */
public class MergeTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1== null){
            return t2;
        }
        if (t2 == null){
            return t1;
        }
        t1.val += t2.val;
        if (t1.left == null){
            t1.left = t2.left;
        }else {
            t1.left = mergeTrees(t1.left,t2.left);
        }
        if (t1.right == null){
            t1.right = t2.right;
        }else {
            t1.right = mergeTrees(t1.right,t2.right);
        }
        return t1;
    }

}
