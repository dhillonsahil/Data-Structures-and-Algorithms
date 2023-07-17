package Week_11;
import java.util.*;

public class PrimsAlgorithm {
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

        graph[0].add(new Edge(0,1,10));
        graph[0].add(new Edge(0,2,15));
        graph[0].add(new Edge(0,3,30));


        graph[1].add(new Edge(1,0,10));
        graph[1].add(new Edge(1,3,40));
        
        graph[2].add(new Edge(2,0,15));
        graph[2].add(new Edge(2,3,50));
        
        graph[3].add(new Edge(3,1,40));
        graph[3].add(new Edge(3,2,50));
    }

    public static void main(String[] args) {
        int V = 6;

        ArrayList<Edge> graph[]= new ArrayList[V];
        createGraph(graph);
        primsAlgo(graph, V);
    }

    public static void primsAlgo(ArrayList<Edge> graph[], int V ){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean visited[] = new boolean[V];
        pq.add(new Pair(0, 0));
        int mstCost=0;
        while(!pq.isEmpty()){
            Pair current = pq.remove();
            if(!visited[current.node]){
                visited[current.node]=true;
                mstCost+=current.cost;

                for(int i=0;i<graph[current.node].size();i++){
                    Edge e = graph[current.node].get(i);
                    if(!visited[e.dest]){
                        pq.add(new Pair(e.dest, e.wt));
                    }
                }
            }
        }

        System.out.println("minimum cost of mst : "+mstCost);
    }

    static class Pair implements Comparable<Pair>{
        int node;
        int cost;
        public Pair(int n , int c){
            node=n;
            cost=c;
        }

        @Override
        public int compareTo(Pair p2){
           return  this.cost-p2.cost;
        }
    }
}