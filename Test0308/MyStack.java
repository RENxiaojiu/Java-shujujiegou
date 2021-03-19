package Test0308;

// 用顺序表实现的栈
public class MyStack {
    private int[] data = null;
    private int size = 0;
    private int capacity = 100;

    public MyStack() {
        data = new int[capacity];
    }

    public static void main(String[] args) {
        MyStack s = new MyStack();
        s.push(1);
        System.out.println(s.peek());
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

    // 1. 入栈
    public void push(int val) {
        if (size > capacity) {
            realloc();
        }
        data[size] = val;
        size++;
    }

    // 2. 出栈
    public Integer pop() {
        if (size == 0) {
            return null;
        }
        int ret = data[size - 1];
        size--;
        return ret;
    }

    // 3. 去栈顶元素
    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return data[size - 1];
    }
}
