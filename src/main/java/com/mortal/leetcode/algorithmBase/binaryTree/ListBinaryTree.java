package algorithmBase.binaryTree;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

/**
 * 深度优先排序
 * 此类使用循环创建/查找二叉树的相关使用
 */

public class ListBinaryTree {

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


    /**
     * 前序/中序/后序
     */
    public static void preOrderTranslate(TreeNode node) {
        if (node != null) {
            System.err.print(node.data);
            preOrderTranslate(node.leftNode);
            preOrderTranslate(node.rightNode);
        }
    }

    //中序
    public static void midOrderTranslate(TreeNode node) {
        if (node != null) {
            midOrderTranslate(node.leftNode);
            System.err.print(node.data);
            midOrderTranslate(node.rightNode);
        }
    }

    //后序
    public static void postOrderTranslate(TreeNode node) {
        if (node != null) {
            postOrderTranslate(node.leftNode);
            postOrderTranslate(node.rightNode);
            System.err.print(node.data);
        }
    }


    private static class TreeNode {
        private Integer data;
        private TreeNode leftNode;
        private TreeNode rightNode;

        public TreeNode(Integer data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>(Arrays.asList(new Integer[]{
                3, 2, 9, null, null, 10, null, null, 8, null, 4
        }));
        TreeNode node = ListBinaryTree.createNode(list);
        System.err.println("前序排列结果：");
        preOrderTranslate(node);
        System.err.println("");

        System.err.println("中序排列结果：");
        midOrderTranslate(node);
        System.err.println("");

        System.err.println("后序排列结果：");
        postOrderTranslate(node);
        System.err.println("");

    }
}

