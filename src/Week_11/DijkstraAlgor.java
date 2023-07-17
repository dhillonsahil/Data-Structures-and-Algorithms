package Week_11;
import java.util.*;

public class DijkstraAlgor {
    static class Edge{
        int wt; // weight
        int src; // vertex value
        int dest; // neighbour
        public Edge(int s, int d , int w){
            src=s;
            dest=d;
            wt=w;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]= new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3 ,7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    public static void main(String[] args) {
        int V = 6;

        ArrayList<Edge> graph[]= new ArrayList[V];
        createGraph(graph);

        Dijkstra(graph, 0, V);
    }

    // O(E + ElogV)  ---> n(logn)
    public static void Dijkstra(ArrayList<Edge> graph[],int src, int V){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int dist[]= new int[V];
        boolean visited[]= new boolean[V];


        // Initlialization
        for(int i=0;i<V;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }

        pq.add(new Pair(0, 0));

        while(!pq.isEmpty()){
            Pair current = pq.remove();
            if(!visited[current.node]){
                visited[current.node]=true;

                for(int i=0;i<graph[current.node].size() ; i++){
                    Edge e = graph[current.node].get(i);
                    int u=e.src;
                    int v= e.dest;
                    if(dist[u]+e.wt<dist[v]){
                        dist[v]=dist[u]+e.wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }


        // print distance
        for(int i:dist){
            System.out.print(i + " ");
        }

    }

    static class Pair implements Comparable<Pair>{
        int node;
        int dist;
        public Pair(int n , int d){
            node=n;
            dist=d;
        }

        @Override
        public int compareTo(Pair p2){
           return  this.dist-p2.dist;
        }
    }
}