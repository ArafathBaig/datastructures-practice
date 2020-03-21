package HashMapChaining;

public class App {
  public static void main(String[] args) {
    HashTable hash = new HashTable ();
    hash.put (1,100);
    hash.put (2,300);
    hash.put (3,900);
    hash.put (4,700);
    hash.put (5,100);
    hash.put (2,100);
    hash.put (2,300);

    System.out.println (hash.get (3) );
    System.out.println (hash.get (2) );

  }
}
