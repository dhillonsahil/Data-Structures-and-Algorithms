package Week_11;
import java.util.*;

class Graph {
    private int V; // number of vertices
    private LinkedList<Integer>[] adj; // adjacency list

    public Graph(int V) {
        this.V = V;
        adj = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public void topologicalSort() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        // Perform DFS for each unvisited vertex
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, visited, stack);
            }
        }

        // Print the contents of the stack
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private void dfs(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;

        // Recursively visit all unvisited neighbors
        for (int neighbor : adj[v]) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, stack);
            }
        }

        // Push the current vertex to the stack
        stack.push(v);
    }
}

public class TopoLogicalSort {
    public static void main(String[] args) {
        int V = 6;
        Graph graph = new Graph(V);

        // Add edges
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        System.out.println("Topological Sort:");
        graph.topologicalSort();
    }
}
