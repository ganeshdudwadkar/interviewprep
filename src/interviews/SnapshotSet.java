package interviews;

import common.Examples;

import java.io.*;
import java.util.*;

/*

Typically, when the iteration is in progress for a set, it doesn't let you modify the original set.
Develop a SnapshotSet class which will let you perform add remove operations even when the iteration is in progress.

   Add | Remove
    5  |
    6  |
       | . 5
    8  |
    ----- <- iterator 6,8
    3  |
       | .6

   At most one concurrent iterator
 */

class InUseException extends Exception{

}

public class SnapshotSet {
    private Set<Integer> set;
    private Set<Integer> snapshotSet;
    private boolean iterationInProgress;
    public SnapshotSet(){
        set = new HashSet<>();
        snapshotSet = new HashSet<>();
        iterationInProgress = false;
    }

    void add(int e){
        set.add(e);
    }

    void remove(int e){
        set.remove(e);
    }

    boolean contains(int e) {
        return set.contains(e);
    }

    Iterator<Integer> iterator() throws InUseException{
        if (iterationInProgress) throw new InUseException();
        snapshotSet.clear(); // reset every time
        snapshotSet.addAll(set);
        iterationInProgress = true;
        return snapshotSet.iterator();
    }

    // assume that this method will get called upon iterator closes
    private void onIteratorClose(){
        iterationInProgress = false;
    }

    public static void main(String[] args) throws InUseException {
        SnapshotSet s = new SnapshotSet();
        s.add(5);
        s.add(6);
        s.add(7);
        Iterator<Integer> it = s.iterator();
        while(it.hasNext()){
            System.out.println(it.next());

        }
        System.out.println("Done");
        s.remove(6);
        it = s.iterator();
        while(it.hasNext()){
            System.out.println(it.next());

        }
        System.out.println("Done");
        s.remove(5);
        s.add(5);
        s.add(8);
        System.out.println(s.contains(8));
        s.remove(8);
        it = s.iterator();
        while(it.hasNext()){
            System.out.println(it.next());

        }
        System.out.println("Done");
    }
}

/* -> works okay but complex and slow
public class SnapshotSet {
    private Set<Integer> set;
    private ArrayList<Integer> list, addList, remList;
    public SnapshotSet(){
        set = new HashSet<>();
        list = new ArrayList<Integer>();
        addList = new ArrayList<Integer>();
        remList = new ArrayList<Integer>();
    }

    void add(int e) {
        set.add(e);
        addList.add(e);
        if (remList.contains(e)){
            remList.remove((Integer) e);
        }

    }
    void remove(int e){
        if(set.contains(e)) {
            set.remove(e);
            if (addList.contains(e)){
                addList.remove((Integer) e);
            } else {
                remList.add(e);
            }
        }
    }
    boolean contains(int e) {
        return set.contains(e);
    }
    iterator<Integer> iterator(){
        // list.addAll(addList);
        for(int e: addList){
            if (list.contains(e)) continue;
            list.add(e);
        }
        addList.clear();
        list.removeAll(remList);
        remList.clear();
        return list.iterator();
    }

    private void onIteratorClose(){}

    public static void main(String[] args) {

        SnapshotSet s = new SnapshotSet();
        s.add(5);
        s.add(6);
        s.add(7);
        iterator<Integer> it = s.iterator();
        while(it.hasNext()){
            System.out.println(it.next());

        }
        System.out.println("Done");
        s.remove(6);
        it = s.iterator();
        while(it.hasNext()){
            System.out.println(it.next());

        }
        System.out.println("Done");
        s.remove(5);
        s.add(5);
        s.add(8);
        s.remove(8);
        it = s.iterator();
        while(it.hasNext()){
            System.out.println(it.next());

        }
        System.out.println("Done");
    }
}
*/