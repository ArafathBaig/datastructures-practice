package RedBLackTree;

public class RedBlackTree implements Tree {

  private Node root;


  @Override
  public void traverse() {

    if(root == null) return;

    inOrder(root);

  }

  private void rightRotation(Node node){

    System.out.println ("Rotating to the right at node: "+ node );
    Node temp = node.getLeftNode ();
    node.setLeftNode (temp.getRightNode ());

    if(node.getLeftNode () != null){
      node.getLeftNode ().setParent (node);
    }

    temp.setParent (node.getParent ());

    if(temp.getParent () == null)
      root = temp;
    else if(node == node.getParent ().getLeftNode ()){
      node.getParent ().setLeftNode (temp);
    }else {
      node.getParent ().setRightNode (temp);
    }

    temp.setRightNode (node);
    node.setParent (temp);
  }

  private void leftRotation(Node node) {

    System.out.println ("Rotating to the left at node: "+ node );
    Node temp = node.getRightNode ();
    node.setRightNode (temp.getLeftNode ());

    if(node.getRightNode () != null){
      node.getRightNode ().setParent (node);
    }

    temp.setParent (node.getParent ());

    if(temp.getParent () == null){
      root = temp;
    }else if(node == node.getParent ().getLeftNode ()){
      node.getParent ().setLeftNode (temp);
    }else{
      node.getParent ().setRightNode (temp);
    }

    temp.setLeftNode (node);
    node.setParent (temp);
  }



  private void inOrder(Node node){
    if(node.getLeftNode () !=  null){
      inOrder (node.getLeftNode ());
    }

    System.out.println (node+" ");

    if(node.getRightNode ()!= null){
      inOrder (node.getRightNode ());
    }
  }

  @Override
  public void insert(int data) {
      Node node = new Node (data);

      root= insertIntoTree(root,node);

      fixViolations(node);
  }

  private void fixViolations(Node node) {

    Node parentNode = null;
    Node grandParentNode = null;

    while( node != root && node.getColor() != NodeColor.BLACK && node.getParent().getColor() == NodeColor.RED ) {

      parentNode = node.getParent();
      grandParentNode = node.getParent().getParent();

      if( parentNode == grandParentNode.getLeftNode() ) {

        Node uncle = grandParentNode.getRightNode();

        // given node x's parent is a left child + uncle is red --> only recoloring
        if( uncle != null && uncle.getColor() == NodeColor.RED ) {
          grandParentNode.setColor(NodeColor.RED);
          parentNode.setColor(NodeColor.BLACK);
          uncle.setColor(NodeColor.BLACK);
          node = grandParentNode; // this will be the x after the recoloring because we have to check whether
          // the properties are violated or not
        } else {

          if( node == parentNode.getRightNode() ) {
            leftRotation(parentNode);
            node = parentNode;
            parentNode = node.getParent();
          }

          rightRotation(grandParentNode);
          System.out.println("Recoroling "+parentNode+" + "+grandParentNode);
          NodeColor tempColor = parentNode.getColor();
          parentNode.setColor(grandParentNode.getColor());
          grandParentNode.setColor(tempColor);
          node = parentNode;
        }
      } else {

        Node uncle = grandParentNode.getLeftNode();

        if( uncle != null && uncle.getColor() == NodeColor.RED ) {
          grandParentNode.setColor(NodeColor.RED);
          parentNode.setColor(NodeColor.BLACK);
          uncle.setColor(NodeColor.BLACK);
          node = grandParentNode;
        } else {

          if( node == parentNode.getLeftNode()) {
            rightRotation(parentNode);
            node = parentNode;
            parentNode = node.getParent();
          }
          leftRotation(grandParentNode);
          System.out.println("Recoroling "+parentNode+" + "+grandParentNode);
          NodeColor tempColor = parentNode.getColor();
          parentNode.setColor(grandParentNode.getColor());
          grandParentNode.setColor(tempColor);
          node = parentNode;
        }
      }
    }

    if( root.getColor() == NodeColor.RED ) {
      System.out.println("Recoloring the root to black...");
      root.setColor(NodeColor.BLACK);
    }
  }

  private Node insertIntoTree(Node root, Node node){
    if(root == null) return node;

    if(node.getData () < root.getData ()){
      root.setLeftNode (insertIntoTree (root.getLeftNode () , node));
      root.getLeftNode ().setParent (root);
    }else if(node.getData () > root.getData ()){
      root.setRightNode (insertIntoTree (root.getRightNode (),node));
      root.getRightNode ().setParent (root);
    }


    return root;

  }
}
