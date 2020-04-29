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



        list.get(0).addNeighbour(list.get(1));

        list.get(1).addNeighbour(list.get(0));



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
