package algorithmBase.stackTest;

import java.util.Stack;

/**
 * vector下的stack的基础是的使用
 */
public class MyStack {
    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<Integer>();
        for (int i = 1; i < 11; i++) {
            myStack.push(i);
        }
        System.err.println("查看是否为空数据:"+myStack.empty());
        System.err.println("不删除查看倒数第一个数据："+myStack.peek());
        System.err.println("删除之后产看第一个数据："+myStack.pop());
        System.err.println("删除后查看倒数第一个数据："+myStack.peek());
        System.err.println("查询元素所在位置："+myStack.search(1));
    }
}
