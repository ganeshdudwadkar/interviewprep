package interviews;

/*
Create a dict that supports following functions and it allows last method which returns last key accessed during get and set operations ->
dict.set("a",1); -> last "a"
dict.get("a") -> last "a"
dict.set("b",2) -> last "b"
dict.get("a") -> last "a"
dict.get("b") -> last "b"
dict.remove("b") -> last "a"
 */

// better O(1) solution is possible with LRU like structure to maintain the last accessed key
// Below solution has O(logn) complexity for all the operations except last()

import java.util.*;

public class CustomizedDictionary {
    private int sequence;
    // below map contains actual dictionary entries
    private Map<String, Integer> map;
    // below map contains sequence as key and dictionary key as value
    private TreeMap<Integer, String> lastMap;
    // below map contains dictionary key as key again and sequence as value
    // it will maintain the latest sequence of the key and will help remove older entries from the lastMap
    // using the existing sequence that it has
    private Map<String, Integer> cleaner;

    public CustomizedDictionary(){
        sequence = 0; // instead I used System.currentTimeMillis() in the interview
        map = new HashMap<>();
        lastMap = new TreeMap<>();
        cleaner = new HashMap<>();
    }

    public void set(String key, int value){
        map.put(key, value);
        updateLast(key);
    }

    public int get(String key){
        if (map.containsKey(key)){
            updateLast(key);
            return map.get(key);
        }
        return Integer.MIN_VALUE;
    }

    public void remove(String key){
        map.remove(key);
        int old = cleaner.get(key);
        cleaner.remove(key);
        lastMap.remove(old);
    }

    public String last(){
        if (!lastMap.isEmpty()){
            int last = lastMap.lastKey();
            return lastMap.get(last);
            // return lastMap.lastEntry().getValue();
        }
        return null;
    }

    private void updateLast(String key){
        lastMap.put(++sequence, key);
        if (cleaner.containsKey(key)){
            int old = cleaner.get(key);
            lastMap.remove(old);
        }
        cleaner.put(key, sequence);
    }

    public static void main(String[] args) {
        CustomizedDictionary dict = new CustomizedDictionary();
        System.out.println(dict.last());
        dict.set("a", 1);
        System.out.println(dict.last());
        dict.set("b", 2);
        System.out.println(dict.last());
        dict.get("a");
        System.out.println(dict.last());
        dict.remove("b");
        System.out.println(dict.last());
    }
}
