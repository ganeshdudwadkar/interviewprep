package leetcode.medium;

import java.util.*;

// Definition for undirected graph.
class GraphNode {
    public int val;
    public List<GraphNode> neighbors;

    public GraphNode() {
    }

    public GraphNode(int _val) {
        val = _val;
    }

    public GraphNode(int _val, List<GraphNode> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {

    public GraphNode cloneGraph(GraphNode node) {
        if (node == null) return null;
        Queue<GraphNode> q = new LinkedList<>();
        q.offer(node);

        // An HashMap to keep track of all the nodes which have already been created
        Map<GraphNode, GraphNode> hm = new HashMap<>();
        //Put the node into the HashMap
        hm.put(node, new GraphNode(node.val));

        while (!q.isEmpty()) {
            // Get the front node from the queue and then visit all its neighbours
            GraphNode u = q.poll();

            // Get corresponding Cloned Graph Node
            GraphNode cloneNodeU = hm.get(u);

            if (u.neighbors != null) {

                for (GraphNode graphNode : u.neighbors) {
                    // Get the corresponding cloned node
                    // If the node is not cloned then we will simply get a null
                    GraphNode cloneNodeG = hm.get(graphNode);

                    // Check if this node has already been created
                    if (cloneNodeG == null) {
                        q.add(graphNode);

                        // If not then create a new Node and put into the HashMap
                        cloneNodeG = new GraphNode(graphNode.val);
                        hm.put(graphNode, cloneNodeG);
                    }

                    // add the 'cloneNodeG' to neighbour list of the cloneNodeG
                    cloneNodeU.neighbors.add(cloneNodeG);
                }
            }
        }

        return hm.get(node);
    }

    // Recursive DFS solution

    public GraphNode cloneGraphRecursive(GraphNode node) {
        Map<Integer, GraphNode> map = new HashMap<>();
        return dfsCloneGraph(node, map);
    }

    private GraphNode dfsCloneGraph(GraphNode node, Map<Integer, GraphNode> map) {
        if (node == null) return null;

        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }
        GraphNode clone = new GraphNode(node.val);
        map.put(clone.val, clone);
        for (GraphNode neighbor : node.neighbors) {
            clone.neighbors.add(dfsCloneGraph(neighbor, map));
        }
        return clone;
    }
}
