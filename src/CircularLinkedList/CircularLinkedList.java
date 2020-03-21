package CircularLinkedList;

public class CircularLinkedList {
  private Node first;
  private Node last;

  public void insertFirst(int data){
    Node newNode = new Node();
    newNode.data = data;

    if(first == null){
      last = newNode;
    }

    newNode.next = first;
    first = newNode;
  }

  public void insertLast(int data) {
    Node newNode = new Node ( );
    newNode.data = data;

    if (first == null) {
      first = newNode;
    } else {

      last.next = newNode;
      last = newNode;
    }
  }

  public Node deleteFirst(){
    if(first.next == null){
      last = null;
    }
    Node temp = first;
    first=first.next;
    return temp;
  }

  public Node deleteLast(){
    Node temp = first;
    Node prev = new Node ();

    while(temp.next!=null){
      prev = temp;
      temp = temp.next;
    }

    prev.next = null;
    last = prev;
    return temp;

  }

  public void display(){
    Node temp = first;
    while(temp!= null){
      temp.display ();
      temp= temp.next;
    }
  }
}
