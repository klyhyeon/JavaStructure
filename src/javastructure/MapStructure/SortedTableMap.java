package javastructure.MapStructure;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map.Entry;

import static java.util.Objects.compare;

public class SortedTableMap<K,V> extends AbstractMap<K,V> {
    //Skipped extending AbstractSortedMap(Available online)
    private ArrayList<MapEntry<K,V>> table = new ArrayList<>();
    public SortedTableMap() {super();}
    public SortedTableMap(Comparator<K> comp) {super();}

    private int findIndex(K key) {return findIndex(key, 0, table.size()-1);}

    public int findIndex(K key, int low, int high) {
        if (high < low) return high + 1;
        int mid = (high + low) / 2;
        int comp = compare(key, table.get(mid));
        if (comp == 0) return mid;
        else if (comp < 0) return findIndex(key, low, mid - 1);
        else return findIndex(key, mid + 1, high);
    }

    private int compare(K key, MapEntry<K,V> kvMapEntry) {
        return 0;
    }

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

    private Entry<K,V> safeEntry(int j) {
        if (j < 0 || j >= table.size()) return null;
        return table.get(j);
    }

    public Entry<K,V> firstEntry() {return safeEntry(0);}

    public Entry<K,V> lastEntry() {return safeEntry(table.size() -1);}

    public Entry<K,V> ceilingEntry(K key) {
        return safeEntry(findIndex(key));
    }

    //less than or equal to given key
    public Entry<K,V> floorEntry(K key) {
        int j = findIndex(key);
        if (j == size() || !key.equals(table.get(j).getKey()))
            j--;
        return safeEntry(j);
    }

    //greatest strictly less than given key
    public Entry<K,V> lowerEntry(K key) {
        return safeEntry(findIndex(key) - 1);
    }

    //strictly greater than given key
    public Entry<K,V> higherEntry(K key) {
        int j = findIndex(key);
        if (j < size() && key.equals(table.get(j).getKey()))
            j++;
        return safeEntry(j);
    }

    private Iterable <Entry<K,V>> snapshot(int startIndex, K stop) {
        ArrayList<Entry<K,V>> buffer = new ArrayList<>();
        int j = startIndex;
        while (j < table.size() && (stop == null || compare(stop, table.get(j)) > 0))
            buffer.add(table.get(j++));
        return buffer;
    }

    public Iterable <Entry<K,V>> entrySet() {return snapshot(0, null);}
    public Iterable <Entry<K,V>> subMap(K fromKey, K toKey) {
        return snapshot(findIndex(fromKey), toKey);
    }



}
