package javastructure.MapStructure;

import java.util.ArrayList;
import java.util.Comparator;

public class SortedTableMap<K,V> extends AbstractMap<K,V> {
    //Skipped extending AbstractSortedMap(Available online)
    private ArrayList<MapEntry<K,V>> table = new ArrayList<>();
    public SortedTableMap() {super();}
    public SortedTableMap(Comparator<K> comp) {super(comp);}

    private int findIndex(K key, int low, int high) {
        if (high < low) return high + 1;
        int mid = (low + high) / 2;
        int comp = compare(key, table.get(mid));
        if (comp == 0)
            return mid;
        else if (comp < 0)
            return findIndex(key, low, mid-1);
        else
            return findIndex(key, mid + 1, high);
    }

    private int findIndex(K key) {return findIndex(key, 0, table.size()-1);}

    public int size() {return table.size();}

    public V get(K key) {
        int j = findIndex(key);
        if (j == size() || compare(key, table.get(j)) != 0) return null;
        return table.get(j).getValue();
    }

    public V put(K key, V value) {
        int j = findIndex(key);
        if (j < size() && compare(key, table.get(j)) == 0)
            return table.get(j).setValue(value);
        table.add(j, new MapEntry<K,V>(key, value));
        return null;
    }

    public V remove(K key) {
        int j = findIndex(key);
        if (j == size() || compare(key, table.get(j)) != 0) return null;
        return table.remove(j).getValue();
    }

}
