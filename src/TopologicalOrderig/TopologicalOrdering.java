package TopologicalOrderig;

import java.util.List;
import java.util.Stack;

public class TopologicalOrdering {

    private Stack<Vertex> stack;

    public TopologicalOrdering() {
        stack = new Stack<>();
    }

    public void DFS(Vertex vertex) {
        vertex.setVisited(true);
        for (Vertex v : vertex.getNeighbourList()) {
            if (!v.isVisited()) {
                DFS(v);
            }
        }
        stack.push(vertex);
    }

    public Stack<Vertex> getStack(){
        return this.stack;
    }
}
