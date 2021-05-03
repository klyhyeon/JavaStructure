package javastructure.MapStructure;

import java.util.*;
import java.util.Map;
import java.util.Map.Entry;

public class WordCount {

    public static void main(String args[]) {
        Map<String, Integer> freq = new LinkedHashMap<>();
        Scanner doc = new Scanner(System.in).useDelimiter("[^a-zA-Z]+");
        while(doc.hasNext()) {
            String word = doc.next().toLowerCase();
            if (word.equals("end"))
                break;
            if (freq.containsKey(word)) {
                int count = freq.get(word);
                freq.put(word, ++count);
            } else
                freq.put(word, 1);
        }
        int maxCount = 0;
        String maxWord = "";
        for (Entry<String, Integer> ent : freq.entrySet()) {
            if (ent.getValue() > maxCount) {
                maxCount = ent.getValue();
                maxWord = ent.getKey();
            }
        }
        System.out.println("The most word : " + maxWord);
        System.out.println("The maxCount is " + maxCount);
    }
}
