package javastructure.MapStructure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;

public class UnsortedTableMap<K,V> extends AbstractMap<K,V> {
    private ArrayList<MapEntry<K,V>> table = new ArrayList<>();

    public UnsortedTableMap() {}

    private int findIndex(K key) {
        int n = table.size();
        for (int j = 0; j < n; j++)
            if (table.get(j).getKey().equals(key))
                return j;
            return -1;
    }

    @Override
    public int size() { return table.size(); }

    @Override
    public V get(K key) {
        int j = findIndex(key);
        if (j == -1) return null;
        return table.get(j).getValue();
    }

    @Override
    public V put(K key, V value) {
        int j = findIndex(key);
        if (j == -1) {
            table.add(new MapEntry<>(key, value));
            return null;
        } else
            return table.get(j).setValue(value);
    }

    @Override
    public V remove(K key) {
        int j = findIndex(key);
        if (j == -1) return null;
        V old = table.get(j).getValue();
        int n = size();
        if (j != n - 1) {
            table.set(j, table.get(n-1));
        }
        table.remove(n-1);
        return old;
    }

    private class EntryIterator implements Iterator<Map.Entry<K,V>> {
        private int j = 0;
        public boolean hasNext() {return j < table.size();}
        public Map.Entry<K,V> next() {
            if (j == table.size()) throw new NoSuchElementException();
            return table.get(j++);
        }
        public void remove() {throw new UnsupportedOperationException();}
    }

    private class EntryIterable implements Iterable<Entry<K,V>> {
        public Iterator<Entry<K,V>> iterator() {return new EntryIterator();}
    }

    public Iterable<Entry<K,V>> entrySet() {return new EntryIterable();}
}
