package MazeSolver;

import java.io.File;
import java.util.Scanner;

public class FileReader {

  private int [][] map;
  private String filename;
  private int noOfRows;
  private int noOfCols;
  private int startPositionRow;
  private int startPositionCol;

  public FileReader(String filename, int noOfRows, int noOfCols){
    this.filename=filename;
    this.noOfRows = noOfRows;
    this.noOfCols = noOfCols;
  }
  public void parseFile(){

    try{
      Scanner scan = new Scanner (new File(this.filename));

      for(int i =0 ; i<noOfRows;i++){
        for(int j = 0; j<noOfCols;j++){

          map[i][j] = scan.nextInt ();

          if(map[i][j]==2){
            startPositionCol = j;
            startPositionRow = i;
          }
        }
      }

      scan.close ();


    }catch (Exception e){
      e.printStackTrace ();
    }
  }

  public int[][] getMap() {
    return map;
  }

  public int getStartPositionRow() {
    return startPositionRow;
  }

  public int getStartPositionCol() {
    return startPositionCol;
  }
}
