package interviews;

import java.util.*;

public class FindFriends {

    public Map<Integer, List<String>> getAllFriends(String name, Map<String, List<String>> friendMap){
        Map<Integer, List<String>> levelMap = new HashMap<>();
        if (name == null || friendMap == null) return levelMap;
        Queue<String> queue = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();
        Set<String> done = new HashSet<>();
        queue.add(name);
        levels.add(1);
        done.add(name);
        String current;
        int level;
        while(!queue.isEmpty()){
            current = queue.remove();
            level = levels.remove();
            List<String> currentFriends = friendMap.getOrDefault(current, new ArrayList<>());
            for (String friend: currentFriends){
                // System.out.println("Processing friend " + friend + " at level " + level);
                List<String> levelList;
                if (!levelMap.containsKey(level)){
                    levelList = new ArrayList<>();
                    levelMap.put(level, levelList);
                } else {
                    levelList = levelMap.get(level);
                }
                if(!done.contains(friend)){
                    levelList.add(friend);
                    done.add(friend);
                    queue.add(friend);
                    levels.add(level+1);
                }
            }
            System.out.println(levelMap);
        }

        return levelMap;
    }

    public static void main(String[] args){

        Map<String, List<String>> friendMap = new HashMap<>();
        friendMap.put("Bob", new ArrayList<>(Arrays.asList("Sandra", "Alice", "Eric")));
        friendMap.put("Sandra", new ArrayList<>(Arrays.asList("Alice", "Bob")));
        friendMap.put("Alice", new ArrayList<>(Arrays.asList("Tim", "Ram")));
        friendMap.put("Eric", new ArrayList<>(Arrays.asList("Sandra", "Tim")));
        friendMap.put("Tim", new ArrayList<>(Arrays.asList("Sandra", "Ram")));
        friendMap.put("Ram", new ArrayList<>(Arrays.asList("Eric", "Tim", "George")));
        friendMap.put("George", new ArrayList<>(Arrays.asList("Eric", "Ram")));
        FindFriends obj = new FindFriends();
        System.out.println(obj.getAllFriends("Bob", friendMap));
        System.out.println(obj.getAllFriends("George", friendMap));

    }
}
