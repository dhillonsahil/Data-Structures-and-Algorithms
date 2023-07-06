package Week_11;
import java.util.*;

public class Graph_DFS {
    public static void main(String[] args) {
        int v=4;
        Graph gph = new Graph(v);
        boolean visited[]=new boolean[v];
        gph.addEdge(0, 1);
        gph.addEdge(0, 2);
        gph.addEdge(1,2 );
        gph.addEdge(1,0 );
        gph.addEdge(2, 0);
        gph.addEdge(2, 3);
        gph.addEdge(3, 3);
        System.out.println("DFS FROM VERTEX 1 : ");
        gph.Dfs_traversal(1, visited);
        System.out.println();
        System.out.println("DFS FROM VERTEX 2 : ");
        gph.Dfs_traversal(2, new boolean[v]);
        System.out.println();
        System.out.println("DFS FROM VERTEX  3: ");
        gph.Dfs_traversal(3, new boolean[v]);
        System.out.println();
        System.out.println("DFS FROM VERTEX  0: ");
        gph.Dfs_traversal(0, new boolean[v]);

    }
}
class Graph{
    private int v;
    LinkedList<Integer> adj[];

    @SuppressWarnings("unchecked") public Graph(int v){
        this.v=v;
        adj = new LinkedList[v];
        for(int i=0;i<v;i++){
            adj[i]=new LinkedList<>();
        }
    }

    public void addEdge(int v,int u){
        adj[v].add(u);
    }

    public void Dfs_traversal(int v,boolean visited[]){
        visited[v]=true;
        System.out.print(v + " ");
        Iterator<Integer> itr= adj[v].listIterator();
        while(itr.hasNext() ){
            int n=itr.next();
            if(!visited[n]){
                Dfs_traversal(n, visited);
            }
        }
    }
}