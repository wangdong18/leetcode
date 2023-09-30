package isSymmetric;

import java.util.Stack;

/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 *
 * @auther mortal
 * @date 2023/9/29 22:56
 */
class Solution {

    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dsl(root.left, root.right);

    }

    public boolean dsl(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null && right != null) {
            return false;
        }
        if (left!=null&&right==null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return dsl(left.left, right.right) && dsl(left.right, right.left);
    }

}