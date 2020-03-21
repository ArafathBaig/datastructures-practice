package binarySearchTree;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

  private Node<T> root;


  @Override
  public void insertNode(T data) {
    if(root == null){
      root = new Node<T>(data);
    }else{
      insertNode (data, root);
    }
  }




  @Override
  public T getMaxValue() {
    if(root == null) return null;

    return getMax (root);
  }

  @Override
  public T getMinValue() {
    if(root == null) return null;
    return getMin (root);
  }

  private void insertNode(T data,Node<T> node) {

    if (data.compareTo (node.getData ( )) < 0) {
      if (node.getLeftChild ( ) != null) {
        insertNode (data, node.getLeftChild ( ));
      } else {
        Node<T> newNode = new Node<T> (data);
        node.setLeftChild (newNode);
      }
    }else{
      if(node.getRightChild () != null){
        insertNode(data, node.getRightChild ());
      }else{
        Node<T> newNode = new Node<T> (data);
        node.setRightChild (newNode);
      }
    }
  }

  private Node<T> deleteNode(Node<T> node, T data){
    if(root == null) return node;

    if(data.compareTo (node.getData ()) < 0){
      node.setLeftChild (deleteNode (node.getLeftChild (),data));
    }else if(data.compareTo (node.getData ())>0){
      node.setRightChild (deleteNode (node.getRightChild (),data));
    }else{

      if(node.getLeftChild () == null && node.getRightChild () == null){
        System.out.println ("Removing the leaf node....." );
        return null;
      }

      if(node.getLeftChild () == null){
        System.out.println ("Removing node with one right child..... " );
        Node<T> temp = node.getRightChild ();
        node = null;
        return temp;

      }else if( node.getRightChild () == null){
        System.out.println ("Removing node with one left child......" );
        Node<T> temp = node.getLeftChild ();
        node = null;
        return temp;
      }

      System.out.println ("Remooving node with two leaf childs....." );
      Node<T> temp = getPredecessor(node.getLeftChild ());
      node.setData (temp.getData ());

      node.setLeftChild (deleteNode (node.getLeftChild (), temp.getData ()));


    }
    return node;

  }

  private Node<T> getPredecessor(Node<T> node){
    if(node.getRightChild () != null) return getPredecessor (node.getRightChild ());

    return node;
  }

  @Override
  public void delete(T data) {

    if(root != null)
      root= deleteNode(root,data);



  }

  @Override
  public void traversal() {
    if(root != null)
      inOrderTraversal(root);

  }

  private void inOrderTraversal(Node<T> node){
    if(node.getLeftChild ()!= null){
      inOrderTraversal (node.getLeftChild ());
    }

    System.out.print(node+"-->" );

    if(node.getRightChild ()!= null){
      inOrderTraversal (node.getRightChild ());
    }
  }


  private T getMax(Node<T> node) {
    if(node.getRightChild () != null){
      return getMax (node.getRightChild ());
    }

    return node.getData ();
  }


  private T getMin(Node<T> node) {
    if(node.getLeftChild ()!=null){
      return  getMin (node.getLeftChild ());
    }
    return node.getData ();
  }
}
