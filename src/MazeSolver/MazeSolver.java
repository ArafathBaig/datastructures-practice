package MazeSolver;

public class MazeSolver {

  private int[][] maze;
  private boolean visited[][];
  private int startPositionRow;
  private int startPositionCol;

  public MazeSolver(int [][] maze , int row,int col){
    this.maze = maze;
    this.visited = new boolean[maze.length][maze.length];
    this.startPositionRow = row;
    this.startPositionCol = col;
  }

  public void findWayOut(){

    try{
        dfs(startPositionRow,startPositionCol);
      System.out.println ("No Solution found" );
    }catch (RuntimeException e){
      System.out.println ("Route found to exit" );
    }
  }

  private void dfs(int row,int col){
    System.out.println ("Visiting i= "+row+ " j = "+col );

    if(this.maze[row][col] ==3 ){
      throw new RuntimeException ();
    }

    int end = maze.length - 1;

    if(visited[row][col]){
      return;
    }else if(row<0 || row>=end){
      return;
    }else if(col<0 || col>=end){
      return;
    }else if(maze[row][col] == 1){
      return;
    }else{
      this.visited[row][col] = true;

      dfs(row+1,col);
      dfs(row,col+1);
      dfs(row-1,col);
      dfs(row,col-1);
    }
  }

}
