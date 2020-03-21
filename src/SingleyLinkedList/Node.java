package SingleyLinkedList;

public class Node {
  public int data;
  public Node next = null;

  public void display(){
    System.out.println (data+" ");
  }

  @Override
  public String toString() {
    return data+"";
  }
}
