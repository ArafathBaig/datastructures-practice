package Maximum.Heap;

public class App {
  public static void main(String[] args) {
    Heap heap = new Heap (10);
    heap.insert (1);
    heap.insert (23);
    heap.insert (56);
    heap.insert (3);
    heap.insert (10);
    heap.insert (-5);
    heap.insert (-6);

    System.out.println (heap.getMax () );
    System.out.println (heap.getMax () );
    System.out.println (heap.getMax () );
    System.out.println (heap.getMax () );

  }
}
