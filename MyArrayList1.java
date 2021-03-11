package Test0201;

public class MyArrayList1 {
    private int size = 0;
    private int capacity = 100;
    private String[] data = null;

    private MyArrayList1() {
        data = new String[capacity];
    }

    //扩容操作
    private void realloc() {
        String[] newData = new String[2 * capacity];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    //增
    //尾插
    private void add(String elem) {
        if (size > capacity) {
            realloc();
        }
        data[size] = elem;
        size++;
    }

    //按位置插入
    private void add(String elem, int index) {
        if (size > capacity) {
            realloc();
        }
        for (int i = index; i < size; i++) {
            data[i+1] = data[i];
        }
        size++;
    }

    //删
    //按元素位置删除
    private String remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return data[index];
    }

    //按元素值删除
    private boolean remove(String elem) {
        int i = 0;
        for (; i < size; i++) {
            if (data[i].equals(elem)) {
                break;
            }
        }
        if (i >= size) {
            return false;
        }
        for (int j = i; j < size; j++) {
            data[i] = data[i + 1];
        }
        size--;
        return true;
    }

    //根据下标获取元素
    private String get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return data[index];
    }

    //根据下标修改元素
    private void set(int index, String elem) {
        if (index < 0 || index >= size) {
            return;
        }
        data[index] = elem;
    }

    //判断元素是否存在
    private boolean contain(String elem) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(elem)) {
                return true;
            }
        }
        return false;
    }

    //查找元素位置(从后往前)
    private int indexOf(String elem) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(elem)) {
                return i;
            }
        }
        return -1;
    }
    //查找元素位置(从后往前)
    private int lastIndexOf(String elem) {
        for (int i = size - 1; i >= 0; i++) {
            if (data[i].equals(elem)) {
                return i;
            }
        }
        return -1;
    }
    //清空线性表
    private void clean() {
        size = 0;
    }
    //判断线性表是否为空
    private boolean isEmpty() {
        return size == 0;
    }

    private int size() {
        return size;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(data[i]);
            if (i < size - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private static void testRemove() {
        MyArrayList1 myArrayList1 = new MyArrayList1();
        myArrayList1.add("C");
        myArrayList1.add("C++");
        myArrayList1.add("Java");
        myArrayList1.add("python");

        myArrayList1.remove(0);
        myArrayList1.remove("JavaScript");

        System.out.println(myArrayList1);
    }

    private static void testSet() {
        MyArrayList1 myArrayList1 = new MyArrayList1();
        myArrayList1.add("C");
        myArrayList1.add("C++");
        myArrayList1.add("Java");
        myArrayList1.add("python");

        myArrayList1.set(10, "JavaScript");
        System.out.println(myArrayList1);
        System.out.println(myArrayList1.size);
    }

    public static void main(String[] args) {
//        testRemove();
        testSet();
    }
}
