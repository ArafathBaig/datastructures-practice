package TopologicalOrderig;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class App {

    public static void main(String[] args) {


        TopologicalOrdering topologicalOrdering = new TopologicalOrdering();

        List<Vertex> list = new ArrayList<>();
        list.add(new Vertex("0"));
        list.add(new Vertex("1"));
        list.add(new Vertex("2"));
        list.add(new Vertex("3"));
        list.add(new Vertex("4"));
        list.add(new Vertex("5"));

        list.get(2).addNeighbour(list.get(3));

        list.get(3).addNeighbour(list.get(1));

        list.get(4).addNeighbour(list.get(0));
        list.get(4).addNeighbour(list.get(1));

        list.get(5).addNeighbour(list.get(0));
        list.get(5).addNeighbour(list.get(2));

        for(int i= 0; i < list.size() ;++i){
            if(!list.get(i).isVisited()){
                topologicalOrdering.DFS((list.get(i)));
            }
        }

        Stack<Vertex> stack = topologicalOrdering.getStack();

        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
