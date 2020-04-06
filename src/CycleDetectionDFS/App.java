package CycleDetectionDFS;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {


        Vertex vertex1 = new Vertex("1");
        Vertex vertex2 = new Vertex("2");
        Vertex vertex3 = new Vertex("3");
        Vertex vertex4 = new Vertex("4");
        Vertex vertex5 = new Vertex("5");
        Vertex vertex6 = new Vertex("6");

        vertex1.addNeighbour(vertex2);
        vertex2.addNeighbour(vertex4);
        vertex2.addNeighbour(vertex5);
        vertex4.addNeighbour(vertex3);
        vertex4.addNeighbour(vertex6);
        vertex5.addNeighbour(vertex1);

        List<Vertex> vertex = new ArrayList<>();
        vertex.add(vertex1);
        vertex.add(vertex2);
        vertex.add(vertex3);
        vertex.add(vertex4);
        vertex.add(vertex5);
        vertex.add(vertex6);

        CycleDetection cd = new CycleDetection();
        cd.detectCycle(vertex);
    }
}