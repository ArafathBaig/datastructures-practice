package BellManFord;

import javax.swing.*;
import java.util.List;

public class BellManFord {

    private List<Edge> edgeList;
    private List<Vertex> vertexList;

    public BellManFord(List<Edge> edgeList, List<Vertex> vertexList){
        this.edgeList = edgeList;
        this.vertexList = vertexList;
    }

    public void bellmanFordALgorithm(Vertex sourceVertex){

        sourceVertex.setDistance(0);
        for(int i =0 ; i < vertexList.size() -1; i++ ){

            for(Edge edge : edgeList){

                Vertex u = edge.getStartVertex();
                Vertex v = edge.getTargetVertex();

                if(u.getDistance() == Double.MAX_VALUE) continue;

                double newDistance = u.getDistance()  + edge.getWeight();

                if(newDistance < v.getDistance()){
                    v.setDistance(newDistance);
                    v.setPredecessor(u);
                }
            }
        }

        for(Edge edge : edgeList){
            if(isCycle(edge)){
                System.out.println("Cycle detected in the graph");
                return;
            }
        }
    }

    private boolean isCycle(Edge edge){
        return edge.getStartVertex().getDistance() + edge.getWeight() < edge.getTargetVertex().getDistance();
    }

    public void shortestPath(Vertex targetVertex) {

        if (targetVertex.getDistance() == Double.MAX_VALUE) {
            System.out.println("There is no path from the target vertex " + targetVertex.getName());
            return;
        }

        while(targetVertex != null){
            System.out.println(targetVertex+" ");
            targetVertex = targetVertex.getPredecessor();
        }

    }}
