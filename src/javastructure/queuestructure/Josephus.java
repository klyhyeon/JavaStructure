package javastructure.queuestructure;

import javastructure.arraystructure.CircularlyLinkedList;

public class Josephus {

    public static <E> E Josephus(ArrayQueue<E> queue, int k) {

        while (k-- > 0 && !queue.isEmpty()) {
            queue.rotate();
            queue.dequeue();
        }
        return queue.dequeue();
    }

    public static <E> ArrayQueue<E> buildQueue(E[] e) {
        ArrayQueue<E> queue = new ArrayQueue<>();
        for (E value : e)
            queue.enqueue(value);
        return queue;
    }



}
