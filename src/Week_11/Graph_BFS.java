package Week_11;
import java.util.*;

public class Graph_BFS {
    public static void main(String[] args) {
        int v=4;
        Graph gph = new Graph(v);
        gph.addEdge(0, 1);
        gph.addEdge(0, 2);
        gph.addEdge(1,2 );
        gph.addEdge(1,0 );
        gph.addEdge(2, 0);
        gph.addEdge(2, 3);
        gph.addEdge(3, 3);
        System.out.println("BFS TRAVERSAL : ");
        gph.BFS_traversal(1);
    }
}
class Graph{
    private int v;
    LinkedList<Integer> adj[];

    @SuppressWarnings("unchecked") public Graph(int v){
        this.v=v;
        adj = new LinkedList[v];
        for(int i=0;i<v;++i){
            adj[i]=new LinkedList<>();
        }
    }

    public void addEdge(int v,int u){
        adj[v].add(u);
    }

    public void BFS_traversal(int s){
        boolean visited[]=new boolean[v];
        Queue<Integer> queue= new LinkedList<>();
        visited[s]=true;

        queue.add(s);
        while(!queue.isEmpty()){
            s=queue.poll();
            System.out.print(s + " ");
            Iterator<Integer> itr = adj[s].listIterator();
            while(itr.hasNext()){
                int n=itr.next();
                if(!visited[n]){
                    visited[n]=true;
                    queue.add(n);
                }
            }
        }
    }
}