package javastructure.MapStructure;


import java.util.Map;

public class CostPerformanceDatabase {

    SortedTableMap<Integer, Integer> map = new SortedTableMap<>();

    public CostPerformanceDatabase() {}

    public Map.Entry<Integer, Integer> best(int cost) {
        return map.floorEntry(cost);
    }

    public void add(int c, int p) {
        Map.Entry<Integer, Integer> comp = best(c);
        if (comp != null && comp.getValue() >= p)
            return;
        map.put(c, p);
        //remove entries dominated by new one
        comp = map.higherEntry(c);
        while (comp != null && comp.getValue() <= p) {
            map.remove(comp.getKey());
            comp = map.higherEntry(c);
        }
    }

}
