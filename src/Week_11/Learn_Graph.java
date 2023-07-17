package Week_11;
import java.util.*;

public class Learn_Graph {
    public static void main(String args[]) {
        Graph gph = new Graph(7);
        gph.addEdge(0, 1);
        gph.addEdge(0, 2);
        gph.addEdge(1, 0);
        gph.addEdge(1, 2);
        gph.addEdge(2, 0);
        gph.addEdge(2, 1);
        System.out.println(gph.checkCycleUndirected());
    }
}

class Graph {
    ArrayList<Integer>[] arr;
    int vertex;

    Graph(int n) {
        arr = new ArrayList[n];
        this.vertex = n;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<>();
        }
    }

    void addEdge(int v, int u) {
        arr[v].add(u);
    }

    // Depth First Search
    void dfs(int v) {
        boolean[] b = new boolean[arr.length];
        depthFirstSearch(v, b);
    }

    private void depthFirstSearch(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");
        Iterator<Integer> itr = arr[v].listIterator();
        while (itr.hasNext()) {
            int n = itr.next();
            if (!visited[n]) {
                depthFirstSearch(n, visited);
            }
        }
    }

    // Breadth First Search
    void bfs(int v) {
        boolean visited[] = new boolean[vertex];
        binaryFirstSearch(v, visited);
    }

    private void binaryFirstSearch(int v, boolean visited[]) {
        visited[v] = true;
        Queue<Integer> queue = new LinkedList<>();
        visited[v] = true;
        queue.add(v);
        while (!queue.isEmpty()) {
            int n = queue.poll();
            System.out.print(n + " ");
            Iterator<Integer> itr = arr[n].listIterator();
            while (itr.hasNext()) {
                int a = itr.next();
                if (!visited[a]) {
                    visited[a] = true;
                    queue.add(a);
                }
            }
        }
        System.out.println();
    }

    // Finding All paths from src to target
    public void allPaths(int v, int target) {
        String path = "" + v + " ";
        findPath(v, new boolean[arr.length], path, target);
    }

    private void findPath(int v, boolean visited[], String path, int target) {
        visited[v] = true;
        if (v == target) {
            System.out.println(path);
            visited[v] = false;
            return;
        }
        Iterator<Integer> itr = arr[v].listIterator();
        while (itr.hasNext()) {
            int n = itr.next();
            if (!visited[n]) {
                findPath(n, visited, path + n + " ", target);
            }
        }
        visited[v] = false;
    }

    // Cycle Detection Program directed Graph
    void checkCycleDirected(int v) {
        Stack<Integer> stack = new Stack<>();
        boolean b = findCycleDirected(v, new boolean[arr.length], stack);
        if (b) {
            System.out.println("Cycle Detected");
        } else {
            System.out.println("No Cycle Found");
        }

    }

    private boolean findCycleDirected(int v, boolean visited[], Stack<Integer> stack) {
        if (stack.contains(v)) {
            return true;
        }
        visited[v] = true;
        stack.add(v);
        Iterator<Integer> itr = arr[v].listIterator();

        while (itr.hasNext()) {
            int n = itr.next();
            if (!visited[n]) {
                return findCycleDirected(n, visited, stack);
            } else {
                return true;
            }
        }
        //
        return false;
    }

    // topological Sort Using Dfs
    public void topologicalSort() {
        Stack<Integer> st = new Stack<>();
        boolean visited[] = new boolean[vertex];

        for (int i = 0; i < vertex; i++) {
            if (!visited[i]) {
                dfsTopo(i, visited, st);
            }
        }

        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
    }

    private void dfsTopo(int current, boolean visited[], Stack<Integer> stack) {
        visited[current] = true;

        for (int neighbor : arr[current]) {
            if (!visited[neighbor]) {
                dfsTopo(neighbor, visited, stack);
            }
        }
        stack.push(current);
    }

    // Cycle Detection Undirected Graph\
    boolean checkCycleUndirected() {
        return findCycleUnDirected(0, 0, new boolean[vertex]);
    }

    private boolean findCycleUnDirected(int current, int parrent, boolean visited[]) {
        visited[current] = true;
        Iterator<Integer> itr = arr[current].listIterator();
        while (itr.hasNext()) {
            int n = itr.next();
            if (visited[n] == true && n != parrent) {
                return true;
                // System.out.println(false);
            } else if (visited[n] != true) {
                return findCycleUnDirected(n, current, visited);
            }
        }

        return false;
    }
}