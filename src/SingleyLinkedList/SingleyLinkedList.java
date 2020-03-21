package SingleyLinkedList;

public class SingleyLinkedList {
  private Node head;

  private boolean isEmpty(){
    if(head == null){
      return true;
    }

    return  false;
  }

  public void insertFirst(int data){
    Node newNode = new Node ();
    newNode.data = data;
    newNode.next = head;
    head = newNode;
  }

  public void insertLast(int data){
    Node newNode = new Node ();
    newNode.data = data;

    Node temp = head;

    while(temp.next != null){
      temp = temp.next;
    }

    temp.next = newNode;
    newNode.next = null;
  }

  public Node deleteFirst(){
    if(isEmpty ()){
      return null;
    }

    Node temp = head;
    head = head.next;
    return temp;
  }

  public Node deleteLast(){
    Node temp = head;
    Node prev = new Node ();

    while(temp.next!=null){
      prev = temp;
      temp = temp.next;
    }

    prev.next = null;
    return temp;

  }

  public void display(){
    Node temp = head;
    while(temp!= null){
      temp.display ();
      temp= temp.next;
    }
  }

}
