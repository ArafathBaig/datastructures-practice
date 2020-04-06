package CycleDetectionDFS;

import java.util.List;

public class CycleDetection {

    public void detectCycle(List<Vertex> vertexList){

        for(Vertex v : vertexList){
            if(!v.isVisited()){
                dfs(v);
            }
        }
    }

    private void dfs(Vertex v){

        v.setBeingVisited(true);

        for(Vertex va: v.getAdjancenciesList()) {
            if (va.isBeingVisited()) {
                System.out.println("There is a cycle");
                return;
            }

            if (!va.isVisited()) {
                va.setVisited(true);
                dfs(va);
            }
        }

            v.setBeingVisited(false);
            v.setVisited(true);
        }

}
