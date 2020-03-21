package MazeSolver;

public class App {
  public static void main(String[] args) {
    FileReader fileReader = new FileReader ("/home/fauzan/projects/projects/datastructure/src/MazeSolver/slak.txt",5,5);
    fileReader.parseFile ();
    MazeSolver mazeSolver = new MazeSolver (fileReader.getMap (),fileReader.getStartPositionRow (),fileReader.getStartPositionCol ());
    mazeSolver.findWayOut();
  }
}
