package javastructure.TreeStructure;

import java.util.*;

public abstract class AbstractTree<E> implements Tree<E> {
    public boolean isInternal(Position <E> p) {return numChildren(p) > 0;}
    public boolean isExternal(Position <E> p) {return numChildren(p) == 0;}
    public boolean isRoot(Position<E> p) {return p == root();}
    public boolean isEmpty() {return size() == 0;}
    public int depth(Position<E> p) {
        if (isRoot(p))
            return 0;
        return 1 + depth(parent(p));
    }
    public int height(Position<E> p) {
        int h = 0; //base case if p is external
        for (Position<E> c : children(p))
            h = Math.max(h, 1 + height(c));
        return h;
    }

    /* This class adapts the iteration produced by positions to return elements */
    private class ElementIterator implements Iterator<E> {
        Iterator<Position<E>> posIterator = positions().iterator();
        public boolean hasNext() {return posIterator.hasNext();}
        public E next() {return posIterator.next().getElement();}
        public void remove() {posIterator.remove();}
    }

    /** Returns an iterator of the elements stored in the tree. */
    public Iterator<E> iterator() {return new ElementIterator();}

    public Iterable<Position<E>> positions() {return preorder();}

    /** Adds positions of the subtree rooted at position p to the given snapshot */
    private void preorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        snapshot.add(p);
        for (Position<E> c : children(p))
            preorderSubtree(c, snapshot);
    }

    /** Returns an iterable collection of positions of the tree, reported in preorder*/
    public Iterable<Position<E>> preorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty())
            preorderSubtree(root(), snapshot);
        return snapshot;
    }

    /** Return positions of subtree from position p to the given snapshot*/
    public void postorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        for (Position<E> c : children(p))
            postorderSubtree(c, snapshot);
        snapshot.add(p);
    }

    /** Return iterable collection of positions of the tree, reported in postorder*/
    public Iterable<Position<E>> postorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty())
            postorderSubtree(root(), snapshot);
        return snapshot;
    }

    /** Breadth-first order*/
    public Iterable<Position<E>> breadthfirst() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            Queue<Position<E>> fringe = new PriorityQueue<>();
            fringe.add(root());
            while(!fringe.isEmpty()) {
                Position<E> p = fringe.remove();
                snapshot.add(p);
                for (Position<E> c : children(p))
                    fringe.add(c);
            }
        }
        return snapshot;
    }


    /** Insert indent while preorder()*/
    public void printPreorderIndent(Tree<E> t, Position<E> p, int d) {
        //System.out.println(spaces(2*d) + p.getElement());
        for (Position<E> c : children(p))
            printPreorderIndent(t, c, d+1);
    }

    /** Add numbering to printPreorderIndent()*/
    public void printPreorderLabeled(Tree<E> T, Position<E> p, ArrayList<Integer> path) {
        int d = path.size();
        //System.out.println(spaces(2*d));
        for (int j = 0; j < d; j++)
            System.out.print(path.get(j) + (j == d - 1 ? " " : "."));
        System.out.println(p.getElement());
        path.add(1);
        for (Position<E> c : T.children(p)) {
            printPreorderLabeled(T, c, path);
            path.set(d, 1 + path.get(d));
        }
        path.remove(d);
    }

    /** Computing disk space*/
    public static int diskSpace(Tree<Integer> T, Position<Integer> p) {
        int subtotal = p.getElement();
        for (Position<Integer> c : T.children(p))
            subtotal += diskSpace(T, c);
        return subtotal;
    }

    /** Parenthetic Representations of a Tree*/
    public void parentheticTree(Tree<E> T, Position<E> p) {
        System.out.print(p.getElement());
//        for (Position<E> c : T.children(p)) {
//            parentheticTree(T, c);
//            System.out.print(")");
//        }
        for (int i = 0; i < numChildren(p); i++) {
            ArrayList<Position<E>> c = (ArrayList<Position<E>>) children(p);
            if (i == 0)
                System.out.print("(");
            else
                System.out.println(", ");
            parentheticTree(T, c.get(i));
            System.out.print(")");
        }
    //ParentheticTree Answer code
        if (T.isInternal(p)) {
            boolean firstTime = true;
            for (Position<E> c : children(p)) {
                System.out.print((firstTime ? " (" : ", "));
                firstTime = false;
                parentheticTree(T, c);
            }
            System.out.print(")");
        }
    }
}
