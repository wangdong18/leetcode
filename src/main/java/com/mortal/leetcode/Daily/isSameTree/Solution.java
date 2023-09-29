package isSameTree;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @auther mortal
 * @date 2023/9/29 21:13
 */
public class Solution {

    public static void main(String[] args) {
        LinkedList<Integer> leftList = new LinkedList<Integer>(Arrays.asList(new Integer[]{
                10, 5, null, null, 15
        }));
        LinkedList<Integer> rightlist = new LinkedList<Integer>(Arrays.asList(new Integer[]{
                1, null, 2
        }));
        TreeNode leftnode = createNode(leftList);
        TreeNode rightnode = createNode(rightlist);
        System.err.println(isSameTree(leftnode, rightnode));
    }

    public static TreeNode createNode(LinkedList<Integer> linkedList) {
        TreeNode treeNode = null;
        if (linkedList == null || linkedList.isEmpty()) {
            return treeNode;
        }
        Integer data = linkedList.removeFirst();
        if (null != data) {
            treeNode = new TreeNode(data);
            treeNode.left = createNode(linkedList);
            treeNode.right = createNode(linkedList);
        }
        return treeNode;
    }

/*       自己的方法就是冗长且没有到重点
        public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q != null) {
            return false;
        } else if (p != null && q == null) {
            return false;
        } else if (p == null && q == null) {
            return true;
        } else {
            if (p.val != q.val) {
                return false;
            }
            boolean right = isSameTree(p.left, q.left);
            boolean left = isSameTree(p.left, q.left);
            return right && left;
        }
    }*/
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        }else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
