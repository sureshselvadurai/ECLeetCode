package solutions;
import java.util.*;

//Problem 1 : 797. All Paths From Source to Target (Medium)
//Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.
//The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
//    Reference : https://leetcode.com/problems/all-paths-from-source-to-target/description/

//Problem 2 : 1557. Minimum Number of Vertices to Reach All Nodes (Medium)
//Given a directed acyclic graph, with n vertices numbered from 0 to n-1, and an array edges where edges[i] = [fromi, toi] represents a directed edge from node fromi to node toi.
//Find the smallest set of vertices from which all nodes in the graph are reachable. It's guaranteed that a unique solution exists.
//Notice that you can return the vertices in any order.
//    Reference : https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/description/

public class EC10 {

//    Problem 1
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        dfs(graph, 0, graph.length - 1, currentPath, result);
        return result;
    }

    private static void dfs(int[][] graph, int currentNode, int target, List<Integer> currentPath, List<List<Integer>> result) {
        currentPath.add(currentNode);

        if (currentNode == target) {
            result.add(new ArrayList<>(currentPath));
        } else {
            for (int nextNode : graph[currentNode]) {
                dfs(graph, nextNode, target, currentPath, result);
            }
        }

        currentPath.remove(currentPath.size() - 1);
    }

    private static void printPaths(List<List<Integer>> paths) {
        for (List<Integer> path : paths) {
            System.out.println(path);
        }
    }

//    Problem 2
    public static List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Set<Integer> reachable = new HashSet<>();

        for (List<Integer> edge : edges) {
            reachable.add(edge.get(1));
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!reachable.contains(i)) {
                result.add(i);
            }
        }

        return result;
    }
    public static void main(String[] args) {

        int[][] graph1 = {{1,2},{3},{3},{}};
        List<List<Integer>> result1 = allPathsSourceTarget(graph1);
        printPaths(result1);

        int n1 = 6;
        List<List<Integer>> edges1 = new ArrayList<>();
        edges1.add(Arrays.asList(0, 1));
        edges1.add(Arrays.asList(0, 2));
        edges1.add(Arrays.asList(2, 5));
        edges1.add(Arrays.asList(3, 4));
        edges1.add(Arrays.asList(4, 2));
        List<Integer> result2 = findSmallestSetOfVertices(n1, edges1);
        System.out.println("Example 1 Output: " + result1);

    }

}
