package BellmanFornEdgeList;

import java.util.Arrays;

public class BellmanFord {

    public static class Edge{
        double cost;
        int from, to;

        public Edge(int from,int to, double cost){
            this.cost = cost;
            this.from = from;
            this.to = to;
        }
    }

    public static double[] bellmanFordAlgorithm(Edge[] edge, int V, int start){
        double[] dist = new double[edge.length];
        Arrays.fill(dist,Double.POSITIVE_INFINITY);

        dist[start]=0;

        for(int v  = 0 ; v < V-1;v++){
            for(Edge e: edge){
                if(dist[e.to] > e.cost + dist[e.from]){
                    dist[e.to] = e.cost+dist[e.from];
                }
            }
        }

        for(int v  = 0 ; v < V-1;v++){
            for(Edge e: edge){
                if(dist[e.to] > e.cost + dist[e.from]){
                    dist[e.to] = Double.NEGATIVE_INFINITY;
                }
            }
        }

        return dist;
    }
}
