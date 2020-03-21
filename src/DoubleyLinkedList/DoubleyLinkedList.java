package DoubleyLinkedList;



public class DoubleyLinkedList {
  private Node first;
  private Node last;

  private boolean isEmpty(){
    return first == null;
  }

  public void insertFirst(int data){
    Node newNode = new Node();
    newNode.data = data;

    if(isEmpty ()){
      last = newNode;
    }else{
      first.prev = newNode;
    }

    newNode.next = first;
    this.first = newNode;
  }

  public void insertLast(int data){
    Node newNode = new Node();
    newNode.data = data;

    if(isEmpty ()){
      first = newNode;
    }else{
      last.next = newNode;
      newNode.prev = last;

    }
    this.last = newNode;
  }

  public Node deleteFirst(){
    Node temp = first;

    if(first.next == null){
      last = null;
    }else{
      first.next.prev = null;
    }

    first = first.next;
    return temp;
  }

  public Node deleteLast(){
    Node temp = last;

    if(first.next == null){
      first = null;
    }else{
      last.prev.next = null;
    }
    last = last.prev;
    return temp;
  }

  public Boolean insertAfter(int key, int data ){
    Node current = first;

    while(current.data != key){
      current = current.next;
      if(current == null){
        return false;
      }
    }

    Node node = new Node();
    node.data =  data;
    if(current == last){
      current.next = null;
      last = node;
    }else{
      node.next = current.next;
      current.next.prev= node;
    }

    node.prev = current;
    current.next = node;

    return true;

  }

  public Node deleteKey(int key){
    Node current = first;

    while(current.data != key){
      current = current.next;
      if(current == null){
        return null;
      }
    }

    if(current == first){
      first = current.next;
    }else{
      current.prev.next = current.next;
    }

    if(current == last){
      last = current.prev;
    }else{
      current.next.prev = current.prev;
    }

    return current;
  }

  public void displayF(){
    Node temp = first;
    while(temp!= null){
      temp.display ();
      temp= temp.next;
    }
  }

  public void displayB(){
    Node temp = last;
    while(temp!= null){
      temp.display ();
      temp= temp.prev;
    }
  }
}
