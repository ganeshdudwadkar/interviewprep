package leetcode.medium;

// https://leetcode.com/problems/flatten-nested-list-iterator/

/*

341. Flatten Nested List iterator

Given a nested list of integers, implement an iterator to flatten it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:

Input: [[1,1],2,[1,1]]
Output: [1,1,2,1,1]
Explanation: By calling next repeatedly until hasNext returns false,
             the order of elements returned by next should be: [1,1,2,1,1].
Example 2:

Input: [1,[4,[6]]]
Output: [1,4,6]
Explanation: By calling next repeatedly until hasNext returns false,
             the order of elements returned by next should be: [1,4,6].

 */

import java.util.Iterator;
import java.util.List;
import java.util.Stack;


// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}


public class NestedIterator implements Iterator<Integer> {
    private Stack<NestedInteger> stack = new Stack<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedInteger curr = stack.peek();
            if (curr.isInteger()) {
                return true;
            }
            stack.pop();
            for (int i = curr.getList().size() - 1; i >= 0; i--) {
                stack.push(curr.getList().get(i));
            }
        }
        return false;
    }
}

// Another Alternate Solution - complex but faster than above (4ms)

/*

public class NestedIterator implements iterator<Integer> {
    List<List<NestedInteger>> superList;
    List<Integer> countList;
    int level;
    List<NestedInteger> curList;
    int i;

    public NestedIterator(List<NestedInteger> nestedList) {
        superList = new ArrayList<>();
        countList = new ArrayList<>();
        level = 0;
        i = 0;
        curList = nestedList;
        superList.add(curList);
        countList.add(i);
    }

    @Override
    public Integer next() {
        countList.set(level, ++i);
        return curList.get(i - 1).getInteger();
    }

    @Override
    public boolean hasNext() {
        curList = superList.get(level);
        i = countList.get(level);
        while (i < curList.size() || level > 0) {
            while (i == curList.size() && level > 0) {
                superList.remove(level);
                countList.remove(level);
                level--;
                curList = superList.get(level);
                i = countList.get(level);
            }
            if (i == curList.size() && level == 0) return false;
            NestedInteger n = curList.get(i);
            if (n.isInteger()) {
                return true;
            }
            curList = n.getList();
            countList.set(level, ++i);
            level++;
            i = 0;
            superList.add(level, curList);
            countList.add(level, i);
        }
        return false;
    }
}
 */