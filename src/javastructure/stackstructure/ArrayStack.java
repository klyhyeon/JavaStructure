package javastructure.stackstructure;

import java.util.Stack;

public class ArrayStack<E> extends Stack<E> {
    public static final int CAPACITY = 1000;
    private E[] data;
    private int t = -1;
    public int t2 = 0;

    public ArrayStack() {
        this(CAPACITY);
    }

    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return (t == -1);
    }

    public int size() {
        return (t + 1);
    }
}
