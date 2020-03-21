package CircularLinkedList;

public class App {
  public static void main(String[] args) {
    CircularLinkedList list = new CircularLinkedList ();
    list.insertFirst(5);
    list.insertFirst(8);
    list.insertFirst(7);
    list.insertFirst(6);

    list.insertLast(11);
    list.insertLast(12);
    list.insertLast(13);
    list.insertLast(14);

    list.deleteFirst();
    list.deleteFirst();

    list.deleteLast();
    list.deleteLast();



    list.display();
  }
}
