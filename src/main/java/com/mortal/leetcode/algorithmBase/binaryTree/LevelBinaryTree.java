package algorithmBase.binaryTree;

/**
 * @auther mortal
 * @date 2023/9/17 23:15
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue; 

/**
 * 广度优先遍历二叉树
 */
public class LevelBinaryTree {

    public static TreeNode createNode(LinkedList<Integer> linkedList) {
        TreeNode treeNode = null;
        if (linkedList == null || linkedList.isEmpty()) {
            return treeNode;
        }
        Integer data = linkedList.removeFirst();
        if (null != data) {
            treeNode = new TreeNode(data);
            treeNode.leftNode = createNode(linkedList);
            treeNode.rightNode = createNode(linkedList);
        }
        return treeNode;
    }


    public static void levelOrderTranslateWithQueue(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll != null) {
                System.err.print(poll.data);
            }
            if (poll.leftNode != null) {
                queue.offer(poll.leftNode);
            }
            if (poll.rightNode != null) {
                queue.offer(poll.rightNode);
            }
        }
    }


    private static class TreeNode {
        private int data;
        private TreeNode leftNode;
        private TreeNode rightNode;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>(Arrays.asList(new Integer[]{
                3, 2, 9, null, null, 10, null, null, 8, null, 4
        }));
        TreeNode node = createNode(list);
        System.err.println("广度优先遍历结果：");
        levelOrderTranslateWithQueue(node);

    }
}
