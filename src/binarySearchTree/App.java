package binarySearchTree;

public class App {
  public static void main(String[] args) {

    Tree<Person> bst = new BinarySearchTree<> ();

    bst.insertNode (new Person (9,"John"));
    bst.insertNode (new Person (22,"Joseph"));
    bst.insertNode (new Person (27,"Raj"));
    bst.insertNode (new Person (32,"Chaco"));
    bst.insertNode (new Person (20,"Araf"));
    bst.insertNode (new Person (63,"Danzo"));
    bst.insertNode (new Person (14,"Sasuke"));

    bst.traversal ();

  }
}
