package DFSwithRecursion;

import java.util.List;
import java.util.Stack;

public class DFS{

  private Stack<Vertex> stack;

  public DFS() {
    this.stack = new Stack<Vertex> ();
  }

  public void dfs(List<Vertex> vertex){
    for(Vertex v: vertex){
      if(!v.isVisited ()){
        v.setVisited (true);
        dfsRecusive (v);
      }
    }
  }

  private void dfsRecusive(Vertex v){
    System.out.println (v+" " );

    for(Vertex a : v.getNeighbourList ()){
      if(!a.isVisited ()){
        a.setVisited (true);
        dfsRecusive (a);
      }
    }
  }

  private void dfsWithStack(Vertex root){

    stack.add (root);
    root.setVisited (true);

    while(!stack.empty ()){
      Vertex actualVertex = stack.pop ();
      System.out.println (actualVertex+" " );

      for(Vertex v: actualVertex.getNeighbourList ()){
        if(!v.isVisited ()){
          v.setVisited (true);
          stack.push (v);
        }
      }
    }


  }
}
