package DijstrasAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Dijstras {

    public void computePath(Vertex sourceVertex){
        sourceVertex.setDistance(0);
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(sourceVertex);

        while(!priorityQueue.isEmpty()){

            Vertex actualVertex = priorityQueue.poll();

            for(Edge edge : actualVertex.getAdjcanciesList()){
                Vertex v = edge.getTargetVertex();

                double newDistance = actualVertex.getDistance() + edge.getWeight();

                if(newDistance < v.getDistance()){
                    priorityQueue.remove(v);
                    v.setDistance(newDistance);
                    v.setPredecessor(actualVertex);
                    priorityQueue.add(v);
                }
            }
        }
    }

    public List<Vertex> computeShortestPath(Vertex targetVertex){

        List<Vertex> shortestPathToTarget = new ArrayList<>();

        for(Vertex v = targetVertex ; v != null ; v = v.getPredecessor()){
            shortestPathToTarget.add(v);
        }

        return shortestPathToTarget;
    }
}
