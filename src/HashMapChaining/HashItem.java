package HashMapChaining;

public class HashItem {

  private int key;
  private int data;
  private HashItem nextHashItem;

  public HashItem(int key, int data) {
    this.key = key;
    this.data = data;
  }

  public int getKey() {
    return key;
  }

  public void setKey(int key) {
    this.key = key;
  }

  public int getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }

  public HashItem getNextHashItem() {
    return nextHashItem;
  }

  public void setNextHashItem(HashItem nextHashItem) {
    this.nextHashItem = nextHashItem;
  }
}
