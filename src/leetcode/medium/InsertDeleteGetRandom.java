package leetcode.medium;

// https://leetcode.com/problems/insert-delete-getrandom-o1/

/*

Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.

 */


import java.util.*;

public class InsertDeleteGetRandom {
    Map<Integer, Integer> map;
    List<Integer> ls;
    Random rand;

    /**
     * Initialize your data structure here.
     */
    public InsertDeleteGetRandom() {
        map = new HashMap<Integer, Integer>();
        ls = new ArrayList<Integer>();
        rand = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        ls.add(val);
        map.put(val, ls.size() - 1);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int index = map.get(val);
            int lastElem = ls.get(ls.size() - 1);
            ls.set(index, lastElem);
            map.put(lastElem, index);//update last Elem's value to old list size
            ls.remove(ls.size() - 1);
            map.remove(val);
            return true;
        }
        return false;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int i = rand.nextInt(ls.size());
        return ls.get(i);
    }

    public static void main(String[] args) {
        InsertDeleteGetRandom obj = new InsertDeleteGetRandom();
        obj.insert(1);
        obj.insert(2);
        obj.remove(3);
        System.out.println(obj.getRandom());
        obj.remove(2);
        System.out.println(obj.getRandom());
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
