package invertTree;

import java.util.LinkedList;

/**
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * @auther mortal
 * @date 2023/9/29 22:44
 */
public class Solution2 {

    public static void main(String[] args) {

    }
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            TreeNode left = temp.left;
            temp.left=temp.right;
            temp.right = left;
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
        return root;
    }



}
