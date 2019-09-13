package leetcode.medium;

// Graph Valid Tree  (LC #261)

/*

Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

For example:

Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

--- Imp thing is to make sure all the nodes are connected using visited[] array.

 */

import java.util.ArrayList;
import java.util.List;

public class GraphValidTree {

    // The idea is to start with one node (and not all like in Topological Sort) and visit all the nodes.
    // If all nodes are not visited then it is not valid graph

    public boolean validTree(int n, int[][] edges) {
        // initialize adjacency list
        List<List<Integer>> adjList = new ArrayList<>(n);

        // initialize vertices
        for (int i = 0; i < n; i++)
            adjList.add(i, new ArrayList<>());

        // add edges
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        // make sure there's no cycle
        if (hasCycle(adjList, 0, visited, -1))
            return false;

        // make sure all vertices are connected
        for (int i = 0; i < n; i++) {
            if (!visited[i])
                return false;
        }

        return true;
    }

    // check if an undirected graph has cycle started from vertex u
    private boolean hasCycle(List<List<Integer>> adjList, int u, boolean[] visited, int parent) {
        visited[u] = true;

        for (int i = 0; i < adjList.get(u).size(); i++) {
            int v = adjList.get(u).get(i);

            if ((visited[v] && parent != v) || (!visited[v] && hasCycle(adjList, v, visited, u)))
                return true;
        }

        return false;
    }

    public static void main(String[] args){

        int[][] edges1 = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        int[][] edges2 = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};

        GraphValidTree obj = new GraphValidTree();
        System.out.println(obj.validTree(5, edges1));
        System.out.println(obj.validTree(5, edges2));

    }
}
