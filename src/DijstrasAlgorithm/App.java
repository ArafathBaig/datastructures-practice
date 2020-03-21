package DijstrasAlgorithm;

public class App {

    public static void main(String[] args) {


        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Vertex c = new Vertex("c");

        a.addNeighbour(new Edge(1,a,b));
        a.addNeighbour(new Edge(3,a,c));
        b.addNeighbour(new Edge(1,b,c));

        Dijstras dj = new Dijstras();

        dj.computePath(a);
        System.out.println(dj.computeShortestPath(c));
    }
}