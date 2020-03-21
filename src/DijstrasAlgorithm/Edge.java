package DijstrasAlgorithm;

public class Edge {
    private double weight;
    private Vertex startWeight;
    private Vertex targetVertex;

    public Edge(double weight, Vertex startWeight, Vertex targetVertex) {
        this.weight = weight;
        this.startWeight = startWeight;
        this.targetVertex = targetVertex;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Vertex getStartWeight() {
        return startWeight;
    }

    public void setStartWeight(Vertex startWeight) {
        this.startWeight = startWeight;
    }

    public Vertex getTargetVertex() {
        return targetVertex;
    }

    public void setTargetVertex(Vertex targetVertex) {
        this.targetVertex = targetVertex;
    }
}
