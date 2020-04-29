package Krushkal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {

    public void spanningTree(List<Vertex> vertexList, List<Edge> edgeList){
        DisjointSet dj = new DisjointSet(vertexList);

        List<Edge> mst = new ArrayList<>();
        Collections.sort(edgeList);

        for(Edge edge : edgeList){

            Vertex u = edge.getStartVertex();
            Vertex v = edge.getTargetVertex();

            if(dj.find(u.getNode()) != dj.find(v.getNode())){
                mst.add(edge);

                dj.union(u.getNode(), v.getNode());
            }
        }

        for(Edge edge : mst){
            System.out.println(edge.getStartVertex()+ "   " + edge.getTargetVertex()+"---");
        }
    }
}
