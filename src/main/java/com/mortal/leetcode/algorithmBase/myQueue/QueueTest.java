package algorithmBase.myQueue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue<Integer> myQueue = new LinkedList<Integer>();
        for (int i = 1; i < 11; i++) {
            myQueue.offer(i);
        }
        //存在add和remove方法但是当塞入不成功时会报错
        //offer塞入时返回false.poll时返回null
        //element 数据为空时报错，peek返回null
        System.err.println("输出第一个元素"+myQueue.element());
        System.err.println("输出第一个元素"+myQueue.peek());
        System.err.println("输出并删除第一个元素"+myQueue.poll());
        System.err.println("输出第一个元素"+myQueue.peek());
    }
}
