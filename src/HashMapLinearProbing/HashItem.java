package HashMapLinearProbing;

public class HashItem {

  private int data;
  private int key;

  public HashItem(int key, int data) {
    this.data = data;
    this.key = key;
  }

  public int getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }

  public int getKey() {
    return key;
  }

  public void setKey(int key) {
    this.key = key;
  }
}
