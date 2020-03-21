package com.arafath.AVLTree;

public class AVLTree implements Tree {

  private Node root;

  @Override
  public void insert(int data) {

    root = insertNode(root, data);

  }

  @Override
  public void delete(int data) {
    root = deleteNode(root,data);
  }

  private Node deleteNode(Node node ,int data){

    if(data < node.getData ()){
      node.setLeftNode (deleteNode (node.getLeftNode (), data));
    }else if(data>node.getData ()){
      node.setRightNode (deleteNode (node.getRightNode (), data));
    }else{

      //deleting the leafnode
      if(node.getLeftNode () == null && node.getRightNode () == null){
        System.out.println ("Removing the leaf node.." );
        return null;

      }

      if(node.getLeftNode () == null){
        System.out.println ("Removing the right child..." );
        Node temp = node.getRightNode();
        node = null;
        return temp;

      }else if(node.getRightNode () == null){
        System.out.println ("Removing the left child..." );
        Node temp = node.getLeftNode ();
        node = null;
        return temp;

      }

      System.out.println ("Removing the node with two childs..." );
      Node temp = getPredecessor(node.getLeftNode ());
      node.setData (temp.getData ());
      node.setLeftNode (deleteNode (node.getLeftNode (), temp.getData ()));
    }

    node.setHeight (Math.max(height (node.getLeftNode ()), height (node.getRightNode ()))+1);

    node = deleteViolation (node, data);
    return node;
  }

  private Node deleteViolation(Node node, int data){
    int balance = getBalance (node);

    if(balance>1){

      if(getBalance (node.getLeftNode ()) < 0){

        node.setLeftNode (leftRotation (node.getLeftNode ()));
      }


      return rightRotation (node);

    }

    if( balance < -1){

      if(getBalance (node.getRightNode ()) > 0){

        node.setRightNode (rightRotation (node.getRightNode ()));
      }


      return leftRotation (node);

    }

    return node;
  }

  private Node getPredecessor(Node node){
    if(node.getRightNode () == null) return node;

    return getPredecessor (node.getRightNode ());
  }

  private Node insertNode(Node node , int data){

    if(node == null){
      return new Node(data);
    }

    if(data < node.getData ()){
      node.setLeftNode (insertNode (node.getLeftNode (),data));
    }else{
      node.setRightNode (insertNode (node.getRightNode (), data));
    }

    node.setHeight (Math.max(height (node.getLeftNode ( )), height ( node. getRightNode ())) + 1);

    node = setViolation(node, data);

    return node;

    }


    private Node setViolation(Node node,int data){
      int balance = getBalance (node);

      //Case 1: Doubley left heavy situation
      if(balance>1 && data < node.getLeftNode ().getData ()){
        return rightRotation (node);
      }

      //DOubley right situation
      if(balance <-1 && data > node.getRightNode ().getData ()){
        return leftRotation (node);
      }

      //left right heavy situation
      if (balance > 1 && data > node.getLeftNode ().getData ()){
        node.setLeftNode (leftRotation (node.getLeftNode ()));
        return rightRotation (node);
      }

      //right left situation
      if(balance <-1 && data < node.getRightNode ().getData ()){
        node.setRightNode (rightRotation (node.getRightNode ()));
        return leftRotation (node);
      }

      return node;

      }

  private Node rightRotation(Node node){
    System.out.println ( "Rotating to the right: "+ node );

    Node tempNode = node.getLeftNode ();
    Node t = tempNode.getRightNode ();

    tempNode.setRightNode (node);
    node.setLeftNode (t);

    node.setHeight (Math.max(height(node.getLeftNode ()),height (node.getRightNode ())) + 1);
    tempNode.setHeight (Math.max(height (tempNode.getLeftNode ()), height (tempNode.getRightNode ()))+1);

    return tempNode;


  }

  private Node leftRotation(Node node){
    System.out.println ("Rotating to the left: "+ node );

    Node tempNode= node.getRightNode ();
    Node t = tempNode.getLeftNode ();

    tempNode.setLeftNode (node);
    node.setRightNode (t);

    node.setHeight (Math.max(height(node.getLeftNode ()),height (node.getRightNode ()))+1);
    tempNode.setHeight (Math.max(height (tempNode.getLeftNode ()), height (tempNode.getRightNode ()))+1);

    return tempNode;
  }

  private int height(Node node){
    if(node == null) return -1;

    return node.getHeight ();
  }


  private int getBalance(Node node){
    if(node == null) return 0;

    return height(node.getLeftNode ()) - height(node.getRightNode ());
  }

  @Override
  public void traversal() {

    if(root == null) return;

    inOrder(root);
    }

    private void inOrder(Node node){
    if(node.getLeftNode ()!=null){
      inOrder (node.getLeftNode ());
    }

      System.out.print(node+"-->" );

    if(node.getRightNode ()!= null){

      inOrder (node.getRightNode ());
    }
    }
}
