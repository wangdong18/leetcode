package algorithmBase.binaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;


/**
 * 使用栈来创建和使用二叉树
 */
public class StackBinaryTree {

    public static TreeNode createNode(LinkedList<Integer> linkedList) {
        StackBinaryTree.TreeNode treeNode = null;
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
     * 非递归前序遍历二叉树
     */
    public static void preOrderTranslateWithStack(TreeNode node) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = node;
        while (treeNode != null || !stack.isEmpty()) {
            //循环遍历左节点，并入栈
            while (treeNode != null) {
                System.err.print(treeNode.data);
                stack.push(treeNode);
                treeNode = treeNode.leftNode;
            }
            //如果没有左节点，弹出栈节点，访问孩子右节点
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.rightNode;
            }
        }
    }

    //非递归中序遍历二叉树
    public static void midOrderTranslateWithStack(TreeNode node) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = node;
        while (treeNode != null || !stack.isEmpty()) {
            //循环遍历左节点,将左边的数据入栈
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode=treeNode.leftNode;
            }
            //输出该节点，弹出栈节点，访问孩子右节点
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                System.err.print(treeNode.data);
                treeNode = treeNode.rightNode;
            }
        }
    }

    //非递归后序遍历二叉树
    public static void postOrderTranslateWithStack(TreeNode node) {
        Stack<TreeNode> stackA = new Stack<TreeNode>();
        Stack<TreeNode> stackB = new Stack<TreeNode>();
        //第一个值放在第一个，保证最后面出去
        stackA.push(node);
        while (!stackA.isEmpty()) {
            TreeNode pop = stackA.pop();
            stackB.push(pop);
            if (pop.leftNode != null) {
                stackA.push(pop.leftNode);
            }
            if (pop.rightNode != null) {
                stackA.push(pop.rightNode);
            }
        }
        while (!stackB.isEmpty()) {
            TreeNode pop = stackB.pop();
            System.err.print(pop.data);
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
        StackBinaryTree.TreeNode node = StackBinaryTree.createNode(list);
        System.err.println("前序排列结果：");
        preOrderTranslateWithStack(node);
        System.err.println("");

        System.err.println("中序排列结果：");
        midOrderTranslateWithStack(node);
        System.err.println("");

        System.err.println("后序排列结果：");
        postOrderTranslateWithStack(node);
        System.err.println("");

    }

}
