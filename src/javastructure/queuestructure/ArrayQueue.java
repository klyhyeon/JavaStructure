package javastructure.queuestructure;


import java.util.Queue;

public class ArrayQueue<E> {

    public static final int CAPACITY = 1000;
    private int sz = 0;
    private int f = 0;
    private E[] data;

    public ArrayQueue() {this(CAPACITY);}

    public ArrayQueue(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public int size() {return sz;}

    public boolean isEmpty() {return (sz == 0);}

    public void enqueue(E e) {
        if (sz == data.length) throw new IllegalStateException("Queue is full");
        int avail = (f + sz) %  data.length; //first element + total elements
        data[avail] = e;
        sz++;
    }

    public E first() {
        if (isEmpty()) return null;
        return data[f];
    }

    public E dequeue() {
        if (isEmpty()) return null;
        int endAddOne = (f + sz) % data.length;
        E remove = data[f];
        data[f] = null;
        f = (f + 1) % data.length;
        sz--;
        return remove;
    }

    //temporary for Josephus class
    public void rotate() {

    }

}
