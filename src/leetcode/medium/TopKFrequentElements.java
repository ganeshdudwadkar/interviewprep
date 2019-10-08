package leetcode.medium;

// https://leetcode.com/problems/top-k-frequent-elements/

/*

Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]

 */

import java.util.*;

class ValueComparator implements Comparator<Integer> {
    private Map<Integer, Integer> map;

    public ValueComparator(Map<Integer, Integer> map) {
        this.map = map;
    }

    public int compare(Integer a, Integer b) {
        return 0 - Integer.compare(map.get(a), map.get(b)); // reverse
    }
}

public class TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hm = new TreeMap<>();
        int val;
        for (int num : nums) {
            val = 0;
            if (hm.containsKey(num)) {
                val = hm.get(num);
            }
            hm.put(num, ++val);
        }

        TreeMap<Integer, Integer> tm = new TreeMap<>(new ValueComparator(hm));
        tm.putAll(hm);
        int counter = 0;
        List<Integer> ls = new ArrayList<>();
        for (Integer key : tm.keySet()) {
            ls.add(key);
            counter++;
            if (counter == k) break;
        }
        return ls;
    }

    // my solution =>

    public List<Integer> topKFrequentMySolution(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        Map<Integer, List<Integer>> tm = new TreeMap<>(Collections.reverseOrder());

        // Process all numbers and count their frequencies
        for (int n : nums) {
            if (hm.containsKey(n)) {
                hm.put(n, hm.get(n) + 1);
            } else {
                hm.put(n, 1);
            }
        }

        // Now make frequencies as key's of reverse ordered treemap and make list of numbers with same freq
        List<Integer> ls;
        for (int num : hm.keySet()) {
            int freq = hm.get(num);
            if (tm.containsKey(freq)) {
                ls = tm.get(freq);
            } else {
                ls = new ArrayList<>();
            }
            ls.add(num);
            tm.put(freq, ls);
        }

        // Iterate through treemap and add top k frequent elements into result lists
        List<Integer> res = new ArrayList<>(k);
        outer:
        for (int freq : tm.keySet()) {
            ls = tm.get(freq);
            for (int n : ls) {
                res.add(n);
                if (res.size() == k) {
                    break outer;
                }
            }
        }
        return res;
    }

    // Better bucket sort logic :

    public List<Integer> topKFrequentBucketSort(int[] nums, int k) {

        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        return res;
    }

    public static void main(String[] args) {

        TopKFrequentElements obj = new TopKFrequentElements();
        System.out.println(obj.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
        System.out.println(obj.topKFrequentMySolution(new int[]{1, 1, 1, 2, 2, 3}, 2));
    }
}
