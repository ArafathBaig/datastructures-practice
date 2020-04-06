package CycleDetectionDFS;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private String name;
    private boolean visited;
    private boolean isBeingVisited;
    private List<Vertex> adjancenciesList;
    public Vertex(String name){
        this.name = name;
        adjancenciesList = new ArrayList<>();
    }

    public void addNeighbour(Vertex v){
        this.adjancenciesList.add(v);
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isBeingVisited() {
        return isBeingVisited;
    }

    public void setBeingVisited(boolean beingVisited) {
        isBeingVisited = beingVisited;
    }

    public List<Vertex> getAdjancenciesList() {
        return adjancenciesList;
    }

    public void setAdjancenciesList(List<Vertex> adjancenciesList) {
        this.adjancenciesList = adjancenciesList;
    }
}
