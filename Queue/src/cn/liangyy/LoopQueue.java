package cn.liangyy;

/**
 * @Author: 梁歪歪 <1732178815@qq.com>
 * @Description: blog <liangyy.cn>
 * @Create 2021-04-25-14:47
 */
public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueue(int capacity) {
        // 由于不浪费空间，所以data静态数组的大小是capacity，而不是capacity + 1
        //data = (E[]) new Object[capacity + 1];
        data = (E[]) new Object[capacity];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        //return data.length - 1;
        return data.length;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        // 注意，不再使用front和tail之间的关系来判断队列是否为空，而直接使用size
        //return front == tail;
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        // 不再使用front和tail之间的关系来判断队列是否为满，而直接使用size

        //if ((tail + 1) % data.length == front) {
        //    resize(getCapacity() * 2);
        //}
        if (size == getCapacity()) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("cn.liangyy.Queue is empty.");
        }
        return data[front];
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("cn.liangyy.Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        // 循环遍历打印队列的逻辑也有相应的更改
        //for (int i = front; i != tail; i = (i + 1) % data.length) {
        //    res.append(data[i]);
        //    if ((i + 1) % data.length != tail) {
        //        res.append(", ");
        //    }
        //}
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            res.append(data[(front + i) % data.length]);
            if((i + front + 1) % data.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }
}
