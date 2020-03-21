package DFSwithRecursion;

import java.util.ArrayList;
import java.util.List;

public class App {
  public static void main(String[] args) {
    DFS dfs = new DFS ();
    Vertex vertex1 = new Vertex ("v1");
    Vertex vertex2 = new Vertex ("v2");
    Vertex vertex3 = new Vertex ("v3");
    Vertex vertex4 = new Vertex ("v4");
    Vertex vertex5 = new Vertex ("v5");

    List<Vertex> list = new ArrayList<> ( );

    vertex1.addNeighbourList (vertex2);
    vertex1.addNeighbourList (vertex3);
    vertex3.addNeighbourList (vertex4);
    vertex4.addNeighbourList (vertex5);

    list.add (vertex1);
    list.add (vertex2);
    list.add (vertex3);
    list.add (vertex4);
    list.add (vertex5);

    dfs.dfs (list);



  }
}
