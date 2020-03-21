package DoubleyLinkedList;

public class Node {
  public int data;
  public Node next = null;
  public Node prev = null;

  public void display(){
    System.out.println (data+ " " );
  }

  @Override
  public String toString() {
    return data+" ";
  }
}
