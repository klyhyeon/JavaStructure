package javastructure.stackstructure;

import javastructure.arraystructure.CircularlyLinkedList;

import java.util.Stack;

public class LinkedStack<E> extends Stack<E> {

    private CircularlyLinkedList<E> list = new CircularlyLinkedList<>();

    public int size() {
        return list.size();
    }

    public E top() {
        return list.first();
    }

    public void push2(E e) {
        list.addFirst(e);
    }
}
