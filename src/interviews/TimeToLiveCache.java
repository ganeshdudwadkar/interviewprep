package interviews;

/*

Design TTL Cache
Optimize it to remove expired entries

 */

import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static java.lang.Thread.*;

public class TimeToLiveCache {

    private Map<String, Long> expiry; // stores the key and its expiry
    private Map<String, String> cache; // stores the key and its value
    private Map<Long, List<String>> times; // stores expiry and associated all the keys in a list - Required for
    // faster removal of expired times

    public TimeToLiveCache(){
        expiry = new ConcurrentHashMap<>();
        cache = new ConcurrentHashMap<>();
        times = new TreeMap<>();
        new Cleaner().start();
    }
    // returns epoch time in seconds
    public long getNow(){
        return Instant.now().getEpochSecond();
    }

    public void put(String key, String value, long ttl){
        Long end = getNow() + ttl;
        expiry.put(key, end);
        cache.put(key, value);
        List<String> sameExpiryKeys = times.getOrDefault(end, new ArrayList<>());
        sameExpiryKeys.add(key);
        times.put(end, sameExpiryKeys);
    }

    public String get(String key){
        if (!expiry.containsKey(key)) return null;
        long life = expiry.get(key);
        if (life < getNow()){
            System.out.println("Removing key upon get call :- " + key); // ideally this should never get called
            expiry.remove(key);
            cache.remove(key);
            // times.remove(life); -> leave this to cleanup as other keys needs to be removed as well
            return null;
        } else {
            return cache.get(key);
        }
    }

    class Cleaner extends Thread {
        @Override
        public void run() {
            while (true){
                // clean-up the times map
                cleanup();
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void cleanup(){
            // System.out.println("Inside cleanup..");
            long currentTime = getNow();
            List<String> keys;
            List<Long> timesToRemove = new ArrayList<>();
            for(Long time: times.keySet() ){
                if (time < currentTime){
                    keys = times.get(time);
                    for(String key: keys){
                        System.out.println("Cleaning up key :- " + key);
                        expiry.remove(key);
                        cache.remove(key);
                    }
                    times.put(time, null);
                    timesToRemove.add(time);
                } else {
                    break;
                }
            }
            // this is required since treemap doesn't allow to do concurrent modification
            for(Long time: timesToRemove){
                times.remove(time);
            }
        }
    }

    public static void main(String[] args) {
        TimeToLiveCache ttlCache = new TimeToLiveCache();
        ttlCache.put("name", "ganesh", 3);
        ttlCache.put("addr", "locust", 15);
        System.out.println(ttlCache.get("name"));
        try {
            sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(ttlCache.get("name"));
        System.out.println(ttlCache.get("addr"));
        // System.out.println(ttlCache.cache);
    }

}
