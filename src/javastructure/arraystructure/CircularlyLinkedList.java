package javastructure.arraystructure;

import org.junit.platform.engine.support.hierarchical.Node;

public class CircularlyLinkedList<E> {

    protected static class Node<E> {
        private E element;
        private Node<E> next;
        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
        public Node<E> getNext() { return next;}
        public void setNext(Node<E> next) {
            this.next = next;
        }
        public E getElement() { return element;}

    } //---end of nested Node class---

    private Node<E> tail = null;
    private int size = 0;
    public CircularlyLinkedList() {}

    //access methods
    public int size() {return size;}

    public boolean isEmpty() {return size == 0;}

    public E first() {
        if (isEmpty()) return null;
        return tail.getNext().getElement();
    }

    public E last() {
        if (isEmpty()) return null;
        return tail.getElement();
    }

    //update methods
    public void rotate() {
        if (tail != null)
            tail = tail.getNext();
    }

    public void addFirst(E e) {
        if (size == 0) {
            tail = new Node<>(e, null);
            tail.setNext(tail); //link to itself circularly
        } else {
            Node<E> firstNode = new Node<>(e, tail.getNext());
            tail.setNext(firstNode);
        }
        size++;
    }

    public void addLast(E e) {
        addFirst(e);
        tail = tail.getNext();
    }

    //경우의 수들을 고민하자
    public E removeFirst() {
        //노드가 비었을 때
        if (isEmpty()) return null;
        Node<E> head = tail.getNext();
        //노드가 하나일 때
        if (head == tail) tail = null;
        //
        else tail.setNext(head.getNext());
        size--;
        return head.getElement();
    }
}

