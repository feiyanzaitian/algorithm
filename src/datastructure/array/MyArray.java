package datastructure.array;

/**
 * @author saxu
 * @description 数组
 * @date 2023/12/3 00:00:48
 */
public class MyArray {

    private int[] array;
    private int size;

    public MyArray(int capacity) {
        this.array = new int[capacity];
        this.size = 0;
    }

    /**
     * 向数组中插入元素
     *
     * @param element 插入的元素
     * @param index   插入的位置
     */
    public void insert(int element, int index) throws Exception {

        if (index < 0 || index > size) {
            throw new Exception("数组发生了越界！");
        }

        //从右往左循环数组，挪动位置
        for (int i = size - 1; i > index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = element;
        size = size + 1;
    }

    public void output() {
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
    }

    /**
     * 向数组中插入元素,带有扩容
     *
     * @param element 插入的元素
     * @param index   插入的位置
     */
    public void insertWithResize(int element, int index) throws Exception {

        if (index < 0 || index > size) {
            throw new Exception("数组发生了越界！");
        }

        if (size >= array.length) {
            resize();
        }

        //从右往左循环数组，挪动位置
        for (int i = size - 1; i > index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = element;
        size = size + 1;
    }

    private void resize() {
        int[] arrayNew = new int[array.length * 2];
        System.arraycopy(array, 0, arrayNew, 0, array.length);
        array = arrayNew;
    }

    public int deleteElement(int index) throws Exception {
        if (index < 0 || index > size) {
            throw new Exception("数组发生了越界！");
        }
        int deleteElement = array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return deleteElement;
    }

    public static void main(String[] args) throws Exception {
        MyArray myArray = new MyArray(10);
        myArray.insert(1, 0);
        myArray.insert(2, 1);
        myArray.insert(3, 2);
        myArray.insert(4, 3);
        myArray.insert(5, 4);
//        myArray.insert(6, 3);

        myArray.deleteElement(1);

        myArray.output();

    }
}
