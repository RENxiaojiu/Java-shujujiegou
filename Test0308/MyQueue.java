package Test0308;

// 使用顺序边实现队列
public class MyQueue {
    private int[] data = null;
    private int head = 0;
    private int tail = 0;
    private int size = 0;
    private int capacity = 100;

    public MyQueue() {
        data = new int[capacity];
    }

    // 扩容操作
    public void realloc() {
        capacity = 2 * capacity;
        int[] newData = new int[capacity];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    // 1. 入队列
    public boolean offer(int val) {
        if (size == data.length) {
            // 可以进行扩容扩容操作或者直接 return false
//            realloc();
            return false;
        }
        data[size] = val;
        tail++;
        if (tail == data.length) {
            tail = 0;
        }
        size++;
        return true;
    }

    // 2. 出队列
    public Integer poll() {
        if (size == 0) {
            return null;
        }
        int ret = data[head];
        head++;
        if (head == data.length) {
            head = 0;
        }
        size--;
        return ret;
    }
    // 3. 取队首元素
    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return data[head];
    }
}
