package algorithmBase.arr;

public class GrayArr {
    private int[] array;
    private int size;

    public GrayArr(int length) {
        this.array = new int[length];
        this.size = 0;
    }

    public void insert(int element, int index) {
        if (index < 0 || index > size) {
            System.err.println("插入数据位置错误");
        }
        //扩容
        if (size >=array.length) {
            resize();
        }
        //从右往前塞入数据
        //为什么小灰写的是 array[i + 1]=array[index]

        for (int i = size - 1; i >= index; i--) {
//            array[i + 1] = array[i];
            System.err.println("阿辉"+array[i]);
            array[i + 1] = array[index];
        }
        array[index] = element;
        size++;
    }

    /**
     * 删除元素
     * @param index
     */
    public void delete(int index) {
        if (index < 0 || index > size) {
            System.err.println("删除位置不存在元素");
        }
        for (int i = index; i < array.length-1; i++) {
            //为什么小灰写的是array[index+1]
            array[i] = array[i+1];
        }
        size--;
    }

    public void resize() {
        int[] arr = new int[array.length * 2];
        System.arraycopy(array, 0, arr, 0, arr.length);
        array = arr;
    }

    public void out() {
        for (int i : array) {
            System.err.println(i);
        }
    }


    public static void main(String[] args) {
        GrayArr arr = new GrayArr(4);
        arr.insert(3, 0);
        arr.insert(7, 1);
        arr.insert(8, 1);
        arr.insert(9, 2);
        arr.out();
//        arr.delete(1);
//        arr.out();
    }
}