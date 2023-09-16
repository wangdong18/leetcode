package algorithmBase.node;

/**
 * 关于node节点的相关操作
 */
public class NodeOperate {

    private Node head;
    private Node end;
    int size;


    /**
     * 指定位置插入元素
     * @param data
     * @param index
     */
    public void insert(int data, int index) {
        if (index < 0 || index > size+1) {
            System.err.println("插入元素错误，不存在数据");
        }
        Node add = new Node(data);
        if (size == 0) {
            head = add;
            end = add;
        } else if (size == index) {
            end.setNext(add);
            end = add;
        }else {
            Node addNode = getIndex(index);
            add.setNext(addNode.getNext());
            addNode.setNext(add);
        }
        size++;
    }
    /**
     * 删除指定位置的元素
     * @param index
     * @return
     */
    public Node remove(int index) {
        if (index < 0 || index > size) {
            System.err.println("删除错误，索引不存在");
        }
        Node nodeIndex = null;
        if (index == 0) {
            nodeIndex = head;
            head = head.getNext();
        }else if (index== size) {
            Node nodeR = getIndex(index-1);
            nodeIndex = nodeR.getNext();
            nodeR.setNext(null);
            end = nodeR;
        }else {
            Node nodeR = getIndex(index-1);
            Node nodeL =nodeR.getNext().getNext();
            nodeIndex = nodeR.getNext();
            nodeR.setNext(nodeL);
        }

        size--;
        return nodeIndex;
    }
    /**
     * 查询指定位置的节点
     * @param index
     * @return
     */
    public Node getIndex(int index) {
        if (index < 0 || index >=size) {
            System.err.println("查询错误，索引不存在");
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return temp;
    }

    /**
     * 输出链表信息
     */
    public void output() {
        Node temp = head;
        //只有当最后一节点时才会是空的
        while (null != temp) {
            System.err.println(temp.getData());
            temp = temp.getNext();
        }

    }

    public static void main(String[] args) {
        NodeOperate nodeOperate = new NodeOperate();
        //插入元素
        nodeOperate.insert(3, 0);
        nodeOperate.insert(4, 1);
        nodeOperate.insert(11, 2);
        nodeOperate.insert(9, 3);
        //输出元素
        nodeOperate.output();
        //删除第二个元素
        System.err.println("删除前的第二元素是"+nodeOperate.getIndex(2).getData());
        System.err.println(nodeOperate.remove(2).getData());
        System.err.println("删除后的第二元素是"+nodeOperate.getIndex(2).getData());

    }

}
