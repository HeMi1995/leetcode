package kaito.done;

import kaito.common.TreeNode;

/**
 * The root is the maximum number in the array.
 * The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
 * The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
 * <p>
 * Input: [3,2,1,6,0,5]
 * Output: return the tree root node representing the following tree:
 * <p>
 * 6
 * /   \
 * 3     5
 * \    /
 * 2  0
 * \
 * 1
 *
 * @author kaito
 * @date 2018/8/28 下午2:19
 */
public class MaxBinaryTree {
    public static void main(String[] args) {
        MaxBinaryTree maxBinaryTree = new MaxBinaryTree();
        TreeNode treeNode = maxBinaryTree.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
        System.out.println(treeNode.val); ;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int maxValue = -1;
        int maxValuePos = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                maxValuePos = i;
            }
        }
        TreeNode root = new TreeNode(maxValue);
        root.left = cycle(nums, 0, maxValuePos);
        root.right = cycle(nums, maxValuePos + 1, nums.length);
        return root;
    }

    private TreeNode cycle(int[] nums, int begin, int end) {
        System.out.println(begin + "|" + end);
        if (begin >= end) {
            return null;
        }
        int maxValue = -1;
        int maxValuePos = -1;
        for (int i = begin; i < end; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                maxValuePos = i;
            }
        }
        TreeNode root = new TreeNode(maxValue);
        root.left = cycle(nums, begin, maxValuePos);
        root.right = cycle(nums, maxValuePos + 1, end);
        return root;
    }


}
