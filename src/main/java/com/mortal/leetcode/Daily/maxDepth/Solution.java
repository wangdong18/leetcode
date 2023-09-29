package maxDepth;


import java.util.Arrays;
import java.util.LinkedList;

/**
 * @auther mortal
 * @date 2023/9/28 21:42
 */
class Solution {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>(Arrays.asList(new Integer[]{
                3,9,20,null,null,15,7
        }));
        TreeNode node = createNode(list);
        System.err.println(maxDepth(node));
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


    public static  int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }else {
            int maxleft = maxDepth(root.left);
            int maxrignt = maxDepth(root.right);
            return Math.max(maxleft, maxrignt)+1;
        }
    }



}

