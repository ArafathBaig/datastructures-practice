package binarySearchTree;

public interface Tree<T> {

  public void insertNode(T data);
  public void delete(T data);
  public void traversal();
  public T getMaxValue();
  public T getMinValue();
}
