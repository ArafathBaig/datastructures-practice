package Queue;

public class App {
  public static void main(String[] args) {
    Queue q = new Queue(5);
    q.enqueue(5);
    q.enqueue(6);
    q.enqueue(7);
    q.enqueue(9);
    //    q.enqueue(10);

    q.dequeue();
    q.dequeue();

    q.dequeue();

    q.enqueue(8);
    //
    q.dequeue();
    q.enqueue(9);

    q.display();
  }
}
