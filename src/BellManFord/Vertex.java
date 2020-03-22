package BellManFord;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private String name;
    private boolean visited;
    private double distance = Double.MAX_VALUE;
    private Vertex predecessor;
    private List<Edge> adjancaciesList;

    public Vertex(String name) {
        this.name = name;
        adjancaciesList = new ArrayList<>();
    }

    public void addNeighbour(Edge edge){
        this.adjancaciesList.add(edge);
    }

    @Override
    public String toString() {
        return this.name;
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

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    public List<Edge> getAdjancaciesList() {
        return adjancaciesList;
    }

    public void setAdjancaciesList(List<Edge> adjancaciesList) {
        this.adjancaciesList = adjancaciesList;
    }
}
