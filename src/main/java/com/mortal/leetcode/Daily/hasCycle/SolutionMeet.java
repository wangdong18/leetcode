package hasCycle;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，
 * 则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos
 * 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 * @auther mortal
 * @date 2023/10/3 22:57
 */
public class SolutionMeet {

    public static void main(String[] args) {

    }

    /**
     * 自己和自己的下一个指针跑
     * 只要存在循环，必然会相遇的
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode indexHead = head;
        ListNode runHead = head;
        while (runHead != null && runHead.next != null) {
            indexHead = indexHead.next;
            runHead = runHead.next.next;
            if (indexHead == runHead) {
                return true;
            }
        }
        return false;
    }
}
